/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.IGU;

import com.toedter.calendar.JDateChooser;
import grupo5.taller.restaurantdeliciasgourmet.RestaurantDeliciasGourmet;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.ClienteService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.EmpleadoService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.MesaService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.RolService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.SessionManager;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.TarjetaCreditoService;
import grupo5.taller.restaurantdeliciasgourmet.controladores.ReservaController;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.EstadoReserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.Reserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author sebas
 */
@Component
public class VerMesasDisponibles extends javax.swing.JFrame {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private RolService rolService;


    @Autowired
    private MesaService mesaService;
    

    public VerMesasDisponibles() {
        initComponents();
        jDateChooser.setDate(java.sql.Date.valueOf(LocalDate.now()));
        jDateChooser.getDateEditor().addPropertyChangeListener("date", e -> {
                actualizarMesas(null);
            });
            timeSpinner.addChangeListener(e -> {
                actualizarMesas(null);
            });
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTitulo = new javax.swing.JLabel();
        btnCrearReserva = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnVerMisReservas = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        timeSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 620));

        jPanel1.setBackground(new java.awt.Color(210, 188, 151));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));

        jTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTitulo.setForeground(new java.awt.Color(0, 0, 0));
        jTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitulo.setText("Ver mesas disponibles");

        btnCrearReserva.setBackground(new java.awt.Color(51, 204, 0));
        btnCrearReserva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCrearReserva.setText("Crear reserva");
        btnCrearReserva.setMaximumSize(new java.awt.Dimension(145, 39));
        btnCrearReserva.setMinimumSize(new java.awt.Dimension(145, 39));
        btnCrearReserva.setPreferredSize(new java.awt.Dimension(145, 39));
        btnCrearReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearReservaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fecha");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Hora");

        btnVerMisReservas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVerMisReservas.setText("Volver");
        btnVerMisReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMisReservasActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(60, 63, 65));
        jLabel2.setText("HH:mm");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnVerMisReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(timeSpinner))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTitulo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(timeSpinner))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerMisReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());

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
/*
    private void actualizarMesas(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        DefaultListModel<String> listModel = new DefaultListModel<>();
        jList1.setModel(listModel);

        if (jDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.");
            return;
        }
        LocalDate selectedDate = getSelectedDate();
        LocalTime selectedTime = getSelectedTime();
        try {
            List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles(selectedDate, selectedTime);
            for (Mesa mesa : mesasDisponibles) {
                listModel.addElement("Mesa " + mesa.getNumeroMesa() + "         Capacidad: " + mesa.getCapacidad() + "         Ubicacion: " + mesa.getUbicacion().name().toLowerCase());
            }

            if (mesasDisponibles.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay mesas disponibles para la fecha y hora seleccionadas.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener mesas: " + ex.getMessage());
        }
    }
*/
    
    private void actualizarMesas(java.awt.event.ActionEvent evt) {                                             
    DefaultListModel<String> listModel = new DefaultListModel<>();
    jList1.setModel(listModel);

    if (jDateChooser.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.");
        return;
    }

    LocalDate selectedDate = getSelectedDate();
    LocalTime selectedTime = getSelectedTime();

    try {
        List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles(selectedDate, selectedTime);

        // Verificar si hay mesas disponibles
        if (mesasDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay mesas disponibles para la fecha y hora seleccionadas.");
            return;
        }

        // Añadir mesas disponibles a la lista
        for (Mesa mesa : mesasDisponibles) {
            String mesaInfo = String.format("Mesa %d - Capacidad: %d - Ubicación: %s",
                                             mesa.getNumeroMesa(),
                                             mesa.getCapacidad(),
                                             mesa.getUbicacion().name().toLowerCase());
            listModel.addElement(mesaInfo);
        }
    } catch (Exception ex) {
        Logger.getLogger(VerMesasDisponibles.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error al obtener mesas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    private void btnCrearReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearReservaActionPerformed
        // TODO add your handling code here:
        LocalDate selectedDate = getSelectedDate();
        LocalTime selectedTime = getSelectedTime();

        int selectedIndex = jList1.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una mesa.");
            return;
        }
        Mesa selectedMesa = mesaService.getMesasDisponibles(selectedDate, selectedTime).get(selectedIndex);
        Reserva selectedReserva = new Reserva();
        selectedReserva.setFechaReserva(selectedDate);
        selectedReserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        selectedReserva.setHoraInicio(selectedTime);
        selectedReserva.setMesa(selectedMesa);
        IngresarTarjeta ingresarTarjetaWindow = RestaurantDeliciasGourmet.getContext().getBean(IngresarTarjeta.class);
        ingresarTarjetaWindow.setReservationDetails(selectedMesa, selectedDate, selectedTime, selectedReserva);
        ingresarTarjetaWindow.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearReservaActionPerformed

    private void btnVerMisReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMisReservasActionPerformed
       new LoginCliente(clienteService,empleadoService, rolService).setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_btnVerMisReservasActionPerformed
    private LocalDate getSelectedDate() {
        try {
            int year = jDateChooser.getDate().getYear() + 1900;
            int month = jDateChooser.getDate().getMonth() + 1;
            int day = jDateChooser.getDate().getDate();

            if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31 || year > LocalDate.now().plusYears(2).getYear()) {
                throw new IllegalArgumentException("Fecha seleccionada no es válida.");
            }
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha seleccionada no es válida. Por favor, seleccione una fecha correcta.");
        }
        return null;
    }

        private LocalTime getSelectedTime() {
    Date selectedTime = (Date) timeSpinner.getValue();
    return selectedTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
}


    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearReserva;
    private javax.swing.JButton btnVerMisReservas;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JSpinner timeSpinner;
    // End of variables declaration//GEN-END:variables

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

}
