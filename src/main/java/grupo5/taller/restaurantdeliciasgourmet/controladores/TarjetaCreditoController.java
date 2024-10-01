/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.TarjetaCreditoService;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import java.time.LocalDate;

/**
 *
 * @author sebas
 */
@Controller
public class TarjetaCreditoController {
    @Autowired
    private TarjetaCreditoService tarjetaCreditoService;
    
    public TarjetaCredito saveTarjetaCredito(TarjetaCredito tarjetaCredito) {
        return tarjetaCreditoService.saveTarjetaCredito(tarjetaCredito);
    }


    public TarjetaCredito findTarjetaByNumero(String numeroTarjeta) {
        return tarjetaCreditoService.findByNumeroTarjeta(numeroTarjeta);
    }

    public void deleteTarjetaCredito(Long id) {
        tarjetaCreditoService.deleteById(id);
    }
    
    public TarjetaCredito createAndSaveTarjetaCredito(String nombreTitular, String numeroTarjeta, LocalDate fechaExpiracion, String cvv) throws IllegalArgumentException {
        if (nombreTitular.isEmpty() || numeroTarjeta.isEmpty() || fechaExpiracion == null || cvv.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos de la tarjeta deben ser llenados.");
        }
        if (cvv.length() < 3 || cvv.length() > 4) {
            throw new IllegalArgumentException("El CVV debe tener entre 3 y 4 dígitos.");
        }
        TarjetaCredito tarjetaCredito = new TarjetaCredito();
        tarjetaCredito.setNombreTitular(nombreTitular);
        tarjetaCredito.setNumeroTarjeta(numeroTarjeta);
        tarjetaCredito.setFechaExpiracion(fechaExpiracion);
        tarjetaCredito.setCodigoVerificacion(cvv);
        tarjetaCredito.setEmisor("Visa");

        return tarjetaCreditoService.saveTarjetaCredito(tarjetaCredito);
    }
}
