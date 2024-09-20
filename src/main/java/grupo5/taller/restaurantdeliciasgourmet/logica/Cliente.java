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
    private String contrasenia;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    @ManyToMany(mappedBy = "clientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Maitre> maitres = new ArrayList<>();
    
    

    public Cliente() {
        this.reservas = new ArrayList <>();
        this.maitres = new ArrayList <>();
    }

    public Cliente(String telefono, String nombre, String contraseña, String correoElectronico) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.contrasenia = contraseña;
        this.email = correoElectronico;
        this.maitres = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    
    

    public Cliente(int clienteId, String telefono, String nombre, String contrasenia, String email, ArrayList<Reserva> reservas, ArrayList<Maitre> maitres) {
        this.clienteId = clienteId;
        this.telefono = telefono;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.email = email;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public void agregarReserva(Reserva reserva){ 
        this.reservas.add(reserva);
    
    }
    
    public void iniciarSesion(String email, String contrasenia){
    //metodo a desarrollar
    }
    
    public void cancelarReserva(Reserva reserva){
    //metodo a desarrolar
    }
    
    public String realizarQueja(String queja){
    //metodo a desarrollar
    return null;
    }
    

}
