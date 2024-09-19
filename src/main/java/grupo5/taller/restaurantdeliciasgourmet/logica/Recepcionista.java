/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.logica;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "recepcionista")
public class Recepcionista extends Empleado {

    @OneToMany(mappedBy = "recepcionistas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();


    public Recepcionista(){
        
    }
    public Recepcionista(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
    
   
    
    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }    
    
    
    public void asignarMesa(int idReserva, int numeroMesa){
        
    }
    
    public void recibirCliente(){
        
    }
}
