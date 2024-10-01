/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.logica;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author guard
 */
@Entity
@Table(name = "tarjeta_credito")
public class TarjetaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Long id;

    @Column(name = "nombre_titular", nullable = false)
    private String nombreTitular;

    @Column(name = "emisor", nullable = false)
    private String emisor;

    @Column(name = "numero_tarjeta", nullable = false, unique = true)
    private String numeroTarjeta;

    @Column(name = "codigo_verificacion", nullable = false)
    private String codigoVerificacion;
    
    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate fechaExpiracion;

    @OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reserva> reservas = new ArrayList<>();

    public TarjetaCredito() {
    }
    
    public TarjetaCredito(String nombreTitular, String emisor, String numeroTarjeta, String codigoVerificacion, ArrayList<Reserva> reservas) {
        this.nombreTitular = nombreTitular;
        this.emisor = emisor;
        this.numeroTarjeta = numeroTarjeta;
        this.codigoVerificacion = codigoVerificacion;
        this.reservas = reservas;
    }
    
     public TarjetaCredito(String nombreTitular, String emisor, String numeroTarjeta, String codigoVerificacion, LocalDate fechaExpiracion) {
        this.nombreTitular = nombreTitular;
        this.emisor = emisor;
        this.numeroTarjeta = numeroTarjeta;
        this.codigoVerificacion = codigoVerificacion;
        this.fechaExpiracion = fechaExpiracion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
     

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCodigoVerificacion() {
        return codigoVerificacion;
    }

    public void setCodigoVerificacion(String codigoVerificacion) {
        this.codigoVerificacion = codigoVerificacion;
    }

    public List<Reserva> getLista_reserva() {
        return reservas;
    }

    public void setLista_reserva(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "nombreTitular=" + nombreTitular + ", emisor=" + emisor + ", numeroTarjeta=" + numeroTarjeta + ", codigoVerificacion=" + codigoVerificacion + '}';
    }
    
    
    
    
}
