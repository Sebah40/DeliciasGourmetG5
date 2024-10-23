package grupo5.taller.restaurantdeliciasgourmet.logica;

import grupo5.taller.restaurantdeliciasgourmet.IGU.IngresarTarjeta;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Reserva representa una reserva realizada por un cliente en el restaurante.
 * Incluye detalles sobre la fecha, hora, estado, mesa, cliente, y otros aspectos relacionados.
 * @author Grupo5
 */
@Entity
@Table(name = "reserva")
public class Reserva {

    /**
     * Identificador único de la reserva.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int idReserva;

    /**
     * Fecha en la que se realizó la reserva.
     */
    @Column(nullable = false)
    private LocalDate fechaReserva;

    /**
     * Fecha y hora de inicio de la reserva.
     */
    @Column(nullable = false)
    private LocalDateTime fechaHoraInicio;

    /**
     * Fecha y hora de finalización de la reserva.
     */
    @Column(nullable = false)
    private LocalDateTime fechaHoraFin;

    /**
     * Estado actual de la reserva (por ejemplo: CONFIRMADA, CANCELADA).
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoReserva estadoReserva;

    /**
     * Tarjeta de crédito asociada a la reserva.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tarjeta_id", nullable = false)
    private TarjetaCredito tarjeta;

    /**
     * Mesa reservada.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mesa_id", nullable = false)
    private Mesa mesa;

    /**
     * Cliente que realizó la reserva.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    /**
     * Lista de recepcionistas asociados a la reserva.
     */
    @ManyToMany
    @JoinTable(
        name = "reserva_recepcionista",
        joinColumns = @JoinColumn(name = "reserva_id"),
        inverseJoinColumns = @JoinColumn(name = "recepcionista_id")
    )
    private List<Recepcionista> recepcionistas = new ArrayList<>();

    /**
     * Lista de intolerancias alimenticias registradas en la reserva.
     */
    @ElementCollection
    @CollectionTable(name = "intolerancias", joinColumns = @JoinColumn(name = "reserva_id"))
    @Column(name = "intolerancia")
    private List<String> intolerancias = new ArrayList<>();

    /**
     * Multa impuesta en la reserva, si corresponde.
     */
    @Column(nullable = false)
    private int multa;

    /**
     * Constructor vacío de la clase Reserva.
     */
    public Reserva() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase Reserva.
     *
     * @param idReserva El identificador de la reserva.
     * @param fechaReserva La fecha de la reserva.
     * @param fechaHoraInicio La fecha y hora de inicio de la reserva.
     * @param fechaHoraFin La fecha y hora de finalización de la reserva.
     * @param estadoReserva El estado de la reserva.
     * @param tarjeta La tarjeta de crédito asociada a la reserva.
     * @param mesa La mesa reservada.
     * @param cliente El cliente que hizo la reserva.
     * @param recepcionistas Los recepcionistas asociados a la reserva.
     * @param intolerancias Las intolerancias alimenticias registradas en la reserva.
     * @param multa La multa impuesta en la reserva, si corresponde.
     */
    public Reserva(int idReserva, LocalDate fechaReserva, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, EstadoReserva estadoReserva, TarjetaCredito tarjeta, Mesa mesa, Cliente cliente, ArrayList<Recepcionista> recepcionistas, ArrayList<String> intolerancias, int multa) {
        this.idReserva = idReserva;
        this.fechaReserva = fechaReserva;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.estadoReserva = estadoReserva;
        this.tarjeta = tarjeta;
        this.mesa = mesa;
        this.cliente = cliente;
        this.recepcionistas = recepcionistas;
        this.intolerancias = intolerancias;
        this.multa = multa;
    }

    /**
     * Constructor que inicializa los atributos sin el ID de la reserva.
     *
     * @param fechaReserva La fecha de la reserva.
     * @param fechaHoraInicio La fecha y hora de inicio de la reserva.
     * @param fechaHoraFin La fecha y hora de finalización de la reserva.
     * @param estadoReserva El estado de la reserva.
     * @param tarjeta La tarjeta de crédito asociada a la reserva.
     * @param mesa La mesa reservada.
     * @param cliente El cliente que hizo la reserva.
     * @param recepcionistas Los recepcionistas asociados a la reserva.
     * @param intolerancias Las intolerancias alimenticias registradas en la reserva.
     * @param multa La multa impuesta en la reserva, si corresponde.
     */
    public Reserva(LocalDate fechaReserva, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, EstadoReserva estadoReserva, TarjetaCredito tarjeta, Mesa mesa, Cliente cliente, ArrayList<Recepcionista> recepcionistas, ArrayList<String> intolerancias, int multa) {
        this.fechaReserva = fechaReserva;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.estadoReserva = estadoReserva;
        this.tarjeta = tarjeta;
        this.mesa = mesa;
        this.cliente = cliente;
        this.recepcionistas = recepcionistas;
        this.intolerancias = intolerancias;
        this.multa = multa;
    }

    /**
     * Devuelve el identificador de la reserva.
     *
     * @return El identificador de la reserva.
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Establece el identificador de la reserva.
     *
     * @param idReserva El nuevo identificador de la reserva.
     */
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    /**
     * Devuelve la fecha de la reserva.
     *
     * @return La fecha de la reserva.
     */
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Establece la fecha de la reserva.
     *
     * @param fechaReserva La nueva fecha de la reserva.
     */
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * Devuelve la fecha y hora de inicio de la reserva.
     *
     * @return La fecha y hora de inicio.
     */
    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    /**
     * Establece la fecha y hora de inicio de la reserva.
     *
     * @param fechaHoraInicio La nueva fecha y hora de inicio.
     */
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    /**
     * Devuelve la fecha y hora de finalización de la reserva.
     *
     * @return La fecha y hora de finalización.
     */
    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    /**
     * Establece la fecha y hora de finalización de la reserva.
     *
     * @param fechaHoraFin La nueva fecha y hora de finalización.
     */
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    /**
     * Devuelve el estado de la reserva.
     *
     * @return El estado de la reserva.
     */
    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    /**
     * Establece el estado de la reserva.
     *
     * @param estadoReserva El nuevo estado de la reserva.
     */
    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    /**
     * Devuelve la tarjeta de crédito asociada a la reserva.
     *
     * @return La tarjeta de crédito.
     */
    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    /**
     * Establece la tarjeta de crédito asociada a la reserva.
     *
     * @param tarjeta La nueva tarjeta de crédito.
     */
    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * Devuelve la mesa reservada.
     *
     * @return La mesa reservada.
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * Establece la mesa reservada.
     *
     * @param mesa La nueva mesa reservada.
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Devuelve el cliente que realizó la reserva.
     *
     * @return El cliente que realizó la reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente que realizó la reserva.
     *
     * @param cliente El nuevo cliente.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve la lista de recepcionistas asociados a la reserva.
     *
     * @return La lista de recepcionistas.
     */
    public List<Recepcionista> getRecepcionistas() {
        return recepcionistas;
    }

    /**
     * Establece la lista de recepcionistas asociados a la reserva.
     *
     * @param recepcionistas La nueva lista de recepcionistas.
     */
    public void setRecepcionistas(ArrayList<Recepcionista> recepcionistas) {
        this.recepcionistas = recepcionistas;
    }

    /**
     * Devuelve la lista de intolerancias alimenticias registradas en la reserva.
     *
     * @return La lista de intolerancias.
     */
    public List<String> getIntolerancias() {
        return intolerancias;
    }

    /**
     * Establece la lista de intolerancias alimenticias registradas en la reserva.
     *
     * @param intolerancias La nueva lista de intolerancias.
     */
    public void setIntolerancias(ArrayList<String> intolerancias) {
        this.intolerancias = intolerancias;
    }

    /**
     * Devuelve la multa impuesta en la reserva.
     *
     * @return El monto de la multa.
     */
    public int getMulta() {
        return multa;
    }

    /**
     * Establece la multa impuesta en la reserva.
     *
     * @param multa El nuevo monto de la multa.
     */
    public void setMulta(int multa) {
        this.multa = multa;
    }

    /**
     * Representa la reserva como una cadena, mostrando la fecha de inicio y la mesa reservada.
     *
     * @return Una cadena que describe la reserva.
     */
    @Override
    public String toString() {
        return "Reserva: " + this.fechaHoraInicio + " en mesa " + this.mesa.getNumeroMesa();
    }
}
