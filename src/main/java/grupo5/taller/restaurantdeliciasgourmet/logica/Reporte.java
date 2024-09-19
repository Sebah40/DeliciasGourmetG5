
package grupo5.taller.restaurantdeliciasgourmet.logica;
import java.util.ArrayList;

public class Reporte {
    private ArrayList<Administrador> administradores;

    public Reporte() {
    }
    
    public Reporte(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }
    
    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public void setAdministradores(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }
    
  /*  public ArrayList<Reserva> reservasFuturasDeCliente(Cliente cliente){
        
    }
  */  
    
    /**
    * Devuelve la lista de todas las reservas de un cliente específico.
    *
    * @param cliente El cliente del cual se desean obtener las reservas.
    * @return Una lista de reservas del cliente, o una lista vacía si el cliente no tiene reservas.
    */
    
    public ArrayList<Reserva> reservasTotalesCliente(Cliente cliente){
        ArrayList<Reserva> reservas = cliente.getReservas();

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
    public Cliente clienteMayorCantidadReservas(ArrayList<Cliente> clientes){
        int max = 0;
        Cliente cliente = null;
    
        for(Cliente clie: clientes){
            int cant = clie.getReservas().size();
        
        
            if(cant > max){
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
    public ArrayList<Cliente> clientesQueNoAsistieron(ArrayList<Cliente> clientes){
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
    
  /*  public ArrayList<Reserva> reservasEnRangoTiempo(LocalDate fecha1, LocalDate fecha2){

    }
  */   
    
  /*  public void PeriodosMayorConcurrencia(){
        
    }
  */  
    
  /*  public void gestionReporte(){
        
    }
  */  
    
  /*  public void exportarPDF(){
        
    }
  */  
    
  /*  public void exportarExcel(){
        
    }
  */  

}
