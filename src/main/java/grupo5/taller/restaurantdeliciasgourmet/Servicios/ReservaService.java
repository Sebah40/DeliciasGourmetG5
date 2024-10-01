/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ClienteRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.MesaRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ReservaRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.EstadoReserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.Reserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private MesaService mesaService;



    public void hacerReserva(int mesaId, int clienteId, TarjetaCredito tarjeta, LocalDate fechaReserva, LocalTime horaInicio) throws Exception {
        LocalTime horaFin = getHoraFin(horaInicio);

        List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles();
        Mesa mesa = mesaRepository.findById(mesaId).orElseThrow(() -> new Exception("Mesa no encontrada"));
        System.out.println("MESA PEDIDA: " + mesa);
        System.out.println("MESAS ENCONTRADASS" + mesasDisponibles);
        System.out.println(mesasDisponibles.contains(mesa));
        if (!mesasDisponibles.contains(mesa)) {
            throw new Exception("La mesa seleccionada no está disponible en el horario elegido.");
        }

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new Exception("Cliente no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setMesa(mesa);
        reserva.setCliente(cliente);
        reserva.setFechaReserva(fechaReserva);
        reserva.setHoraInicio(horaInicio);
        reserva.setHoraFin(horaFin);
        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        reserva.setTarjeta(tarjeta);

        reservaRepository.save(reserva);
    }

    public void hacerReserva(Reserva reserva) throws Exception {
            LocalTime horaInicio = reserva.getHoraInicio();
            LocalTime horaFin = getHoraFin(horaInicio);
            LocalDate fechaReserva = reserva.getFechaReserva();
            Mesa mesa = reserva.getMesa();
            Cliente cliente = reserva.getCliente();
        try {
            List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles(fechaReserva, horaInicio);
            if (!mesasDisponibles.contains(mesa)) {
                System.out.println("MESAS DISPONIBLES: " + mesasDisponibles.toString());
                System.out.println("MESAAA: " +mesa);
                System.out.println("DEBUGGING FECHA:"+fechaReserva + "HORAAA : " + horaInicio);
                throw new Exception("La mesa seleccionada no está disponible en el horario elegido.");
            }
            reserva.setHoraFin(horaFin);
            reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
            reservaRepository.save(reserva);
        } catch (Exception e) {
            System.out.println("Error al hacer la reserva: " + e.getMessage());
        }
    }
    private LocalTime getHoraFin(LocalTime horaInicio){
        return horaInicio.plusHours(2);                                 //La reserva dura 2 horas
    }
}
