/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.controladores;

import grupo5.taller.restaurantdeliciasgourmet.Servicios.EmpleadoService;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.Empleado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    
    /*
    
    public List<Empleado> getAllEmpleado() {
        return empleadoService.getAllEmpleado();
    }

    public Empleado getEmpleadoById(int id) {
        return empleadoService.getEmpleadoById(id);
    }

    public Empleado saveEmpleado(Empleado emp) {
        return empleadoService.saveEmpleado(emp);
    }

    public void deleteEmpleado(int id) {
        empleadoService.deleteEmpleado(id);
    }
*/
}
