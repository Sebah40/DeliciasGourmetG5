/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Repositorios;

import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Query("SELECT m FROM Mesa m WHERE m.numeroMesa NOT IN (" +
       "SELECT r.mesa.numeroMesa FROM Reserva r " +
       "WHERE (r.fechaHoraInicio < :fechaHoraFin AND r.fechaHoraFin > :fechaHoraInicio))")
List<Mesa> findMesasDisponibles(
    @Param("fechaHoraInicio") LocalDateTime fechaHoraInicio,
    @Param("fechaHoraFin") LocalDateTime fechaHoraFin
);

    List<Mesa> findByCapacidad(int capacidad);

    List<Mesa> findByDisponibilidad(boolean disponibilidad);

    List<Mesa> findByUbicacion(String ubicacion);
}