
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
    
    //si un administrador desea gestionar o estar asignado a un horario
    public void agregarAdministrador(Administrador administrador) {
        if (!administradores.contains(administrador)) {
            administradores.add(administrador);
        }
    }
    //verifica si un horario tiene un evento
    public boolean tieneEvento() {
        return evento != null && !evento.isEmpty();
    }
    //ajustar horario por algun evento en particular
    public void ajustarHorarioParaEvento(String evento, LocalDate aperturaEspecial, LocalDate cierreEspecial) {
        this.evento = evento;
        this.horarioApertura = aperturaEspecial;
        this.horarioCierre = cierreEspecial;
    }
    //si ese horario en ese dia esta disponible
    public boolean estaDisponible(LocalDate fecha) {
        return this.fecha.equals(fecha);
    }

    


    
}
