package grupo5.taller.restaurantdeliciasgourmet.logica;

import grupo5.taller.restaurantdeliciasgourmet.Servicios.EmpleadoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que representa un administrador del restaurante. Un administrador puede gestionar reservas,
 * reportes, horarios y mesas, además de crear, asignar roles y eliminar empleados.
 * 
 * @author Grupo5
 * 
 */
public class Administrador extends Empleado {

    private int admin_id;
    private ArrayList<Reserva> reservas;
    private ArrayList<Reporte> reportes;
    private ArrayList<Horario> horarios;
    private ArrayList<Mesa> mesas;
    
    private final EmpleadoService empleadoService;

    /**
     * Constructor que inicializa un Administrador con un servicio de empleado.
     * 
     * @param empleadoService Servicio para gestionar empleados.
     */
    public Administrador(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    /**
     * Constructor por defecto que inicializa las listas de reservas, reportes, mesas y horarios vacías.
     */
    public Administrador() {
        this.reservas = new ArrayList<>();
        this.reportes = new ArrayList<>();
        this.mesas = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.empleadoService = null;
    }

    /**
     * Constructor que permite inicializar un administrador con todos sus atributos.
     * 
     * @param admin_id ID del administrador.
     * @param reservas Lista de reservas del administrador.
     * @param reportes Lista de reportes generados.
     * @param horarios Lista de horarios asignados.
     * @param mesas Lista de mesas gestionadas.
     */
    public Administrador(int admin_id, ArrayList<Reserva> reservas, ArrayList<Reporte> reportes, ArrayList<Horario> horarios, ArrayList<Mesa> mesas) {
        this.admin_id = admin_id;
        this.reservas = reservas;
        this.reportes = reportes;
        this.horarios = horarios;
        this.mesas = mesas;
        this.empleadoService = null;
    }

    /**
     * Constructor que inicializa el administrador con listas específicas de reservas, reportes, horarios y mesas.
     * 
     * @param reservas Lista de reservas del administrador.
     * @param reportes Lista de reportes generados.
     * @param horarios Lista de horarios asignados.
     * @param mesas Lista de mesas gestionadas.
     */
    public Administrador(ArrayList<Reserva> reservas, ArrayList<Reporte> reportes, ArrayList<Horario> horarios, ArrayList<Mesa> mesas) {
        this.reservas = reservas;
        this.reportes = reportes;
        this.horarios = horarios;
        this.mesas = mesas;
        this.empleadoService = null;
    }

    /**
     * Constructor que permite inicializar un administrador con listas de reservas, reportes, horarios, mesas, 
     * y atributos de empleado.
     * 
     * @param reservas Lista de reservas del administrador.
     * @param reportes Lista de reportes generados.
     * @param horarios Lista de horarios asignados.
     * @param mesas Lista de mesas gestionadas.
     * @param idEmpleado ID del empleado administrador.
     * @param rol Rol del administrador.
     * @param correoElectronico Correo electrónico del administrador.
     * @param contrasenia Contraseña del administrador.
     */
    public Administrador(ArrayList<Reserva> reservas, ArrayList<Reporte> reportes, ArrayList<Horario> horarios, ArrayList<Mesa> mesas, Integer idEmpleado, Rol rol, String correoElectronico, String contrasenia) {
        super(idEmpleado, rol, correoElectronico, contrasenia);
        this.reservas = reservas;
        this.reportes = reportes;
        this.horarios = horarios;
        this.mesas = mesas;
        this.empleadoService = null;
    }

    /**
     * Constructor que inicializa el administrador con listas de reservas, reportes, horarios, mesas,
     * rol, correo electrónico y contraseña.
     * 
     * @param reservas Lista de reservas del administrador.
     * @param reportes Lista de reportes generados.
     * @param horarios Lista de horarios asignados.
     * @param mesas Lista de mesas gestionadas.
     * @param rol Rol del administrador.
     * @param correoElectronico Correo electrónico del administrador.
     * @param contrasenia Contraseña del administrador.
     */
    public Administrador(ArrayList<Reserva> reservas, ArrayList<Reporte> reportes, ArrayList<Horario> horarios, ArrayList<Mesa> mesas, Rol rol, String correoElectronico, String contrasenia) {
        super(rol, correoElectronico, contrasenia);
        this.reservas = reservas;
        this.reportes = reportes;
        this.horarios = horarios;
        this.mesas = mesas;
        this.empleadoService = null;
    }

    /**
     * Constructor que inicializa un administrador con su rol, correo electrónico y contraseña.
     * 
     * @param rol Rol del administrador.
     * @param correoElectronico Correo electrónico del administrador.
     * @param contrasenia Contraseña del administrador.
     */
    public Administrador(Rol rol, String correoElectronico, String contrasenia){
        super(rol,correoElectronico,contrasenia);
        this.empleadoService = null;
    }

    // Métodos getter y setter

    /**
     * Obtiene la lista de reservas del administrador.
     * 
     * @return Lista de reservas.
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece la lista de reservas del administrador.
     * 
     * @param reservas Lista de reservas.
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Obtiene la lista de reportes del administrador.
     * 
     * @return Lista de reportes.
     */
    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    /**
     * Establece la lista de reportes del administrador.
     * 
     * @param reportes Lista de reportes.
     */
    public void setReportes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }

    /**
     * Obtiene la lista de horarios del administrador.
     * 
     * @return Lista de horarios.
     */
    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    /**
     * Establece la lista de horarios del administrador.
     * 
     * @param horarios Lista de horarios.
     */
    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    /**
     * Obtiene la lista de mesas gestionadas por el administrador.
     * 
     * @return Lista de mesas.
     */
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    /**
     * Establece la lista de mesas gestionadas por el administrador.
     * 
     * @param mesas Lista de mesas.
     */
    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }

    /**
     * Obtiene el ID del administrador.
     * 
     * @return ID del administrador.
     */
    public int getAdmin_id() {
        return admin_id;
    }

    /**
     * Establece el ID del administrador.
     * 
     * @param admin_id ID del administrador.
     */
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    // Métodos de funcionalidad

    /**
     * Crea un nuevo empleado y lo guarda usando el servicio de empleado.
     * 
     * @param rol Rol del nuevo empleado.
     * @param correoElectronico Correo electrónico del nuevo empleado.
     * @param contrasenia Contraseña del nuevo empleado.
     */
    public void crearEmpleado(Rol rol, String correoElectronico, String contrasenia) {
        Empleado empleado = new Empleado(rol, correoElectronico, contrasenia);
        empleadoService.saveEmpleado(empleado);
    }

    /**
     * Asigna un rol a un empleado existente.
     * 
     * @param empleado El empleado al que se le asignará el rol.
     * @param rol El rol que se asignará al empleado.
     */
    public void asignarRolEmpleado(Empleado empleado, Rol rol) {
        empleado.setRol(rol);
    }

    /**
     * Elimina un empleado utilizando el servicio de empleado.
     * 
     * @param empleado El empleado que se eliminará.
     */
    public void eliminarEmpleado(Empleado empleado) {
        empleadoService.deleteEmpleado(empleado);
    }

    /**
     * Genera un reporte de las reservas realizadas entre dos fechas.
     * 
     * @param fechaInicio Fecha de inicio del periodo.
     * @param fechaFin Fecha de fin del periodo.
     * @return Lista de reportes de reservas generadas.
     */
    public ArrayList<Reporte> generarReporteReservas(LocalDate fechaInicio, LocalDate fechaFin) {
        // Implementación pendiente
        return null;
    }

    /**
     * Configura un horario especial para una fecha específica.
     * 
     * @param fecha Fecha para la cual se configurará el horario.
     * @param horaApertura Hora de apertura especial.
     * @param horaCierre Hora de cierre especial.
     */
    public void configurarHorarioEspecial(LocalDate fecha, LocalDate horaApertura, LocalDate horaCierre) {
        // Implementación pendiente
    }

    /**
     * Bloquea una franja horaria específica.
     */
    public void bloquearfranjaHoraria() {
        // Implementación pendiente
    }

    /**
     * Ajusta el horario de una mesa en particular, indicando si estará disponible o no.
     * 
     * @param numeroMesa Número de la mesa.
     * @param horaInicio Hora de inicio del nuevo horario.
     * @param horaFin Hora de fin del nuevo horario.
     * @param disponible Indica si la mesa estará disponible.
     */
    public void ajustarHorarioMesa(int numeroMesa, LocalDate horaInicio, LocalDate horaFin, boolean disponible) {
        // Implementación pendiente
    }

    /**
     * Elimina una reserva de la lista de reservas, si está presente.
     * 
     * @param reserva La reserva que se desea eliminar de la lista.
     */
    public void quitarReservaLista(Reserva reserva) {
        Iterator<Reserva> iterator = reservas.iterator();

        while (iterator.hasNext()) {
            Reserva r = iterator.next();
            if (reserva.equals(r)) {
                iterator.remove(); 
                break; 
            }
        }
    }

    /**
     * Agrega una reserva a la lista de reservas si no está ya presente.
     * 
     * @param reserva La reserva que se desea agregar a la lista.
     */
    public void agregarReservaLista(Reserva reserva) {
        if (reserva != null && !reservas.contains(reserva)) {
            reservas.add(reserva);
        }
    }

}

