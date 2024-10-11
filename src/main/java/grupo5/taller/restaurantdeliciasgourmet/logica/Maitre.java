
package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Maitre extends Empleado {

    @ManyToMany
    @JoinTable(
        name = "maitre_cliente",
        joinColumns = @JoinColumn(name = "maitre_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes = new ArrayList<>();

    public Maitre() {
    }

    public Maitre(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Maitre(ArrayList<Cliente> clientes, Integer idEmpleado, Rol rol, String correoElectronico, String contraseña) {
        super(idEmpleado, rol, correoElectronico, contraseña);
        this.clientes = clientes;
    }

    public Maitre(ArrayList<Cliente> clientes, Rol rol, String correoElectronico, String contraseña) {
        super(rol, correoElectronico, contraseña);
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Maitre{" +"clientes=" + clientes +"} " + super.toString();
    }
     
    
}
