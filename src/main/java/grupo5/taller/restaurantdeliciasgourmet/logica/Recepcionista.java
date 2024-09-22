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
    
    //permite agregar una reserva
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }
    
    //permite eliminar una reserva
    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }
    
    //permite buscar una reserva por ID
    public Reserva buscarReservaPorId(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva() == idReserva) {
             return reserva;
            }
        }
        return null; // O lanzar una excepción si lo prefieres
    }
    
    //confirmar una reserva
    public void confirmarReserva(int idReserva) {
        Reserva reserva = buscarReservaPorId(idReserva);
        if (reserva != null) {
            reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        } else {
            // throw new ReservaNoEncontradaException("Reserva no encontrada.");
        }
    }
    //muestra si ls reserva esta confirmada
    public void recibirCliente(Cliente cliente) {
        for (Reserva reserva : reservas) {
            if (reserva.getCliente().equals(cliente) && reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
                System.out.println("Bienvenido, " + cliente.getNombre() + ". Su reserva está confirmada.");
                
                return;
            }
        }
        System.out.println("No se encontró ninguna reserva confirmada para " + cliente.getNombre() + ".");
    }

}
