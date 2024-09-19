/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package grupo5.taller.restaurantdeliciasgourmet;


import grupo5.taller.restaurantdeliciasgourmet.persistencia.PersistenceController;
import grupo5.taller.restaurantdeliciasgourmet.swing.windows.EmpleadosList;



/**
 *
 * @author grupo5
 */
public class RestaurantDeliciasGourmet {
    public static void main(String[] args) {
        PersistenceController persistenceController = new PersistenceController();
        EmpleadosList pantalla=new EmpleadosList();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
        
    }
}