/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucr.ac.cr.b68103.vista;

import java.awt.event.ActionListener;

/**
 *
 * @author Usuario
 */
public class PnlBotonesPrestamo extends javax.swing.JPanel {

    /**
     * Creates new form PnlBotonesPrestamo
     */
    public PnlBotonesPrestamo() {
        initComponents();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultarPrestamo = new javax.swing.JButton();
        btnEliminarPrestamo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        btnConsultarPrestamo.setText("Consultar préstamo");

        btnEliminarPrestamo.setText("Eliminar préstamo");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnConsultarPrestamo)
                .addGap(50, 50, 50)
                .addComponent(btnEliminarPrestamo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
 public void escuchar(ActionListener control){
        btnConsultarPrestamo.addActionListener(control);
        btnEliminarPrestamo.addActionListener(control);
        btnSalir.addActionListener(control);
    }
public static final String BTN_CONSULTAR="Consultar préstamo";
public static final String  BTN_ELIMINARC="Eliminar préstamo";
public static final String BTN_SALIR="Salir";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarPrestamo;
    private javax.swing.JButton btnEliminarPrestamo;
    private javax.swing.JButton btnSalir;
    // End of variables declaration//GEN-END:variables
}