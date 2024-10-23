package grupo5.taller.restaurantdeliciasgourmet.logica;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa el horario de operación de un restaurante.
 * Un horario incluye la fecha, los tiempos de apertura y cierre, un evento asociado
 * y una lista de administradores que gestionan dicho horario.
 * 
 * @author Grupo5
 */
public class Horario {

    private int id_horario;
    private LocalDate fecha;
    private LocalDate horarioApertura;
    private LocalDate horarioCierre;
    private String evento;
    private ArrayList<Administrador> administradores;

    /**
     * Constructor por defecto.
     */
    public Horario() {
    }

    /**
     * Constructor que inicializa el horario con todos sus atributos.
     * 
     * @param id_horario El ID del horario.
     * @param fecha La fecha del horario.
     * @param horarioApertura La hora de apertura.
     * @param horarioCierre La hora de cierre.
     * @param administradores La lista de administradores asignados.
     */
    public Horario(int id_horario, LocalDate fecha, LocalDate horarioApertura, LocalDate horarioCierre, ArrayList<Administrador> administradores) {
        this.id_horario = id_horario;
        this.fecha = fecha;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.administradores = administradores;
    }

    /**
     * Constructor que inicializa el horario con un evento.
     * 
     * @param fecha La fecha del horario.
     * @param horarioApertura La hora de apertura.
     * @param horarioCierre La hora de cierre.
     * @param evento El evento asociado.
     * @param administradores La lista de administradores asignados.
     */
    public Horario(LocalDate fecha, LocalDate horarioApertura, LocalDate horarioCierre, String evento, ArrayList<Administrador> administradores) {
        this.fecha = fecha;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.evento = evento;
        this.administradores = administradores;
    }

    /**
     * Obtiene el evento asociado al horario.
     * 
     * @return El evento del horario.
     */
    public String getEvento() {
        return evento;
    }

    /**
     * Establece un evento para el horario.
     * 
     * @param evento El evento a asignar.
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * Obtiene la fecha del horario.
     * 
     * @return La fecha del horario.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del horario.
     * 
     * @param fecha La nueva fecha del horario.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de apertura.
     * 
     * @return La hora de apertura.
     */
    public LocalDate getHorarioApertura() {
        return horarioApertura;
    }

    /**
     * Establece la hora de apertura.
     * 
     * @param horarioApertura La nueva hora de apertura.
     */
    public void setHorarioApertura(LocalDate horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    /**
     * Obtiene la hora de cierre.
     * 
     * @return La hora de cierre.
     */
    public LocalDate getHorarioCierre() {
        return horarioCierre;
    }

    /**
     * Establece la hora de cierre.
     * 
     * @param horarioCierre La nueva hora de cierre.
     */
    public void setHorarioCierre(LocalDate horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    /**
     * Obtiene el ID del horario.
     * 
     * @return El ID del horario.
     */
    public int getId_horario() {
        return id_horario;
    }

    /**
     * Establece el ID del horario.
     * 
     * @param id_horario El nuevo ID del horario.
     */
    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    /**
     * Obtiene la lista de administradores asignados al horario.
     * 
     * @return La lista de administradores.
     */
    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    /**
     * Establece la lista de administradores asignados al horario.
     * 
     * @param administradores La nueva lista de administradores.
     */
    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    /**
     * Devuelve una representación en formato de cadena del horario.
     * 
     * @return Una cadena que representa el horario.
     */
    @Override
    public String toString() {
        return "Horario{" + "fecha=" + fecha + ", horarioApertura=" + horarioApertura + ", horarioCierre=" + horarioCierre + ", administradores=" + administradores + '}';
    }

    /**
     * Asigna un administrador a la gestión del horario si aún no está asignado.
     * 
     * @param administrador El administrador que se desea agregar.
     */
    public void agregarAdministrador(Administrador administrador) {
        if (!administradores.contains(administrador)) {
            administradores.add(administrador);
        }
    }

    /**
     * Verifica si hay un evento asociado al horario actual.
     * 
     * @return true si hay un evento definido; false en caso contrario.
     */
    public boolean tieneEvento() {
        return evento != null && !evento.isEmpty();
    }

    /**
     * Ajusta el horario de apertura y cierre para un evento especial.
     * 
     * @param evento El nombre del evento especial.
     * @param aperturaEspecial La nueva hora de apertura para el evento.
     * @param cierreEspecial La nueva hora de cierre para el evento.
     */
    public void ajustarHorarioParaEvento(String evento, LocalDate aperturaEspecial, LocalDate cierreEspecial) {
        this.evento = evento;
        this.horarioApertura = aperturaEspecial;
        this.horarioCierre = cierreEspecial;
    }

    /**
     * Verifica si la mesa está disponible para una fecha específica.
     * 
     * @param fecha La fecha en la que se desea comprobar la disponibilidad.
     * @return true si la mesa está disponible; false en caso contrario.
     */
    public boolean estaDisponible(LocalDate fecha) {
        return this.fecha.equals(fecha);
    }
}

