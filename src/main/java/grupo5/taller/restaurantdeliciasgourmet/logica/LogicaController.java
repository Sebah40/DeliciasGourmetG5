/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.logica;

import grupo5.taller.restaurantdeliciasgourmet.persistencia.PersistenceController;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class LogicaController {

    PersistenceController control = new PersistenceController();

    /*----------------Metodos CRUD--------------------------------*/
 /*----------Empleado-----------------*/
    public void crearEmpleado(Empleado emp) {
        control.crearEmpleado(emp);
    }

    public void eliminarEmpleado(int id) {
        control.eliminarEmpleado(id);
    }

    public void editarEmpleado(Empleado emp) {
        control.editarEmpleado(emp);
    }

    public Empleado traerEmpleado(int id) {
        return control.traerEmpleado(id);
    }

    public ArrayList<Empleado> ListaEmpleado() {
        return control.ListaEmpleado();
    }

    /*--------------Reserva----------------*/
    public void crearReserva(Reserva res) {
        control.crearReserva(res);
    }

    public void eliminarReserva(int id) {
        control.eliminarReserva(id);
    }

    public void editarReserva(Reserva res) {
        control.editarReserva(res);
    }

    public Reserva traerReserva(int id) {
        return control.traerReserva(id);
    }

    public ArrayList<Reserva> ListaReserva() {
        return control.ListaReserva();
    }

    /*--------------Cliente----------------*/
    public void crearCliente(Cliente cli) {
        control.crearCliente(cli);
    }

    public void eliminarCliente(int id) {
        control.eliminarCliente(id);
    }

    public void editarCliente(Cliente cli) {
        control.editarCliente(cli);
    }

    public Cliente traerCliente(int id) {
        return control.traerCliente(id);
    }

    public ArrayList<Cliente> ListaCliente() {
        return control.ListaCliente();
    }
    
    /*--------------Mesa----------------*/
        public void crearMesa(Mesa mesa) {
        control.crearMesa(mesa);
    }

    public void eliminarMesa(int id) {
        control.eliminarMesa(id);
    }

    public void editarMesa(Mesa mesa) {
        control.editarMesa(mesa);
    }

    public Cliente traerMesa(int id) {
        return control.traerMesa(id);
    }

    public ArrayList<Mesa> ListaMesa() {
        return control.ListaMesa();
    }
    
    
}
