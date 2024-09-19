package grupo5.taller.restaurantdeliciasgourmet.logica;

import javax.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idEmpleado;
    private Rol nombre_rol;
    private String correoElectronico;
    private String contrasenia;
    

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, Rol rol, String correoElectronico, String contrasenia) {
        this.idEmpleado = idEmpleado;
        this.nombre_rol = rol;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
    }

    public Empleado(Rol rol, String correoElectronico, String contrasenia) {
        this.nombre_rol = rol;
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
        return nombre_rol;
    }

    public void setRol(Rol rol) {
        this.nombre_rol = rol;
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
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", rol=" + nombre_rol + ", correoElectronico=" + correoElectronico + ", contrase\u00f1a=" + contrasenia + '}';
    }

    public Object getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
   
    
    
    
}
