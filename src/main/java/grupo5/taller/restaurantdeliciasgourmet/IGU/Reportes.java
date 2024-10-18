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
import grupo5.taller.restaurantdeliciasgourmet.logica.Reserva;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        jButtonReservas = new javax.swing.JButton();
        jButtonHorarios = new javax.swing.JButton();
        jButtonReportes = new javax.swing.JButton();
        jButtonReportes3 = new javax.swing.JButton();

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

        jButtonReservas.setText("Cliente con mayor cant. de reservas");

        jButtonHorarios.setText("Clientes que no asistieron");

        jButtonReportes.setText("Reservas en un rango de tiempo determinado");
        jButtonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportesActionPerformed(evt);
            }
        });

        jButtonReportes3.setText("Periodos de mayor concurrencia");
        jButtonReportes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportes3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonReportes3, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jButtonHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jButtonReservas, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(btn_ReservasTotalesCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jButtonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ReservasTotalesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jButtonReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButtonHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReportes3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
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
                    document.add(new Paragraph("Hora de Inicio: " + r.getFechaHoraInicio().format(formatter)));
                    document.add(new Paragraph("Hora de Fin: " + r.getFechaHoraFin().format(formatter)));
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

    private void jButtonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReportesActionPerformed

    private void jButtonReportes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportes3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonReportes3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btn_ReservasTotalesCliente;
    private javax.swing.JButton jButtonHorarios;
    private javax.swing.JButton jButtonReportes;
    private javax.swing.JButton jButtonReportes3;
    private javax.swing.JButton jButtonReservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
