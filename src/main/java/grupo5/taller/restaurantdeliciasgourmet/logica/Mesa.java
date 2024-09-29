package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_mesa")
    private int numeroMesa;

    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    private Ubicacion ubicacion;

    @Column(nullable = false)
    private boolean disponibilidad;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reserva> reservas = new ArrayList<>();

//private ArrayList<Administrador> administradores; NO IMPLEMENTAR TODAVIA
    public Mesa() {
    }
    public Mesa(int capacidad, Ubicacion ubicacion) {
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.disponibilidad = true;
        this.reservas = new ArrayList<>();
        //this.administradores = administradores;
    }

    public Mesa(int numeroMesa, int capacidad, Ubicacion ubicacion, boolean disponibilidad, ArrayList<Reserva> reservas, ArrayList<Horario> horarios, ArrayList<Administrador> administradores) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.disponibilidad = disponibilidad;
        this.reservas = reservas;
        //this.administradores = administradores;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

//    public ArrayList<Administrador> getAdministradores() {
//        return administradores;
//    }
//    public void setAdministradores(ArrayList<Administrador> administradores) {
//        this.administradores = administradores;
//    }
    @Override
    public String toString() {
        return "Mesa{" + "numeroMesa=" + numeroMesa + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + ", disponibilidad=" + disponibilidad + ", administradores="/*administradores*/ +'}';
    }

    public void bloquearMesa() {

    }

    public void desbloquearMesa() {

    }

    public void configurarMesa(int numeroMesa, int capacidad, boolean disponibilidad, String ubicacion) {

    }

    public void actualizarEstado(boolean disponibilidad) {

    }

//    public void mostrarDisponibilidad(LocalTime fecha) {
//
//    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return numeroMesa == mesa.numeroMesa;
    }
}
