/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.MesaRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.Ubicacion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author sebas
 */

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    /**
     * Devuelve la lista de mesas disponibles en una fecha y hora específica.
     * La reserva dura 2 horas, por lo que se calcula la hora de fin de la reserva.
     *
     * @param fechaReserva Fecha en la que se quiere hacer la reserva.
     * @param horaInicio   Hora de inicio de la reserva.
     * @return Lista de mesas disponibles.
     */

    /**
     * Encuentra mesas según su capacidad.
     *
     * @param capacidad Capacidad mínima de las mesas.
     * @return Lista de mesas con la capacidad solicitada.
     */
    public List<Mesa> getMesasByCapacidad(int capacidad) {
        return mesaRepository.findByCapacidad(capacidad);
    }

    /**
     * Encuentra mesas disponibles.
     *
     * @return Lista de mesas disponibles.
     */
    public List<Mesa> getMesasDisponibles() {
        return mesaRepository.findByDisponibilidad(true);
    }

    /**
     * Encuentra mesas por ubicación.
     *
     * @param ubicacion Ubicación de las mesas.
     * @return Lista de mesas en la ubicación solicitada.
     */
    public List<Mesa> getMesasByUbicacion(String ubicacion) {
        return mesaRepository.findByUbicacion(ubicacion);
    }

    /**
     * Actualiza el estado de disponibilidad de una mesa.
     *
     * @param mesaId          ID de la mesa.
     * @param disponibilidad  Nuevo estado de disponibilidad.
     */
    public void actualizarDisponibilidadMesa(int mesaId, boolean disponibilidad) {
        Mesa mesa = mesaRepository.findById(mesaId).orElseThrow(() -> new IllegalArgumentException("Mesa no encontrada"));
        mesa.setDisponibilidad(disponibilidad);
        mesaRepository.save(mesa);
    }

    /**
     * Bloquea una mesa, estableciendo su disponibilidad como false.
     *
     * @param mesaId ID de la mesa que se quiere bloquear.
     */
    public void bloquearMesa(int mesaId) {
        actualizarDisponibilidadMesa(mesaId, false);
    }

    /**
     * Desbloquea una mesa, estableciendo su disponibilidad como true.
     *
     * @param mesaId ID de la mesa que se quiere desbloquear.
     */
    public void desbloquearMesa(int mesaId) {
        actualizarDisponibilidadMesa(mesaId, true);
    }

    /**
     * Crea una nueva mesa en el sistema.
     *
     * @param mesa Mesa que se quiere crear.
     */
    public void crearMesa(Mesa mesa) {
        mesaRepository.save(mesa);
    }

    /**
     * Configura las propiedades de una mesa.
     *
     * @param mesaId      ID de la mesa a configurar.
     * @param capacidad   Capacidad de la mesa.
     * @param ubicacion   Ubicación de la mesa.
     * @param disponibilidad Disponibilidad de la mesa.
     */
    public void configurarMesa(int mesaId, int capacidad, Ubicacion ubicacion, boolean disponibilidad) {
        Mesa mesa = mesaRepository.findById(mesaId).orElseThrow(() -> new IllegalArgumentException("Mesa no encontrada"));
        mesa.setCapacidad(capacidad);
        mesa.setUbicacion(ubicacion);
        mesa.setDisponibilidad(disponibilidad);
        mesaRepository.save(mesa);
    }
    
    public Mesa getMesaById(int mesaId){
        return mesaRepository.findById(mesaId)
        .orElseThrow(() -> new EntityNotFoundException("Mesa con el id no existe: " + mesaId));
    }
    
    public List<Mesa> getMesasDisponibles(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
    return mesaRepository.findMesasDisponibles(fechaHoraInicio, fechaHoraFin);
}
}
