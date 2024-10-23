/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Usuario
 */
public class ReservaManager {


    public ReservaManager() {
    }
   

    public void enviarCorreo(String destinatario, String asunto, String contenido) {
        final String username = "deliciasgourmetrestaurant@gmail.com";
        final String password = "vqscztejjztsuokw";

        // Propiedades para la conexión
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS
        props.put("mail.smtp.host", "smtp.gmail.com");  // Servidor SMTP de Gmail
        props.put("mail.smtp.port", "587");             // Puerto SMTP de Gmail (TLS)
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

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

}
