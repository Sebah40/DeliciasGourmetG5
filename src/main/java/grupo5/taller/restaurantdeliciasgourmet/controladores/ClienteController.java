/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.controladores;

/**
 *
 * @author sebas
 */

import grupo5.taller.restaurantdeliciasgourmet.Servicios.ClienteService;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    public Cliente getClienteById(int id) {
        return clienteService.getClienteById(id);
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteService.saveCliente(cliente);
    }

    public void deleteCliente(int id) {
        clienteService.deleteCliente(id);
    }
}