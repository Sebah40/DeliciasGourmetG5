package grupo5.taller.restaurantdeliciasgourmet;

import grupo5.taller.restaurantdeliciasgourmet.IGU.Login;
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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestaurantDeliciasGourmet {
    private static ApplicationContext context;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        context = SpringApplication.run(RestaurantDeliciasGourmet.class, args);
//        TarjetaCreditoService tarjetaCreditoService = context.getBean(TarjetaCreditoService.class);
        Login loginWindow = context.getBean(Login.class);
        loginWindow.setVisible(true);
//        System.out.println(tarjetaCreditoService.findAll());
//        System.out.println(mesaService.getMesasDisponibles(LocalDate.of(2024, 10, 1), LocalTime.of(19, 0)).toString());
//        RestaurantReservationApp res = context.getBean(RestaurantReservationApp.class);
//        res.setVisible(true);
//        ReservaController reservaController = context.getBean(ReservaController.class);
//        System.out.println(reservaController.crearReserva(1, 1, tarjetaCreditoService.findTarjetaById(1L), LocalDate.of(2025, 10, 1), LocalTime.of(19, 0)));
//        VerMesasDisponibles realizarReserva = context.getBean(VerMesasDisponibles.class);
//        realizarReserva.setVisible(true);
    }
    public static ApplicationContext getContext() {
        return context;
    }
}