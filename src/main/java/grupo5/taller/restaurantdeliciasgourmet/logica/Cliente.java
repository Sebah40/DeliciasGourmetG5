
package grupo5.taller.restaurantdeliciasgourmet.logica;
import java.util.ArrayList;

public class Cliente { 
    
    private int clienteId;
    private String telefono;
    private String nombre;
    private String contrasenia;
    private String email;
    private ArrayList<Reserva> reservas;
    private ArrayList<Maitre> maitres;

    public Cliente() {
        this.reservas = new ArrayList <>();
        this.maitres = new ArrayList <>();
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

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Maitre> getMaitres() {
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
