package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un maitre en el restaurante, quien es un tipo de empleado
 * encargado de la atención al cliente. Un maitre puede estar asociado a múltiples clientes.
 * 
 * @author Grupo5
 */
@Entity
public class Maitre extends Empleado {

    @ManyToMany
    @JoinTable(
        name = "maitre_cliente",
        joinColumns = @JoinColumn(name = "maitre_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public Maitre() {
    }

    /**
     * Constructor que inicializa el maitre con una lista de clientes.
     * 
     * @param clientes La lista de clientes asociados al maitre.
     */
    public Maitre(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Constructor que inicializa el maitre con una lista de clientes y los detalles del empleado.
     * 
     * @param clientes La lista de clientes asociados al maitre.
     * @param idEmpleado El ID del empleado.
     * @param rol El rol del empleado.
     * @param correoElectronico El correo electrónico del empleado.
     * @param contraseña La contraseña del empleado.
     */
    public Maitre(ArrayList<Cliente> clientes, Integer idEmpleado, Rol rol, String correoElectronico, String contraseña) {
        super(idEmpleado, rol, correoElectronico, contraseña);
        this.clientes = clientes;
    }

    /**
     * Constructor que inicializa el maitre con una lista de clientes y el rol del empleado.
     * 
     * @param clientes La lista de clientes asociados al maitre.
     * @param rol El rol del empleado.
     * @param correoElectronico El correo electrónico del empleado.
     * @param contraseña La contraseña del empleado.
     */
    public Maitre(ArrayList<Cliente> clientes, Rol rol, String correoElectronico, String contraseña) {
        super(rol, correoElectronico, contraseña);
        this.clientes = clientes;
    }

    /**
     * Obtiene la lista de clientes asociados al maitre.
     * 
     * @return La lista de clientes.
     */
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Establece la lista de clientes asociados al maitre.
     * 
     * @param clientes La nueva lista de clientes.
     */
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Devuelve una representación en formato de cadena del maitre.
     * 
     * @return Una cadena que representa al maitre.
     */
    @Override
    public String toString() {
        return "Maitre{" + "clientes=" + clientes + "} " + super.toString();
    }
}

