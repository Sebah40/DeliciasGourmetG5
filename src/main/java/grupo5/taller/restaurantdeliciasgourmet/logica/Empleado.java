package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;

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

    

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, Rol rol, String correoElectronico, String contrasenia) {
        this.idEmpleado = idEmpleado;
        this.rol = rol;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public Empleado(Rol rol, String correoElectronico, String contrasenia) {
        this.rol = rol;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContraseña() {
        return contrasenia;
    }

    public void setContraseña(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", rol=" + rol + ", correoElectronico=" + correoElectronico + ", contrase\u00f1a=" + contrasenia + '}';
    }

    public Object getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
    
    
    
}
