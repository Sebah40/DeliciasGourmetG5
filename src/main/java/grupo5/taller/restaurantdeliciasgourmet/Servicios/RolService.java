/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.RolRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.Rol;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

    public Rol findByName(String rolName) {
        ArrayList<Rol> roles = (ArrayList<Rol>) rolRepository.findAll();

        for (Rol r : roles) {
            if (r.getNombreRol().equalsIgnoreCase(rolName)) {
                return r;
            }

        }

        return null;
    }

}
