package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;

/**
 * Clase que representa a un empleado en el sistema del restaurante.
 * Un empleado tiene un rol asignado y credenciales de acceso mediante correo electrónico y contraseña.
 * La herencia está configurada para manejar diferentes tipos de empleados en una tabla única.
 * 
 * Esta clase está mapeada como una entidad en la base de datos utilizando JPA.
 * 
 * @author Grupo5
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;
    
    @Column(name = "dtype", nullable = false)
    private String dtype = "Empleado";
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @Column(nullable = false)
    private String contrasenia;

    /**
     * Constructor por defecto. Requerido por JPA.
     */
    public Empleado() {
    }

    /**
     * Constructor que inicializa un empleado con todos sus atributos.
     * 
     * @param idEmpleado El ID del empleado.
     * @param rol El rol del empleado.
     * @param correoElectronico El correo electrónico del empleado.
     * @param contrasenia La contraseña del empleado.
     */
    public Empleado(Integer idEmpleado, Rol rol, String correoElectronico, String contrasenia) {
        this.idEmpleado = idEmpleado;
        this.rol = rol;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor que inicializa un empleado con un rol, correo electrónico y contraseña.
     * 
     * @param rol El rol asignado al empleado.
     * @param correoElectronico El correo electrónico del empleado.
     * @param contrasenia La contraseña del empleado.
     */
    public Empleado(Rol rol, String correoElectronico, String contrasenia) {
        this.rol = rol;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el ID del empleado.
     * 
     * @return El ID del empleado.
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Establece el ID del empleado.
     * 
     * @param idEmpleado El nuevo ID del empleado.
     */
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Obtiene el rol asignado al empleado.
     * 
     * @return El rol del empleado.
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol asignado al empleado.
     * 
     * @param rol El nuevo rol del empleado.
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     * 
     * @return El correo electrónico del empleado.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del empleado.
     * 
     * @param correoElectronico El nuevo correo electrónico del empleado.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene la contraseña del empleado.
     * 
     * @return La contraseña del empleado.
     */
    public String getContraseña() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del empleado.
     * 
     * @param contrasenia La nueva contraseña del empleado.
     */
    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Devuelve una representación en formato de cadena del empleado.
     * 
     * @return Una cadena que representa al empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", rol=" + rol + ", correoElectronico=" + correoElectronico + ", contraseña=" + contrasenia + '}';
    }

    /**
     * Método temporal no soportado que podría obtener el nombre del empleado.
     * 
     * @throws UnsupportedOperationException Si el método no está implementado.
     */
    public Object getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

