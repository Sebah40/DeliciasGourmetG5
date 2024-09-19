package grupo5.taller.restaurantdeliciasgourmet.logica;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

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
    private String contraseña;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    @ManyToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Maitre> maitres = new ArrayList<>();
    
    
    public Cliente() {
    }

    public Cliente(String telefono, String nombre, String contraseña, String correoElectronico) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        this.maitres = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    
    

    public Cliente(int clienteId, String telefono, String nombre, String contraseña, String correoElectronico, ArrayList<Reserva> reservas, ArrayList<Maitre> maitres) {
        this.clienteId = clienteId;
        this.telefono = telefono;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correoElectronico = correoElectronico;
        this.reservas = reservas;
        this.maitres = maitres;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Maitre> getMaitres() {
        return maitres;
    }

    public void setMaitres(ArrayList<Maitre> maitres) {
        this.maitres = maitres;
    }

    @Override
    public String toString() {
        return "Cliente{" + "clienteId=" + clienteId + ", telefono=" + telefono + ", nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", correoElectronico=" + correoElectronico + ", reservas=" + reservas + ", maitres=" + maitres + '}';
    }
    
 
    
}
