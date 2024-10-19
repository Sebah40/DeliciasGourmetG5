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
import grupo5.taller.restaurantdeliciasgourmet.Servicios.ReservaService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.RolService;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.SessionManager;
import grupo5.taller.restaurantdeliciasgourmet.Servicios.TarjetaCreditoService;
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import grupo5.taller.restaurantdeliciasgourmet.logica.EstadoReserva;
import grupo5.taller.restaurantdeliciasgourmet.logica.Mesa;
import grupo5.taller.restaurantdeliciasgourmet.logica.Reserva;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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
public class BloquearMesa1 extends javax.swing.JFrame {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private RolService rolService;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private TarjetaCreditoService tarjetaService;

    @Autowired
    public BloquearMesa1(ClienteService clienteService, EmpleadoService empleadoService, RolService rolService, MesaService mesaService) {
        this.clienteService = clienteService;
        this.empleadoService = empleadoService;
        this.rolService = rolService;
        this.mesaService = mesaService;
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
        btnBloquear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnVerMisReservas = new javax.swing.JButton();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListMesas = new javax.swing.JList<>();
        timeSpinner = new javax.swing.JSpinner();
        spinnerHorasBloqueo = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 620));

        jPanel1.setBackground(new java.awt.Color(210, 188, 151));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(500, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 600));

        jTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTitulo.setText("MESAS");

        btnBloquear.setBackground(new java.awt.Color(51, 204, 0));
        btnBloquear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBloquear.setText("Bloquear");
        btnBloquear.setMaximumSize(new java.awt.Dimension(145, 39));
        btnBloquear.setMinimumSize(new java.awt.Dimension(145, 39));
        btnBloquear.setPreferredSize(new java.awt.Dimension(145, 39));
        btnBloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBloquearActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Fecha");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Horas de bloqueo");

        btnVerMisReservas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVerMisReservas.setText("Volver");
        btnVerMisReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMisReservasActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(60, 63, 65));
        jLabel2.setText("HH:mm");

        jListMesas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {  };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListMesas);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Hora");

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
                        .addComponent(btnBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerHorasBloqueo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                    .addComponent(timeSpinner))))
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
                    .addComponent(jLabel2)
                    .addComponent(timeSpinner)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(spinnerHorasBloqueo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBloquear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void actualizarMesas(java.awt.event.ActionEvent evt) {
        System.out.println("ACTUALIZANDO MESAS!!!!");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        jListMesas.setModel(listModel);

        if (jDateChooser.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha.");
            return;
        }

        LocalDate selectedDate = getSelectedDate();
        LocalDateTime startDateTime = getSelectedTime();
        LocalDateTime endDateTime = startDateTime.plusHours(2);

        // DEBUGGING ----
        System.out.println("Start Time: " + startDateTime);
        System.out.println("End Time: " + endDateTime);

        try {
            List<Mesa> mesasDisponibles = mesaService.getMesasDisponibles(startDateTime, endDateTime);
            System.out.println("MESAS DISPONIBLES: " + mesasDisponibles.toString());
            if (mesasDisponibles.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hay mesas disponibles para la fecha y hora seleccionadas.");
                return;
            }

            for (Mesa mesa : mesasDisponibles) {
                String mesaInfo = String.format("Mesa %d - Capacidad: %d - Ubicación: %s",
                        mesa.getNumeroMesa(),
                        mesa.getCapacidad(),
                        mesa.getUbicacion().name().toLowerCase());
                listModel.addElement(mesaInfo);
            }
        } catch (Exception ex) {
            Logger.getLogger(BloquearMesa1.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al obtener mesas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnBloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBloquearActionPerformed
        LocalDate selectedDate = getSelectedDate();
        LocalDateTime selectedTime = getSelectedTime();

        if (selectedDate == null || selectedTime == null) {
            return;
        }

        int horasBloquear;
        try {
            horasBloquear = (int) spinnerHorasBloqueo.getValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor válido para las horas de bloqueo.");
            return;
        }

        LocalDateTime fechaHoraFin = selectedTime.plusHours(horasBloquear);

        int selectedIndex = jListMesas.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una mesa.");
            return;
        }

        List<Mesa> availableMesas = mesaService.getMesasDisponibles(selectedTime, fechaHoraFin);
        if (availableMesas.isEmpty() || selectedIndex >= availableMesas.size()) {
            JOptionPane.showMessageDialog(this, "La mesa seleccionada no está disponible.");
            return;
        }

        Mesa selectedMesa = availableMesas.get(selectedIndex);

        try {
            reservaService.bloquearMesa(selectedMesa.getNumeroMesa(), selectedDate, selectedTime, fechaHoraFin);
            JOptionPane.showMessageDialog(this, "Reserva creada con éxito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al crear la reserva: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBloquearActionPerformed

    private void btnVerMisReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMisReservasActionPerformed
        GestionDeMesas mesa1 = new GestionDeMesas(clienteService, empleadoService, rolService, mesaService);
        mesa1.setVisible(true);
        this.dispose();

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

    private LocalDateTime getSelectedTime() {
        Date selectedTime = (Date) timeSpinner.getValue();
        LocalTime localTime = selectedTime.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalDate selectedDate = getSelectedDate();
        return LocalDateTime.of(selectedDate, localTime);
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnVerMisReservas;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListMesas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTitulo;
    private javax.swing.JSpinner spinnerHorasBloqueo;
    private javax.swing.JSpinner timeSpinner;
    // End of variables declaration//GEN-END:variables

}
