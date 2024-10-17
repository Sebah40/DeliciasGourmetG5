
package grupo5.taller.restaurantdeliciasgourmet.IGU;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import javax.swing.SpinnerDateModel;
public class bloquearFranja extends javax.swing.JFrame {


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden
private JSpinner spinnerHoraApertura;
    private JSpinner spinnerHoraCierre;
    private JButton btnGuardar;

    public bloquearFranja() {
        // Configuración básica del JFrame
        setTitle("Bloquear Horarios del Restaurante");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Creación de los componentes
        JLabel lblHoraApertura = new JLabel("Hora inicio:");
        JLabel lblHoraCierre = new JLabel("Hora fin:");

        // Configuración del Spinner para la Hora de Apertura
        SpinnerDateModel modelApertura = new SpinnerDateModel();
        spinnerHoraApertura = new JSpinner(modelApertura);
        JSpinner.DateEditor editorApertura = new JSpinner.DateEditor(spinnerHoraApertura, "HH:mm");
        spinnerHoraApertura.setEditor(editorApertura);
        spinnerHoraApertura.setValue(new Date()); // Valor inicial a la hora actual

        // Configuración del Spinner para la Hora de Cierre
        SpinnerDateModel modelCierre = new SpinnerDateModel();
        spinnerHoraCierre = new JSpinner(modelCierre);
        JSpinner.DateEditor editorCierre = new JSpinner.DateEditor(spinnerHoraCierre, "HH:mm");
        spinnerHoraCierre.setEditor(editorCierre);
        spinnerHoraCierre.setValue(new Date()); // Valor inicial a la hora actual

        // Botón para guardar la configuración
        btnGuardar = new JButton("Bloquear Horarios");

        // Acción al presionar el botón
        btnGuardar.addActionListener(e -> guardarHorarios());

        // Añadir componentes al JFrame
        add(lblHoraApertura);
        add(spinnerHoraApertura);
        add(lblHoraCierre);
        add(spinnerHoraCierre);
        add(new JLabel()); // Espacio vacío
        add(btnGuardar);

        // Mostrar la ventana
        setVisible(true);
    }

    private void guardarHorarios() {
        Date horaApertura = (Date) spinnerHoraApertura.getValue();
        Date horaCierre = (Date) spinnerHoraCierre.getValue();
        
        // Mostrar las horas seleccionadas
        JOptionPane.showMessageDialog(this, 
            "Hora de Apertura: " + horaApertura + "\nHora de Cierre: " + horaCierre,
            "Horarios Guardados", JOptionPane.INFORMATION_MESSAGE);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
