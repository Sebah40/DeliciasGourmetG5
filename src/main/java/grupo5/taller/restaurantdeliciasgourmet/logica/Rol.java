package grupo5.taller.restaurantdeliciasgourmet.logica;

import java.util.ArrayList;

public class Rol {

    private static ArrayList<Rol> roles = new ArrayList<>();
    private String nombreRol;
    private ArrayList<Empleado> empleados;

    public Rol() {
    }

    public Rol crearRol(String nombreRol, ArrayList<Empleado> empleados) {
        Rol r = new Rol(nombreRol, empleados);
        Rol.getRoles().add(r);
        return r;
    }

    public Rol(String nombreRol, ArrayList<Empleado> empleados) {
        this.nombreRol = nombreRol;
        this.empleados = empleados;
        getRoles().add(this);
    }

    public static ArrayList<Rol> getRoles() {
        return roles;
    }

    public static void setRoles(ArrayList<Rol> roles) {
        Rol.roles = roles;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public ArrayList<Empleado> getEmpleado() {
        return empleados;
    }

    public void setEmpleado(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return this.nombreRol;
    }

    public void asignarRol() {

    }

}
