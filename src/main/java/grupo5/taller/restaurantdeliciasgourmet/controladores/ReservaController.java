/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.controladores;

import grupo5.taller.restaurantdeliciasgourmet.Servicios.MesaService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.ReservaService;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author sebas
 */

@Controller
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    public String crearReserva(int mesaId, int clienteId, TarjetaCredito tarjeta, LocalDate fechaReserva, LocalTime horaInicio) {
        try {
            reservaService.hacerReserva(mesaId, clienteId, tarjeta, fechaReserva, horaInicio);
            return "Reserva creada con éxito";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
