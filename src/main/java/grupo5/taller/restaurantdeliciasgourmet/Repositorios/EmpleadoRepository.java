/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Repositorios;


import grupo5.taller.restaurantdeliciasgourmet.logica.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
}
