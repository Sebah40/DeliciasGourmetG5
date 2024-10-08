package grupo5.taller.restaurantdeliciasgourmet;

import grupo5.taller.restaurantdeliciasgourmet.IGU.LoginCliente;
import grupo5.taller.restaurantdeliciasgourmet.IGU.PantallaInicio;
import grupo5.taller.restaurantdeliciasgourmet.IGU.VerMesasDisponibles;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.MesaService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.TarjetaCreditoService;
import grupo5.taller.restaurantdeliciasgourmet.controladores.ReservaController;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import grupo5.taller.restaurantdeliciasgourmet.logica.Ubicacion;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestaurantDeliciasGourmet {

    private static ApplicationContext context;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        context = SpringApplication.run(RestaurantDeliciasGourmet.class, args);
        PantallaInicio inicioWindow = context.getBean(PantallaInicio.class);   
        inicioWindow.setVisible(true);

        MesaService mesaService = context.getBean(MesaService.class); // TEMPORAL HASTA QUE ADMINISTRADOR EXISTA
        if (mesaService.getMesasDisponibles().isEmpty()) {
            mesaService.crearMesa(new Mesa(4, Ubicacion.INTERIOR));
            mesaService.crearMesa(new Mesa(3, Ubicacion.INTERIOR));
            mesaService.crearMesa(new Mesa(2, Ubicacion.PATIO));
            mesaService.crearMesa(new Mesa(1, Ubicacion.PATIO));
        }
        
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
