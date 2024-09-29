package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guard
 */
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int idReserva;

    @Column(nullable = false)
    private LocalDate fechaReserva;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estadoReserva;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tarjeta_id", nullable = false)
    private TarjetaCredito tarjeta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "reserva_recepcionista",
        joinColumns = @JoinColumn(name = "reserva_id"),
        inverseJoinColumns = @JoinColumn(name = "recepcionista_id")
    )
    private List<Recepcionista> recepcionistas = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "intolerancias", joinColumns = @JoinColumn(name = "reserva_id"))
    @Column(name = "intolerancia")
    private List<String> intolerancias = new ArrayList<>();

    @Column(nullable = false)
    private int multa;
    
    public Reserva() {
    }

    public Reserva(int idReserva, LocalDate fechaReserva, LocalTime horaInicio, LocalTime horaFin, EstadoReserva estadoReserva, TarjetaCredito tarjeta, Mesa mesa, Cliente cliente, ArrayList<Recepcionista> recepcionistas, ArrayList<String> intolerancias, ArrayList<Administrador> administradores, int multa) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoReserva = estadoReserva;
        this.tarjeta = tarjeta;
        this.mesa = mesa;
        this.cliente = cliente;
        this.recepcionistas = recepcionistas;
        this.intolerancias = intolerancias;
        //this.administradores = administradores;
        this.multa = multa;
    }

    public Reserva(LocalDate fechaReserva, LocalTime horaInicio, LocalTime horaFin, EstadoReserva estadoReserva, TarjetaCredito tarjeta, Mesa mesa, Cliente cliente, ArrayList<Recepcionista> recepcionistas, ArrayList<String> intolerancias, ArrayList<Administrador> administradores, int multa) {
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoReserva = estadoReserva;
        this.tarjeta = tarjeta;
        this.mesa = mesa;
        this.cliente = cliente;
        this.recepcionistas = recepcionistas;
        this.intolerancias = intolerancias;
        //this.administradores = administradores;
        this.multa = multa;
    }

    

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    public void setRecepcionistas(ArrayList<Recepcionista> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    public List<String> getIntolerancias() {
        return intolerancias;
    }

    public void setIntolerancias(ArrayList<String> intolerancias) {
        this.intolerancias = intolerancias;
    }

    //public ArrayList<Administrador> getAdministradores() {
        //return administradores;
    //}

    public void setAdministradores(ArrayList<Administrador> administradores) {
        //this.administradores = administradores;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", fechaReserva=" + fechaReserva + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", estadoReserva=" + estadoReserva + ", tarjeta=" + tarjeta + ", mesa=" + mesa + ", cliente=" + cliente + ", recepcionistas=" + recepcionistas + ", intolerancias=" + intolerancias + ", administradores=" + /**administradores**/  ", multa=" + multa + '}';
    }
}