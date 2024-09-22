
package grupo5.taller.restaurantdeliciasgourmet.logica;

import java.time.LocalDate;
import java.util.ArrayList;



public class Administrador extends Empleado{
    private ArrayList<Reserva> reservas;
    private ArrayList<Reporte> reportes;
    private ArrayList<Horario> horarios;
    private ArrayList<Mesa> mesas;

    public Administrador() {
        this.reservas = new ArrayList<>();
        this.reportes = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public Administrador(ArrayList<Reserva> reservas, ArrayList<Reporte> reportes, ArrayList<Horario> horarios, ArrayList<Mesa> mesas) {
        this.reservas = reservas;
        this.reportes = reportes;
        this.horarios = horarios;
        this.mesas = mesas;
    }

    public Administrador(ArrayList<Reserva> reservas, ArrayList<Reporte> reportes, ArrayList<Horario> horarios, ArrayList<Mesa> mesas, Integer idEmpleado, Rol rol, String correoElectronico, String contraseña) {
        super(idEmpleado, rol, correoElectronico, contraseña);
        this.reservas = reservas;
        this.reportes = reportes;
        this.horarios = horarios;
        this.mesas = mesas;
    }

    public Administrador(ArrayList<Reserva> reservas, ArrayList<Reporte> reportes, ArrayList<Horario> horarios, ArrayList<Mesa> mesas, Rol rol, String correoElectronico, String contraseña) {
        super(rol, correoElectronico, contraseña);
        this.reservas = reservas;
        this.reportes = reportes;
        this.horarios = horarios;
        this.mesas = mesas;
    }

    
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }
    
    public void crearEmpleado(Rol rol, String correoElectronico, String contrasenia){
        Empleado empleado = new Empleado(rol,correoElectronico,contrasenia);
        LogicaController logControl = new LogicaController();
        
        logControl.crearEmpleado(empleado);
    }
    
    public void asignarRolEmpleado(Empleado empleado, Rol rol){
        empleado.setRol(rol);
    }
    
    public void eliminarEmpleado(Empleado empleado){
        LogicaController logControl = new LogicaController();
        
        logControl.eliminarEmpleado(empleado);
    }
    
    public ArrayList<Reporte> generarReporteReservas(LocalDate fechaInicio, LocalDate fechaFin){
        
        return null;
        
    } 
    
    public void configurarHorarioEspecial(LocalDate fecha, LocalDate horaApertura, LocalDate horaCierre){
        
    }
    
    public void definirHorarioAperturaCierre(LocalDate horaApertura, LocalDate horaCierre){
        
    }
    
    public void bloquearfranjaHoraria(){
        
    }
    
    public void ajustarHorarioMesa(int numeroMesa, LocalDate horaInicio, LocalDate horaFin, boolean disponible){
        
    }
    
    public void quitarReservaLista(Reserva reserva){
        
    }
    
    public void agregarReservaLista(Reserva reserva){
        
    }
    
    public void gestionarReserva(int idReserva) {
        LogicaController logicaController = new LogicaController();
        Reserva reserva = logicaController.traerReserva(idReserva);

        if (reserva != null) {
            // Procesa la reserva si existe
             System.out.println("Procesando la reserva: " + reserva);
        
            // Verificar si la reserva está en estado "CONFIRMADA"
            if (reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
                 System.out.println("La reserva está confirmada.");
                    // Procesar una reserva confirmada
                    System.out.println("La reserva está confirmada.");
                    System.out.println("Detalles de la reserva:");
                    System.out.println("Fecha: " + reserva.getFechaReserva());
                    System.out.println("Hora de inicio: " + reserva.getHoraInicio());
                    System.out.println("Mesa asignada: " + reserva.getMesa());
                    System.out.println("Cliente: " + reserva.getCliente().getNombre());
            }   else {
                    System.out.println("La reserva no está confirmada.");
                    // Acciones para reservas no confirmadas
                }

        } else {
            // Manejo del caso cuando la reserva no existe
            System.out.println("No se encontró la reserva con el ID: " + idReserva);
        }
    }

    
}
