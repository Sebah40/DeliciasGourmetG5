/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ClienteRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.MesaRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ReservaRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.TarjetaCreditoRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.EstadoReserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.Reserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    
    @Autowired
    private TarjetaCreditoRepository tarjetaRepository;



    public void hacerReserva(int mesaId, int clienteId, TarjetaCredito tarjeta, LocalDate fechaReserva, LocalDateTime fechaHoraInicio) throws Exception {
        LocalDateTime fechaHoraFin = getFechaHoraFin(fechaHoraInicio);

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
        reserva.setFechaHoraInicio(fechaHoraInicio);
        reserva.setFechaHoraFin(fechaHoraFin);
        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        reserva.setTarjeta(tarjeta);

        reservaRepository.save(reserva);
    }
    
    public void bloquearMesa(int mesaId, LocalDate fechaReserva, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) throws Exception {
        List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles();
        Mesa mesa = mesaRepository.findById(mesaId).orElseThrow(() -> new Exception("Mesa no encontrada"));
        System.out.println("MESA PEDIDA: " + mesa);
        System.out.println("MESAS ENCONTRADASS" + mesasDisponibles);
        System.out.println(mesasDisponibles.contains(mesa));
        if (!mesasDisponibles.contains(mesa)) {
            throw new Exception("La mesa seleccionada no está disponible en el horario elegido.");
        }

        Cliente cliente = clienteRepository.findById(1)
                .orElseThrow(() -> new Exception("Cliente no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setMesa(mesa);
        reserva.setCliente(cliente);
        reserva.setFechaReserva(fechaReserva);
        reserva.setFechaHoraInicio(fechaHoraInicio);
        reserva.setFechaHoraFin(fechaHoraFin);
        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        reserva.setTarjeta(tarjetaRepository.findByNumeroTarjeta("8888888888888"));
        reservaRepository.save(reserva);
    }

    public void hacerReserva(Reserva reserva) throws Exception {
    LocalDateTime fechaHoraInicio = reserva.getFechaHoraInicio();
    LocalDateTime horaFin = getFechaHoraFin(fechaHoraInicio);
    Mesa mesa = reserva.getMesa();

    try {
        List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles(fechaHoraInicio, horaFin);
        
        System.out.println("MESAS DISPONIBLES: " + mesasDisponibles.toString());
        System.out.println("MESAAA: " + mesa);
        System.out.println("DEBUGGING FECHA: " + reserva.getFechaReserva() + " HORA: " + fechaHoraInicio);

        if (!mesasDisponibles.contains(mesa)) {
            throw new Exception("La mesa seleccionada no está disponible en el horario elegido.");
        }

        reserva.setFechaHoraFin(horaFin);
        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        reservaRepository.save(reserva);
    } catch (Exception e) {
        System.out.println("Error al hacer la reserva: " + e.getMessage());
        throw e;
    }
}
    private LocalDateTime getFechaHoraFin(LocalDateTime fechaHoraInicio){
        return fechaHoraInicio.plusHours(2);                             //La reserva dura 2 horas
    }
    
    public List<Reserva> getReservasFromCliente(int clienteId) {
        return reservaRepository.findByCliente_ClienteId(clienteId);
    }
    
    public void cancelarReserva(int reservaId) throws Exception {
    Reserva reserva = reservaRepository.findById(reservaId)
            .orElseThrow(() -> new Exception("Reserva no encontrada"));
    reserva.setEstadoReserva(EstadoReserva.CANCELADA);
    reservaRepository.save(reserva);
}
}
