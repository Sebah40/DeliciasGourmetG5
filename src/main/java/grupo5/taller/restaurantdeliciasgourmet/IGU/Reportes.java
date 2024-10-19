package grupo5.taller.restaurantdeliciasgourmet.IGU;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.EmpleadoRepository;
import grupo5.taller.restaurantdeliciasgourmet.RestaurantDeliciasGourmet;

import grupo5.taller.restaurantdeliciasgourmet.logica.Empleado;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ClienteRepository;
import grupo5.taller.restaurantdeliciasgourmet.Repositorios.ReservaRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.EstadoReserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.Reserva;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.text.NumberFormat.Field.INTEGER;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Component;

/**
 *
 * @author sebas
 */
@Component
public class Reportes extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btn_ReservasTotalesCliente = new javax.swing.JButton();
        btn_clienteMayorCantReservas = new javax.swing.JButton();
        btn_ClientesNoAsistieron = new javax.swing.JButton();
        btnReservasEnRangoDeTiempo = new javax.swing.JButton();
        btn_MayorConcurrencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 620));

        jPanel1.setBackground(new java.awt.Color(210, 188, 151));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reportes");

        btnSalir.setBackground(new java.awt.Color(51, 204, 0));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setMaximumSize(new java.awt.Dimension(145, 39));
        btnSalir.setMinimumSize(new java.awt.Dimension(145, 39));
        btnSalir.setPreferredSize(new java.awt.Dimension(145, 39));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(156, 145, 125));
        jLabel3.setForeground(new java.awt.Color(144, 131, 105));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Logo.jpg"))); // NOI18N

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btn_ReservasTotalesCliente.setText("Reservas Totales de un Cliente");
        btn_ReservasTotalesCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReservasTotalesClienteActionPerformed(evt);
            }
        });

        btn_clienteMayorCantReservas.setText("Cliente con mayor cant. de reservas");
        btn_clienteMayorCantReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clienteMayorCantReservasActionPerformed(evt);
            }
        });

        btn_ClientesNoAsistieron.setText("Clientes que no asistieron");
        btn_ClientesNoAsistieron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClientesNoAsistieronActionPerformed(evt);
            }
        });

        btnReservasEnRangoDeTiempo.setText("Reservas en un rango de tiempo determinado");
        btnReservasEnRangoDeTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasEnRangoDeTiempoActionPerformed(evt);
            }
        });

        btn_MayorConcurrencia.setText("Periodos de mayor concurrencia");
        btn_MayorConcurrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MayorConcurrenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ClientesNoAsistieron, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clienteMayorCantReservas)
                            .addComponent(btn_ReservasTotalesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_MayorConcurrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(145, 145, 145))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReservasEnRangoDeTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btn_ReservasTotalesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_clienteMayorCantReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ClientesNoAsistieron, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_MayorConcurrencia, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnReservasEnRangoDeTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Reportes() {
        initComponents();
    }


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btn_ReservasTotalesClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReservasTotalesClienteActionPerformed

        String emailInput = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico del cliente:", "Ingreso de Correo Electrónico", JOptionPane.PLAIN_MESSAGE);

        ClienteRepository clieRepo = RestaurantDeliciasGourmet.getContext().getBean(ClienteRepository.class);
        Cliente cli = clieRepo.ClientByEmail(emailInput);

        if (cli != null) {  // Verificar si se encontró el cliente
            int id = cli.getClienteId();

            ReservaRepository reservaRepo = RestaurantDeliciasGourmet.getContext().getBean(ReservaRepository.class);
            List<Reserva> reservas = reservaRepo.findByCliente_ClienteId(id);

            boolean pdfGenerado = false;
            // Generar el PDF
            try {
                // Definir la ruta y nombre del archivo PDF
                String filePath = "reporte_ReservasTotalesCliente.pdf";
                Document document = new Document();

                // Inicializar PdfWriter
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                // Abrir el documento y agregar contenido
                document.open();
                document.add(new Paragraph("Reporte de Reservas Totales de un Cliente"));
                document.add(new Paragraph(" "));  // Línea en blanco
                document.add(new Paragraph("Cliente: " + cli.getNombre()));
                document.add(new Paragraph("Correo: " + cli.getEmail()));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                for (Reserva r : reservas) {
                    // Agregar datos de cada reserva al PDF
                    document.add(new Paragraph("ID: " + r.getIdReserva()));
                    document.add(new Paragraph("Estado: " + r.getEstadoReserva()));
                    document.add(new Paragraph("Fecha: " + r.getFechaReserva().format(formatter)));
                    document.add(new Paragraph("Hora de Inicio: " + r.getFechaHoraInicio().format(DateTimeFormatter.ofPattern("HH:mm"))));
                    document.add(new Paragraph("Hora de Fin: " + r.getFechaHoraFin().format(DateTimeFormatter.ofPattern("HH:mm"))));
                    document.add(new Paragraph("Mesa: " + r.getMesa().getNumeroMesa()));
                    document.add(new Paragraph(" "));  // Línea en blanco
                }
                pdfGenerado = true;
                // Cerrar el documento
                document.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al crear el archivo PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir del método si hay un error al generar el archivo
            } catch (DocumentException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al crear el documento PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Salir del método si hay un error al abrir el documento
            }

            if (pdfGenerado) {
                JOptionPane.showMessageDialog(null, "PDF generado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró un cliente con ese correo electrónico.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_ReservasTotalesClienteActionPerformed

    private void btnReservasEnRangoDeTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasEnRangoDeTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReservasEnRangoDeTiempoActionPerformed

    private void btn_MayorConcurrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MayorConcurrenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_MayorConcurrenciaActionPerformed

    private void btn_clienteMayorCantReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clienteMayorCantReservasActionPerformed
        ClienteRepository clieRepo = RestaurantDeliciasGourmet.getContext().getBean(ClienteRepository.class);
        ReservaRepository reservaRepo = RestaurantDeliciasGourmet.getContext().getBean(ReservaRepository.class);
        List<Cliente> clientes = clieRepo.findAll();

        int maxReservas = Integer.MIN_VALUE;
        Cliente clienteConMaxReservas = null;

// Encuentra al cliente con más reservas
        for (Cliente c : clientes) {
            if (c.getReservas().size() > maxReservas) {
                maxReservas = c.getReservas().size();
                clienteConMaxReservas = c;
            }
        }

// Verificar que se encontró un cliente
        if (clienteConMaxReservas != null) {
            List<Reserva> reservas = clienteConMaxReservas.getReservas(); // Obtener las reservas del cliente con más reservas

            boolean pdfGenerado = false;
            // Generar el PDF
            try {
                // Definir la ruta y nombre del archivo PDF
                String filePath = "reporte_ClienteMayorReserva.pdf";
                Document document = new Document();

                // Inicializar PdfWriter
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                // Abrir el documento y agregar contenido
                document.open();
                document.add(new Paragraph("Reporte de cliente con mas reservas"));
                document.add(new Paragraph("Nombre del Cliente: " + clienteConMaxReservas.getNombre())); // Agregar nombre del cliente
                document.add(new Paragraph("Cantidad de Reservas: " + maxReservas)); // Agregar cantidad de reservas
                document.add(new Paragraph("----------------------------- "));  // Línea en blanco

                // Agregar detalles de cada reserva al PDF
                for (Reserva r : reservas) {
                    document.add(new Paragraph("ID Reserva: " + r.getIdReserva()));
                    document.add(new Paragraph("Estado: " + r.getEstadoReserva()));
                    document.add(new Paragraph("Fecha: " + r.getFechaReserva().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                    document.add(new Paragraph("Hora de Inicio: " + r.getFechaHoraInicio().format(DateTimeFormatter.ofPattern("HH:mm"))));
                    document.add(new Paragraph("Hora de Fin: " + r.getFechaHoraFin().format(DateTimeFormatter.ofPattern("HH:mm"))));
                    document.add(new Paragraph("Mesa: " + r.getMesa().getNumeroMesa()));
                    document.add(new Paragraph("-------------------------- "));  // Línea en blanco
                }

                // Cerrar el documento
                document.close();
                pdfGenerado = true;

                if (pdfGenerado) {
                    JOptionPane.showMessageDialog(null, "PDF generado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (FileNotFoundException | DocumentException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con reservas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_clienteMayorCantReservasActionPerformed

    private void btn_ClientesNoAsistieronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClientesNoAsistieronActionPerformed
        ClienteRepository clieRepo = RestaurantDeliciasGourmet.getContext().getBean(ClienteRepository.class);
        ReservaRepository reservaRepo = RestaurantDeliciasGourmet.getContext().getBean(ReservaRepository.class);
        List<Reserva> reservas = reservaRepo.findAll();

        Set<Cliente> noAsistieron = new HashSet<>();

        for (Reserva r : reservas) {
            if (r.getEstadoReserva() == EstadoReserva.NO_ASISTIO) {
                noAsistieron.add(r.getCliente());
            }
        }

        if (!noAsistieron.isEmpty()) {
            boolean pdfGenerado = false;
            // Generar el PDF
            try {
                // Definir la ruta y nombre del archivo PDF
                String filePath = "reporte_ClientesQueNoAsistieron.pdf";
                Document document = new Document();

                // Inicializar PdfWriter
                PdfWriter.getInstance(document, new FileOutputStream(filePath));

                // Abrir el documento y agregar contenido
                document.open();
                document.add(new Paragraph("Reporte de clientes que no asisitieron"));
                document.add(new Paragraph("----------------------------- "));  // Línea en blanco

                // Agregar detalles de cada reserva al PDF
                for (Cliente c : noAsistieron) {
                    document.add(new Paragraph("ID Cliente: " + c.getClienteId()));
                    document.add(new Paragraph("Email: " + c.getEmail()));
                    document.add(new Paragraph("Nombre: " + c.getNombre()));
                    document.add(new Paragraph("Telefono: " + c.getTelefono()));
                    document.add(new Paragraph("-------------------------- "));
                }

                // Cerrar el documento
                document.close();
                pdfGenerado = true;

                if (pdfGenerado) {
                    JOptionPane.showMessageDialog(null, "PDF generado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (FileNotFoundException | DocumentException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente que no asistiera.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_ClientesNoAsistieronActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservasEnRangoDeTiempo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btn_ClientesNoAsistieron;
    private javax.swing.JButton btn_MayorConcurrencia;
    private javax.swing.JButton btn_ReservasTotalesCliente;
    private javax.swing.JButton btn_clienteMayorCantReservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
