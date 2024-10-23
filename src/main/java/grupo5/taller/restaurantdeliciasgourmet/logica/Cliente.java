package grupo5.taller.restaurantdeliciasgourmet.logica;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

/**
 * Clase que representa a un cliente del restaurante. Un cliente puede hacer reservas, gestionar sus datos
 * y relacionarse con maitres.
 * 
 * Esta clase está mapeada como una entidad en la base de datos utilizando JPA.
 * 
 * @author Grupo5
 * 
 */
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int clienteId;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String contrasenia;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reserva> reservas = new ArrayList<>();

    @ManyToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Maitre> maitres = new ArrayList<>();
    
    /**
     * Constructor por defecto. Inicializa las listas de reservas y maitres vacías.
     */
    public Cliente() {
        this.reservas = new ArrayList<>();
        this.maitres = new ArrayList<>();
    }

    /**
     * Constructor que inicializa un cliente con los datos básicos (teléfono, nombre, contraseña y correo electrónico).
     * 
     * @param telefono El número de teléfono del cliente.
     * @param nombre El nombre del cliente.
     * @param contrasenia La contraseña del cliente.
     * @param correoElectronico El correo electrónico del cliente.
     */
    public Cliente(String telefono, String nombre, String contrasenia, String correoElectronico) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = correoElectronico;
        this.maitres = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    /**
     * Constructor que permite inicializar un cliente con todos sus atributos.
     * 
     * @param clienteId El ID del cliente.
     * @param telefono El número de teléfono del cliente.
     * @param nombre El nombre del cliente.
     * @param contrasenia La contraseña del cliente.
     * @param email El correo electrónico del cliente.
     * @param reservas La lista de reservas asociadas al cliente.
     * @param maitres La lista de maitres con los que está relacionado el cliente.
     */
    public Cliente(int clienteId, String telefono, String nombre, String contrasenia, String email, ArrayList<Reserva> reservas, ArrayList<Maitre> maitres) {
        this.clienteId = clienteId;
        this.telefono = telefono;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = email;
        this.reservas = reservas;
        this.maitres = maitres;
    }

    /**
     * Obtiene el ID del cliente.
     * 
     * @return El ID del cliente.
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param clienteId El nuevo ID del cliente.
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return El número de teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     * 
     * @param telefono El nuevo número de teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return La contraseña del cliente.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del cliente.
     * 
     * @param contrasenia La nueva contraseña del cliente.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return El correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param email El nuevo correo electrónico del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la lista de reservas asociadas al cliente.
     * 
     * @return La lista de reservas.
     */
    public List<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece la lista de reservas del cliente.
     * 
     * @param reservas La nueva lista de reservas.
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Obtiene la lista de maitres asociados al cliente.
     * 
     * @return La lista de maitres.
     */
    public List<Maitre> getMaitres() {
        return maitres;
    }

    /**
     * Establece la lista de maitres asociados al cliente.
     * 
     * @param maitres La nueva lista de maitres.
     */
    public void setMaitres(ArrayList<Maitre> maitres) {
        this.maitres = maitres;
    }

    // Métodos adicionales

    /**
     * Agrega una reserva a la lista de reservas del cliente.
     * 
     * @param reserva La reserva que se desea agregar.
     */
    public void agregarReserva(Reserva reserva) { 
        this.reservas.add(reserva);
    }

    /**
     * Permite que el cliente inicie sesión utilizando su correo electrónico y contraseña.
     * 
     * @param email El correo electrónico del cliente.
     * @param contrasenia La contraseña del cliente.
     */
    public void iniciarSesion(String email, String contrasenia) {
        // Método a desarrollar
    }

    /**
     * Permite al cliente recuperar su contraseña.
     * 
     * @param cliente El cliente que desea recuperar su contraseña.
     */
    public void recuperarContrasenia(Cliente cliente) {
        // Método a desarrollar
    }

    /**
     * Permite al cliente realizar una queja.
     * 
     * @param queja La queja realizada por el cliente.
     * @return Un mensaje de confirmación o null.
     */
    public String realizarQueja(String queja) {
        // Método a desarrollar
        return null;
    }

    // Métodos pendientes de desarrollo:
    // public Reserva solicitarReserva(Mesa mesa, TarjetaCredito tarjeta, LocalDate reserva) {}
    // public Reserva confirmarReserva(Reserva reserva) {}
    // public Reserva cancelarReserva(Reserva reserva) {}
    // public ArrayList<Reserva> getHistorialReservas(LocalDate fechaInicio, LocalDate fechaFin) {}

}

