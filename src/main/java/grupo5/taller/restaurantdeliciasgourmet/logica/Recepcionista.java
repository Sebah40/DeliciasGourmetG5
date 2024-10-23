package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un recepcionista en el restaurante, 
 * encargado de gestionar las reservas de los clientes.
 * 
 * @author Grupo5
 */
@Entity
public class Recepcionista extends Empleado {

    @OneToMany(mappedBy = "recepcionistas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    /**
     * Constructor por defecto.
     */
    public Recepcionista() {
    }

    /**
     * Constructor que inicializa el recepcionista con una lista de reservas.
     * 
     * @param reservas La lista de reservas asociadas al recepcionista.
     */
    public Recepcionista(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Obtiene la lista de reservas asociadas al recepcionista.
     * 
     * @return La lista de reservas.
     */
    public List<Reserva> getReservas() {
        return reservas;
    }

    /**
     * Establece la lista de reservas asociadas al recepcionista.
     * 
     * @param reservas La nueva lista de reservas.
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Agrega una nueva reserva a la lista de reservas del recepcionista.
     * 
     * @param reserva La reserva a agregar.
     */
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    /**
     * Elimina una reserva de la lista de reservas del recepcionista.
     * 
     * @param reserva La reserva a eliminar.
     */
    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    /**
     * Busca una reserva por su ID.
     * 
     * @param idReserva El ID de la reserva a buscar.
     * @return La reserva encontrada, o null si no se encuentra.
     */
    public Reserva buscarReservaPorId(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getIdReserva() == idReserva) {
                return reserva;
            }
        }
        return null; // O lanzar una excepción si lo prefieres
    }

    /**
     * Confirma una reserva por su ID, cambiando su estado a CONFIRMADA.
     * 
     * @param idReserva El ID de la reserva a confirmar.
     */
    public void confirmarReserva(int idReserva) {
        Reserva reserva = buscarReservaPorId(idReserva);
        if (reserva != null) {
            reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        } else {
            // throw new ReservaNoEncontradaException("Reserva no encontrada.");
        }
    }

    /**
     * Recibe a un cliente y verifica si su reserva está confirmada.
     * 
     * @param cliente El cliente que llega al restaurante.
     */
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

