/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ClienteRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.EmpleadoRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.RolRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.Empleado;
import grupo5.taller.restaurantdeliciasgourmet.logica.Rol;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private RolRepository rolRepository;

    public List<Empleado> getAllEmpleado() {
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(int id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(int id) {
        empleadoRepository.deleteById(id);
    }

    public void deleteEmpleado(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    
    public Optional<Empleado> login(String correoElectronico, String contrasenia) {
        return empleadoRepository.findByCorreoElectronicoAndContrasenia(correoElectronico, contrasenia);
    }

    public String obtenerNombreRolPorEmpleado(Empleado empleado) {
        return rolRepository.findById(empleado.getRol().getId())
            .map(Rol::getNombreRol)
            .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));
    }

}
