package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una mesa en el restaurante, incluyendo información
 * sobre su capacidad, ubicación y disponibilidad.
 * 
 * @author Grupo5
 */
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

    /**
     * Constructor por defecto.
     */
    public Mesa() {
    }

    /**
     * Constructor que inicializa la mesa con capacidad y ubicación.
     * 
     * @param capacidad La capacidad de la mesa.
     * @param ubicacion La ubicación de la mesa.
     */
    public Mesa(int capacidad, Ubicacion ubicacion) {
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.disponibilidad = true;
        this.reservas = new ArrayList<>();
    }

    /**
     * Constructor que inicializa la mesa con todos los atributos.
     * 
     * @param numeroMesa El número de la mesa.
     * @param capacidad La capacidad de la mesa.
     * @param ubicacion La ubicación de la mesa.
     * @param disponibilidad La disponibilidad de la mesa.
     * @param reservas La lista de reservas asociadas a la mesa.
     */
    public Mesa(int numeroMesa, int capacidad, Ubicacion ubicacion, boolean disponibilidad, ArrayList<Reserva> reservas) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.disponibilidad = disponibilidad;
        this.reservas = reservas;
    }

    /**
     * Obtiene el número de la mesa.
     * 
     * @return El número de la mesa.
     */
    public int getNumeroMesa() {
        return numeroMesa;
    }

    /**
     * Establece el número de la mesa.
     * 
     * @param numeroMesa El nuevo número de la mesa.
     */
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     * Obtiene la capacidad de la mesa.
     * 
     * @return La capacidad de la mesa.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad de la mesa.
     * 
     * @param capacidad La nueva capacidad de la mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la ubicación de la mesa.
     * 
     * @return La ubicación de la mesa.
     */
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa.
     * 
     * @param ubicacion La nueva ubicación de la mesa.
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Verifica si la mesa está disponible.
     * 
     * @return true si la mesa está disponible; false en caso contrario.
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece la disponibilidad de la mesa.
     * 
     * @param disponibilidad El nuevo estado de disponibilidad de la mesa.
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * Obtiene la lista de reservas asociadas a la mesa.
     * 
     * @return La lista de reservas.
     */
    public List<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece la lista de reservas asociadas a la mesa.
     * 
     * @param reservas La nueva lista de reservas.
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Bloquea la mesa, estableciendo su disponibilidad a false.
     * 
     * @param numeroMesa El número de la mesa a bloquear.
     */
    public void bloquearMesa(int numeroMesa) {
        actualizarEstado(numeroMesa, false);
    }

    /**
     * Desbloquea la mesa, estableciendo su disponibilidad a true.
     */
    public void desbloquearMesa() {
        actualizarEstado(numeroMesa, true);
    }

    /**
     * Configura la mesa con los detalles especificados.
     * 
     * @param numeroMesa El número de la mesa.
     * @param capacidad La nueva capacidad de la mesa.
     * @param disponibilidad El nuevo estado de disponibilidad de la mesa.
     * @param ubicacion La nueva ubicación de la mesa.
     */
    public void configurarMesa(int numeroMesa, int capacidad, boolean disponibilidad, Ubicacion ubicacion) {
        Mesa mesa = new Mesa();
        mesa.setCapacidad(capacidad);
        mesa.setDisponibilidad(disponibilidad);
        mesa.setUbicacion(ubicacion);
    }

    /**
     * Actualiza el estado de disponibilidad de la mesa.
     * 
     * @param numeroMesa El número de la mesa a actualizar.
     * @param disponibilidad El nuevo estado de disponibilidad.
     */
    public void actualizarEstado(int numeroMesa, boolean disponibilidad) {
        Mesa mesa = new Mesa();
        mesa.setDisponibilidad(disponibilidad);
    }

    /**
     * Devuelve una representación en formato de cadena de la mesa.
     * 
     * @return Una cadena que representa a la mesa.
     */
    @Override
    public String toString() {
        return "Mesa{" + "numeroMesa=" + numeroMesa + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + ", disponibilidad=" + disponibilidad + '}';
    }

    /**
     * Compara si este objeto es igual a otro.
     * 
     * @param o El objeto a comparar.
     * @return true si son iguales; false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return numeroMesa == mesa.numeroMesa;
    }
}
