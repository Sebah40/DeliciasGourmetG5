
package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;


public class Horario {
    
    private int id_horario;
    
    private LocalDate fecha;
    private LocalDate horarioApertura;
    private LocalDate horarioCierre;

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
    
    public Horario(LocalDate fecha, LocalDate horaDesde, LocalDate horaHasta, LocalDate horarioApertura, LocalDate horarioCierre, ArrayList<Reserva> reservas, ArrayList<Mesa> mesas, ArrayList<Administrador> administradores) {
        this.fecha = fecha;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.administradores = administradores;
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


    
}
