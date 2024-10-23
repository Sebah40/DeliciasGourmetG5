package grupo5.taller.restaurantdeliciasgourmet;

import grupo5.taller.restaurantdeliciasgourmet.IGU.PantallaInicio;

import grupo5.taller.restaurantdeliciasgourmet.Servicios.EmpleadoService;

import grupo5.taller.restaurantdeliciasgourmet.Servicios.MesaService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.RolService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.TarjetaCreditoService;
import grupo5.taller.restaurantdeliciasgourmet.logica.Empleado;

import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.Rol;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import grupo5.taller.restaurantdeliciasgourmet.logica.Ubicacion;
import java.time.LocalDate;
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

        RolService rolService = context.getBean(RolService.class);
        if (rolService.getAllRol().isEmpty()) {
            rolService.saveRol(new Rol("Administrador"));
            rolService.saveRol(new Rol("Mesero"));
            rolService.saveRol(new Rol("Cocinero"));
            rolService.saveRol(new Rol("Maitre"));
        }

        EmpleadoService empleadoService = context.getBean(EmpleadoService.class); // TEMPORAL HASTA QUE ADMINISTRADOR EXISTA
        if (empleadoService.getAllEmpleado().isEmpty()) {
            empleadoService.saveEmpleado(new Empleado(rolService.findByName("Mesero"), "empleado@correo.com", "contraseña"));
        }
        TarjetaCreditoService tarjetaService = context.getBean(TarjetaCreditoService.class);
        if (tarjetaService.findByNumeroTarjeta("8888888888888") == null) {
            tarjetaService.saveTarjetaCredito(new TarjetaCredito("admin", "admin", "8888888888888", "888", LocalDate.now()));
        }

    }

    public static ApplicationContext getContext() {
        return context;
    }

}
