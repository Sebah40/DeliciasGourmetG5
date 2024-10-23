package grupo5.taller.restaurantdeliciasgourmet.logica;

import java.util.List;
import jakarta.persistence.*;

/**
 * La clase Rol representa un rol dentro del sistema, como un conjunto de permisos y responsabilidades.
 * Cada rol puede estar asociado a múltiples empleados.
 * @author Grupo5
 */
@Entity
public class Rol {

    /**
     * Identificador único del rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre único del rol (por ejemplo, "Administrador", "Recepcionista").
     */
    @Column(nullable = false, unique = true)
    private String nombreRol;

    /**
     * Lista de empleados asociados a este rol.
     * La relación es de uno a muchos con la entidad Empleado.
     */
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    /**
     * Constructor vacío de la clase Rol.
     */
    public Rol() {}

    /**
     * Constructor que inicializa el rol con un nombre.
     *
     * @param nombreRol El nombre del rol.
     */
    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    /**
     * Constructor que inicializa el rol con un nombre y una lista de empleados asociados.
     *
     * @param nombreRol El nombre del rol.
     * @param empleados La lista de empleados asociados al rol.
     */
    public Rol(String nombreRol, List<Empleado> empleados) {
        this.nombreRol = nombreRol;
        this.empleados = empleados;
    }

    /**
     * Devuelve el identificador único del rol.
     *
     * @return El identificador del rol.
     */
    public Long getId() {
        return id;
    }

    /**
     * Devuelve el nombre del rol.
     *
     * @return El nombre del rol.
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     * Establece un nuevo nombre para el rol.
     *
     * @param nombreRol El nuevo nombre del rol.
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    /**
     * Devuelve la lista de empleados asociados al rol.
     *
     * @return La lista de empleados asociados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece una nueva lista de empleados para este rol.
     *
     * @param empleados La nueva lista de empleados asociados.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Representa el rol como una cadena, devolviendo su nombre.
     *
     * @return El nombre del rol.
     */
    @Override
    public String toString() {
        return this.nombreRol;
    }
}
