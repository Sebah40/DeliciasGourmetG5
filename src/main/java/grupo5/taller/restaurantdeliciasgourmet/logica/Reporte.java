package grupo5.taller.restaurantdeliciasgourmet.logica;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase Reporte representa un informe que recopila información
 * de administradores y sus respectivos clientes, así como de sus reservas.
 * @author Grupo5
 */
public class Reporte {

    /**
     * Identificador único del reporte.
     */
    private int id;

    /**
     * Lista de administradores asociados a este reporte.
     */
    private ArrayList<Administrador> administradores;

    /**
     * Constructor vacío de la clase Reporte.
     */
    public Reporte() {
    }

    /**
     * Constructor que inicializa el reporte con un ID y una lista de administradores.
     *
     * @param id El identificador del reporte.
     * @param administradores La lista de administradores que pertenecen a este reporte.
     */
    public Reporte(int id, ArrayList<Administrador> administradores) {
        this.id = id;
        this.administradores = administradores;
    }

    /**
     * Devuelve el identificador del reporte.
     *
     * @return El identificador del reporte.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del reporte.
     *
     * @param id El nuevo identificador del reporte.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Constructor que inicializa el reporte con una lista de administradores.
     *
     * @param administradores La lista de administradores que pertenecen a este reporte.
     */
    public Reporte(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    /**
     * Devuelve la lista de administradores asociados al reporte.
     *
     * @return La lista de administradores.
     */
    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    /**
     * Establece la lista de administradores asociados al reporte.
     *
     * @param administradores La nueva lista de administradores.
     */
    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    /**
     * Devuelve la lista total de reservas de un cliente específico.
     *
     * @param cliente El cliente del cual se desean obtener las reservas.
     * @return Una lista de reservas del cliente, o una lista vacía si no tiene reservas.
     */
    public List<Reserva> reservasTotalesCliente(Cliente cliente) {
        List<Reserva> reservas = cliente.getReservas();
        if (reservas != null) {
            return reservas;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Devuelve el cliente con la mayor cantidad de reservas en la lista de clientes proporcionada.
     *
     * @param clientes La lista de clientes a evaluar.
     * @return El cliente con más reservas, o null si la lista está vacía.
     */
    public Cliente clienteMayorCantidadReservas(ArrayList<Cliente> clientes) {
        int max = 0;
        Cliente cliente = null;

        for (Cliente clie : clientes) {
            int cant = clie.getReservas().size();
            if (cant > max) {
                max = cant;
                cliente = clie;
            }
        }
        return cliente;
    }

    /**
     * Devuelve una lista de clientes que no asistieron a alguna de sus reservas.
     * El estado de la reserva se verifica contra la enumeración EstadoReserva.NO_ASISTIO.
     *
     * @param clientes La lista de clientes a evaluar.
     * @return Una lista de clientes que no asistieron a alguna de sus reservas.
     */
    public ArrayList<Cliente> clientesQueNoAsistieron(ArrayList<Cliente> clientes) {
        ArrayList<Cliente> clientesNoAsistieron = new ArrayList<>();
        for (Cliente clie : clientes) {
            for (Reserva reserva : clie.getReservas()) {
                if (reserva.getEstadoReserva() == EstadoReserva.NO_ASISTIO) {
                    clientesNoAsistieron.add(clie);
                    break;
                }
            }
        }
        return clientesNoAsistieron;
    }
}

