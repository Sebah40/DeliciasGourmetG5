
package grupo5.taller.restaurantdeliciasgourmet.logica;


import java.time.LocalDate;
import java.util.ArrayList;


public class Horario {
    
    private int id_horario;
    
    private LocalDate fecha;
    private LocalDate horarioApertura;
    private LocalDate horarioCierre;
    private String evento;

    private ArrayList<Administrador> administradores;

    public Horario() {
    }


    public Horario(int id_horario, LocalDate fecha, LocalDate horarioApertura, LocalDate horarioCierre, ArrayList<Administrador> administradores) {
        this.id_horario = id_horario;
        this.fecha = fecha;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.administradores = administradores;
    }
    
    public Horario(LocalDate fecha, LocalDate horarioApertura, LocalDate horarioCierre, String evento, ArrayList<Administrador> administradores) {
        this.fecha = fecha;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.evento = evento;
        this.administradores = administradores;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(LocalDate horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public LocalDate getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalDate horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }
    

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

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
 * @return true si hay un evento definido (es decir, si el campo evento no es null ni está vacío);
 *         false en caso contrario.
 */
    public boolean tieneEvento() {
        return evento != null && !evento.isEmpty();
    }
    
/**
 * Ajusta el horario de apertura y cierre para un evento especial.
 *
 * @param evento El nombre del evento especial.
 * @param aperturaEspecial La nueva fecha de apertura para el evento.
 * @param cierreEspecial La nueva fecha de cierre para el evento.
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
 * @return true si la mesa está disponible para la fecha dada; 
 *         false en caso contrario.
 */
    public boolean estaDisponible(LocalDate fecha) {
        return this.fecha.equals(fecha);
    }

    


    
}
