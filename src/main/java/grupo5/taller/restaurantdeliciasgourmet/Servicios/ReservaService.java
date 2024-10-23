/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ClienteRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.MesaRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ReservaRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.TarjetaCreditoRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.EstadoReserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.Reserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private TarjetaCreditoRepository tarjetaRepository;

    public void hacerReserva(int mesaId, int clienteId, TarjetaCredito tarjeta, LocalDate fechaReserva, LocalDateTime fechaHoraInicio) throws Exception {
        LocalDateTime fechaHoraFin = getFechaHoraFin(fechaHoraInicio);

        List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles();
        Mesa mesa = mesaRepository.findById(mesaId).orElseThrow(() -> new Exception("Mesa no encontrada"));
        System.out.println("MESA PEDIDA: " + mesa);
        System.out.println("MESAS ENCONTRADASS" + mesasDisponibles);
        System.out.println(mesasDisponibles.contains(mesa));
        if (!mesasDisponibles.contains(mesa)) {
            throw new Exception("La mesa seleccionada no está disponible en el horario elegido.");
        }

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new Exception("Cliente no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setMesa(mesa);
        reserva.setCliente(cliente);
        reserva.setFechaReserva(fechaReserva);
        reserva.setFechaHoraInicio(fechaHoraInicio);
        reserva.setFechaHoraFin(fechaHoraFin);
        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        reserva.setTarjeta(tarjeta);

        reservaRepository.save(reserva);
    }

    public void bloquearMesa(int mesaId, LocalDate fechaReserva, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) throws Exception {
        List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles();
        Mesa mesa = mesaRepository.findById(mesaId).orElseThrow(() -> new Exception("Mesa no encontrada"));
        System.out.println("MESA PEDIDA: " + mesa);
        System.out.println("MESAS ENCONTRADASS" + mesasDisponibles);
        System.out.println(mesasDisponibles.contains(mesa));
        if (!mesasDisponibles.contains(mesa)) {
            throw new Exception("La mesa seleccionada no está disponible en el horario elegido.");
        }

        Cliente cliente = clienteRepository.findById(1)
                .orElseThrow(() -> new Exception("Cliente no encontrado"));

        Reserva reserva = new Reserva();
        reserva.setMesa(mesa);
        reserva.setCliente(cliente);
        reserva.setFechaReserva(fechaReserva);
        reserva.setFechaHoraInicio(fechaHoraInicio);
        reserva.setFechaHoraFin(fechaHoraFin);
        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        reserva.setTarjeta(tarjetaRepository.findByNumeroTarjeta("8888888888888"));
        reservaRepository.save(reserva);
    }

    public void hacerReserva(Reserva reserva) throws Exception {
        LocalDateTime fechaHoraInicio = reserva.getFechaHoraInicio();
        LocalDateTime horaFin = getFechaHoraFin(fechaHoraInicio);
        Mesa mesa = reserva.getMesa();

        try {
            List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles(fechaHoraInicio, horaFin);

            System.out.println("MESAS DISPONIBLES: " + mesasDisponibles.toString());
            System.out.println("MESAAA: " + mesa);
            System.out.println("DEBUGGING FECHA: " + reserva.getFechaReserva() + " HORA: " + fechaHoraInicio);

            if (!mesasDisponibles.contains(mesa)) {
                throw new Exception("La mesa seleccionada no está disponible en el horario elegido.");
            }

            reserva.setFechaHoraFin(horaFin);
            reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
            reservaRepository.save(reserva);
        } catch (Exception e) {
            System.out.println("Error al hacer la reserva: " + e.getMessage());
            throw e;
        }
    }

    private LocalDateTime getFechaHoraFin(LocalDateTime fechaHoraInicio) {
        return fechaHoraInicio.plusHours(2);                             //La reserva dura 2 horas
    }

    public List<Reserva> getReservasFromCliente(int clienteId) {
        return reservaRepository.findByCliente_ClienteId(clienteId);
    }

    public void cancelarReserva(int reservaId) throws Exception {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new Exception("Reserva no encontrada"));
        reserva.setEstadoReserva(EstadoReserva.CANCELADA);
        reservaRepository.save(reserva);
    }

    private void generarCorreo(String destinatario, String asunto, String contenido) {
        final String username = "deliciasgourmetrestaurant@gmail.com";
        final String password = "vqscztejjztsuokw";

        // Propiedades para la conexión
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(contenido);

            Transport.send(message);
            System.out.println("Correo enviado exitosamente.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // Método para enviar correos de confirmación
    public void enviarCorreosConfirmacion() {
        // Suponiendo que tienes un servicio para acceder a las reservas
        List<Reserva> reservas = obtenerReservasDelDia(LocalDate.now());

        for (Reserva reserva : reservas) {
            String destinatario = reserva.getCliente().getEmail();
            String asunto = "Confirmación de asistencia para su reserva";
            String contenido = "Estimado " + reserva.getCliente().getNombre() + ",\n\n"
                    + "Le recordamos que tiene una reserva el día " + reserva.getFechaReserva()
                    + " a las " + reserva.getFechaHoraInicio() + ".\n"
                    + "Por favor, confirme su asistencia o cancele si no podrá asistir.\n\n"
                    + "¡Esperamos verlo pronto en Delicias Gourmet Restaurant!\n\n"
                    + "Atentamente,\nEl equipo de Delicias Gourmet Restaurant";

            generarCorreo(destinatario, asunto, contenido);
        }
    }

    public List<Reserva> obtenerReservasDelDia(LocalDate now) {
        List<Reserva> reservasDelDia = new ArrayList<>();
        
        LocalDate today = LocalDate.now(); // Día actual
        LocalDate startDate = today.atStartOfDay().toLocalDate(); // Inicio del día (00:00)
        LocalDate endDate = today.plusDays(1).atStartOfDay().toLocalDate(); // Inicio del siguiente día (00:00)

        return reservasDelDia = reservaRepository.findByFechaReservaBetween(startDate, endDate);
    }
}
