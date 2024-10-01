/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Repositorios;

import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebas
 */
@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    
//        @Query("SELECT m FROM Mesa m WHERE m.id NOT IN (" +
//           "SELECT r.mesa.id FROM Reserva r WHERE r.fechaReserva = :fechaReserva " +
//           "AND ((r.horaInicio <= :horaFin AND r.horaFin >= :horaInicio)))")
//    List<Mesa> findMesasDisponibles(
//        @Param("fechaReserva") LocalDate fechaReserva,
//        @Param("horaInicio") LocalTime horaInicio,
//        @Param("horaFin") LocalTime horaFin
//    );
    @Query("SELECT m FROM Mesa m WHERE m.numeroMesa NOT IN (" +
       "SELECT r.mesa.numeroMesa FROM Reserva r WHERE r.fechaReserva = :fechaReserva " +
       "AND (r.horaInicio < :horaFin AND r.horaFin > :horaInicio))")
List<Mesa> findMesasDisponibles(
    @Param("fechaReserva") LocalDate fechaReserva,
    @Param("horaInicio") LocalTime horaInicio,
    @Param("horaFin") LocalTime horaFin
);

    List<Mesa> findByCapacidad(int capacidad);

    List<Mesa> findByDisponibilidad(boolean disponibilidad);

    List<Mesa> findByUbicacion(String ubicacion);
}