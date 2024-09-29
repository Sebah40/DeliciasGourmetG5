/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;

/**
 *
 * @author sebas
 */
public class SessionManager {
    private static SessionManager instance;
    private Cliente currentCliente;

    private SessionManager() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Cliente getCurrentCliente() {
        return currentCliente;
    }

    public void setCurrentCliente(Cliente cliente) {
        this.currentCliente = cliente;
    }
}
