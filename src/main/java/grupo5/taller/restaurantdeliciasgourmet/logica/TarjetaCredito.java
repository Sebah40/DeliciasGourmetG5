package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase TarjetaCredito representa una tarjeta de crédito que se utiliza en las reservas del restaurante.
 * Está asociada con uno o más objetos Reserva.
 * @author Grupo5
 */
@Entity
@Table(name = "tarjeta_credito")
public class TarjetaCredito {

    /**
     * Identificador único de la tarjeta de crédito.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Long id;

    /**
     * Nombre del titular de la tarjeta de crédito.
     */
    @Column(name = "nombre_titular", nullable = false)
    private String nombreTitular;

    /**
     * Emisor de la tarjeta de crédito (por ejemplo, Visa, MasterCard).
     */
    @Column(name = "emisor", nullable = false)
    private String emisor;

    /**
     * Número único de la tarjeta de crédito.
     */
    @Column(name = "numero_tarjeta", nullable = false, unique = true)
    private String numeroTarjeta;

    /**
     * Código de verificación de la tarjeta de crédito.
     */
    @Column(name = "codigo_verificacion", nullable = false)
    private String codigoVerificacion;

    /**
     * Fecha de expiración de la tarjeta de crédito.
     */
    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate fechaExpiracion;

    /**
     * Lista de reservas asociadas a la tarjeta de crédito.
     * Relación uno a muchos con la entidad Reserva.
     */
    @OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reserva> reservas = new ArrayList<>();

    /**
     * Constructor vacío de la clase TarjetaCredito.
     */
    public TarjetaCredito() {}

    /**
     * Constructor que inicializa la tarjeta de crédito con todos sus atributos.
     *
     * @param nombreTitular El nombre del titular de la tarjeta.
     * @param emisor El emisor de la tarjeta.
     * @param numeroTarjeta El número de la tarjeta.
     * @param codigoVerificacion El código de verificación.
     * @param reservas La lista de reservas asociadas.
     */
    public TarjetaCredito(String nombreTitular, String emisor, String numeroTarjeta, String codigoVerificacion, ArrayList<Reserva> reservas) {
        this.nombreTitular = nombreTitular;
        this.emisor = emisor;
        this.numeroTarjeta = numeroTarjeta;
        this.codigoVerificacion = codigoVerificacion;
        this.reservas = reservas;
    }

    /**
     * Constructor que inicializa la tarjeta de crédito sin reservas asociadas.
     *
     * @param nombreTitular El nombre del titular de la tarjeta.
     * @param emisor El emisor de la tarjeta.
     * @param numeroTarjeta El número de la tarjeta.
     * @param codigoVerificacion El código de verificación.
     * @param fechaExpiracion La fecha de expiración de la tarjeta.
     */
    public TarjetaCredito(String nombreTitular, String emisor, String numeroTarjeta, String codigoVerificacion, LocalDate fechaExpiracion) {
        this.nombreTitular = nombreTitular;
        this.emisor = emisor;
        this.numeroTarjeta = numeroTarjeta;
        this.codigoVerificacion = codigoVerificacion;
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Establece el identificador único de la tarjeta de crédito.
     *
     * @param id El nuevo identificador.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha de expiración de la tarjeta de crédito.
     *
     * @return La fecha de expiración.
     */
    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Establece la fecha de expiración de la tarjeta de crédito.
     *
     * @param fechaExpiracion La nueva fecha de expiración.
     */
    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Devuelve la lista de reservas asociadas a la tarjeta de crédito.
     *
     * @return La lista de reservas.
     */
    public List<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece una nueva lista de reservas asociadas a la tarjeta de crédito.
     *
     * @param reservas La nueva lista de reservas.
     */
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Devuelve el nombre del titular de la tarjeta.
     *
     * @return El nombre del titular.
     */
    public String getNombreTitular() {
        return nombreTitular;
    }

    /**
     * Establece el nombre del titular de la tarjeta.
     *
     * @param nombreTitular El nuevo nombre del titular.
     */
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    /**
     * Devuelve el emisor de la tarjeta de crédito.
     *
     * @return El emisor de la tarjeta.
     */
    public String getEmisor() {
        return emisor;
    }

    /**
     * Establece un nuevo emisor para la tarjeta de crédito.
     *
     * @param emisor El nuevo emisor.
     */
    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    /**
     * Devuelve el número de la tarjeta de crédito.
     *
     * @return El número de la tarjeta.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece un nuevo número de tarjeta de crédito.
     *
     * @param numeroTarjeta El nuevo número de la tarjeta.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Devuelve el código de verificación de la tarjeta de crédito.
     *
     * @return El código de verificación.
     */
    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    /**
     * Establece un nuevo código de verificación para la tarjeta de crédito.
     *
     * @param codigoVerificacion El nuevo código de verificación.
     */
    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    /**
     * Representa la tarjeta de crédito como una cadena de texto.
     *
     * @return Una cadena que describe la tarjeta de crédito.
     */
    @Override
    public String toString() {
        return "TarjetaCredito{" + "nombreTitular=" + nombreTitular + ", emisor=" + emisor + ", numeroTarjeta=" + numeroTarjeta + ", codigoVerificacion=" + codigoVerificacion + '}';
    }
}

