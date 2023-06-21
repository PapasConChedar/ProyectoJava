/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.ventanas.vistas.panelesTabbledVistas;

import com.org.example.Exceptions.UsuarioCargaDatosException;
import com.org.example.clases.Cliente;
import com.org.example.service.GestionImpleCliente;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Agus-Notebook
 */
public class PanelCargaUsuario extends javax.swing.JPanel {
    private final GestionImpleCliente gestor = new GestionImpleCliente();
    private Cliente dato = new Cliente();


    /**
     * Creates new form PanelCargaUsuario
     */
    public PanelCargaUsuario() {
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

        jSlider1 = new javax.swing.JSlider();
        backgroundPanelCargaUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ingresoNombreUsuario = new javax.swing.JTextField();
        ingresoApellidoUsuario = new javax.swing.JTextField();
        ingresoDireccionUsuario = new javax.swing.JTextField();
        ingresoEmailUsuario = new javax.swing.JTextField();
        ingresoTelefonoUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ingresoContraseñaUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ingresoDniUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        guardarUsuarioNuevo = new javax.swing.JButton();
        btnLimpiarPanel = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 560));
        setMinimumSize(new java.awt.Dimension(800, 560));
        setPreferredSize(new java.awt.Dimension(800, 560));

        backgroundPanelCargaUsuario.setBackground(new java.awt.Color(204, 204, 255));
        backgroundPanelCargaUsuario.setMaximumSize(new java.awt.Dimension(800, 560));
        backgroundPanelCargaUsuario.setMinimumSize(new java.awt.Dimension(800, 560));
        backgroundPanelCargaUsuario.setPreferredSize(new java.awt.Dimension(800, 560));
        backgroundPanelCargaUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lista-de-verificacion (1).png"))); // NOI18N
        backgroundPanelCargaUsuario.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 130, 140));

        jPanel1.setBackground(new java.awt.Color(153, 100, 232));

        ingresoNombreUsuario.setBackground(new java.awt.Color(204, 204, 255));
        ingresoNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoNombreUsuario.setForeground(new java.awt.Color(153, 100, 232));
        ingresoNombreUsuario.setText("   Ingrese Nombre del Usuario");
        ingresoNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoNombreUsuarioActionPerformed(evt);
            }
        });

        ingresoApellidoUsuario.setBackground(new java.awt.Color(205, 205, 255));
        ingresoApellidoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoApellidoUsuario.setForeground(new java.awt.Color(153, 100, 232));
        ingresoApellidoUsuario.setText("   Ingrese Apellido del Usuario");

        ingresoDireccionUsuario.setBackground(new java.awt.Color(205, 205, 255));
        ingresoDireccionUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoDireccionUsuario.setForeground(new java.awt.Color(153, 100, 232));
        ingresoDireccionUsuario.setText("   Ingrese Direccion del Usuario");
        ingresoDireccionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoDireccionUsuarioActionPerformed(evt);
            }
        });

        ingresoEmailUsuario.setBackground(new java.awt.Color(205, 205, 255));
        ingresoEmailUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoEmailUsuario.setForeground(new java.awt.Color(153, 100, 232));
        ingresoEmailUsuario.setText("   Ingrese Email del Usuario");

        ingresoTelefonoUsuario.setBackground(new java.awt.Color(205, 205, 255));
        ingresoTelefonoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoTelefonoUsuario.setForeground(new java.awt.Color(153, 100, 232));
        ingresoTelefonoUsuario.setText("   Ingrese Telefono del Usuario");

        ingresoContraseñaUsuario.setBackground(new java.awt.Color(205, 205, 255));
        ingresoContraseñaUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoContraseñaUsuario.setForeground(new java.awt.Color(153, 100, 232));
        ingresoContraseñaUsuario.setText("   Ingrese Contraseña del Usuario");
        ingresoContraseñaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoContraseñaUsuarioActionPerformed(evt);
            }
        });

        ingresoDniUsuario.setBackground(new java.awt.Color(205, 205, 255));
        ingresoDniUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoDniUsuario.setForeground(new java.awt.Color(153, 100, 232));
        ingresoDniUsuario.setText("   Ingrese DNI del Usuario");
        ingresoDniUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoDniUsuarioActionPerformed(evt);
            }
        });

        guardarUsuarioNuevo.setBackground(new java.awt.Color(255, 220, 116));
        guardarUsuarioNuevo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        guardarUsuarioNuevo.setForeground(new java.awt.Color(153, 100, 232));
        guardarUsuarioNuevo.setText("GUARDAR");
        guardarUsuarioNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 141, 122), 4));
        guardarUsuarioNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarUsuarioNuevoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guardarUsuarioNuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                guardarUsuarioNuevoMouseExited(evt);
            }
        });
        guardarUsuarioNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarUsuarioNuevoActionPerformed(evt);
            }
        });

        btnLimpiarPanel.setBackground(new java.awt.Color(255, 220, 116));
        btnLimpiarPanel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLimpiarPanel.setForeground(new java.awt.Color(153, 100, 232));
        btnLimpiarPanel.setText("LIMPIAR");
        btnLimpiarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 141, 122), 4));
        btnLimpiarPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarPanelMouseExited(evt);
            }
        });
        btnLimpiarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(ingresoDireccionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ingresoEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ingresoNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ingresoApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(3, 3, 3)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addGap(29, 29, 29)
                                                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addComponent(btnLimpiarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(ingresoTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(ingresoContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(76, 76, 76)))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(guardarUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ingresoDniUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(ingresoNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ingresoApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ingresoDireccionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jLabel7))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(ingresoEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ingresoTelefonoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addComponent(ingresoContraseñaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ingresoDniUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLimpiarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(guardarUsuarioNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        backgroundPanelCargaUsuario.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 370, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanelCargaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanelCargaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    /**
     * Funcion que setea color al texto ingresao
     *
     */
    private void edicionLetraColorTexto(JTextField ingreso){
        ingreso.setText("");
        ingreso.setForeground(Color.BLACK);
    }


    /**
     *  RestablecerParametros de los texto de ingreso
     *
     */
    public void reestablecerTextoCargaUsuario(){
        ingresoNombreUsuario.setText("   Ingrese Nombre del Usuario");
        ingresoApellidoUsuario.setText("   Ingrese Apellido del Usuario");
        ingresoDireccionUsuario.setText("   Ingrese Direccion del Usuario");
        ingresoEmailUsuario.setText("   Ingrese Email del Usuario");
        ingresoTelefonoUsuario.setText("   Ingrese Telefono del Usuario");
        ingresoContraseñaUsuario.setText("   Ingrese Contraseña del Usuario");
        ingresoDniUsuario.setText("   Ingrese DNI del Usuario");
    }


    private boolean verificacionFormato() throws UsuarioCargaDatosException {
        if (gestor.verificacionIngresoBases(
                ingresoNombreUsuario.getText(),
                ingresoApellidoUsuario.getText(),
                ingresoDireccionUsuario.getText(),
                ingresoEmailUsuario.getText(),
                ingresoTelefonoUsuario.getText(),
                ingresoContraseñaUsuario.getText(),
                ingresoDniUsuario.getText())) {
            if (gestor.verificarIngresosVacios(
                    ingresoNombreUsuario.getText(),
                    ingresoApellidoUsuario.getText(),
                    ingresoDireccionUsuario.getText(),
                    ingresoEmailUsuario.getText(),
                    ingresoTelefonoUsuario.getText(),
                    ingresoContraseñaUsuario.getText(),
                    ingresoDniUsuario.getText())) {
                if (gestor.verificacionFormatoInteger(
                        ingresoDniUsuario.getText(),
                        ingresoTelefonoUsuario.getText())) {
                    return true;
                } else {
                    throw new UsuarioCargaDatosException(
                            8);
                }
            } else {
                throw new UsuarioCargaDatosException(
                        7);
            }

        } else {
            throw new UsuarioCargaDatosException(
                    7);
        }
    }




    private void ingresoNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoNombreUsuarioActionPerformed

    private void btnLimpiarPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPanelActionPerformed
        ingresoNombreUsuario.setText("");
        ingresoApellidoUsuario.setText("");
        ingresoDireccionUsuario.setText("");
        ingresoEmailUsuario.setText("");
        ingresoTelefonoUsuario.setText("");
        ingresoContraseñaUsuario.setText("");
        ingresoDniUsuario.setText("");
    }//GEN-LAST:event_btnLimpiarPanelActionPerformed

    private void guardarUsuarioNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarUsuarioNuevoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_guardarUsuarioNuevoActionPerformed

    private void ingresoContraseñaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoContraseñaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoContraseñaUsuarioActionPerformed

    private void ingresoDniUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoDniUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoDniUsuarioActionPerformed

    private void guardarUsuarioNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarUsuarioNuevoMouseClicked
        // TODO add your handling code here:
        try{
            if(verificacionFormato()){
                dato.setIdCliente(gestor.crearIdUsuario());
                dato.setNombre(ingresoNombreUsuario.getText());
                dato.setApellido(ingresoApellidoUsuario.getText());
                dato.setDireccion(ingresoDireccionUsuario.getText());
                dato.setEmail(ingresoEmailUsuario.getText());
                dato.setTelefono(ingresoTelefonoUsuario.getText());
                dato.setContrasenia(ingresoContraseñaUsuario.getText());
                dato.setDni(ingresoDniUsuario.getText());
                dato.setNumeroCuenta(String.valueOf(dato.hashCode()));
                gestor.add(dato);
                reestablecerTextoCargaUsuario();
                dato = new Cliente();
            }
        }catch (UsuarioCargaDatosException e){
            JOptionPane.showMessageDialog(null,e.getMessage()+e.escribirMensaje());
        }
    }//GEN-LAST:event_guardarUsuarioNuevoMouseClicked

    private void ingresoDireccionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoDireccionUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingresoDireccionUsuarioActionPerformed

    private void guardarUsuarioNuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarUsuarioNuevoMouseEntered
        // TODO add your handling code here:
        guardarUsuarioNuevo.setBackground(new java.awt.Color(255, 220, 116));
        guardarUsuarioNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 219, 130), 4));
        guardarUsuarioNuevo.setForeground(new java.awt.Color(244, 141, 122));
    }//GEN-LAST:event_guardarUsuarioNuevoMouseEntered

    private void guardarUsuarioNuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarUsuarioNuevoMouseExited
        // TODO add your handling code here:
        guardarUsuarioNuevo.setBackground(new java.awt.Color(246, 209, 103));
        guardarUsuarioNuevo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        guardarUsuarioNuevo.setForeground(new java.awt.Color(153, 100, 232));
        guardarUsuarioNuevo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 141, 122), 4));
    }//GEN-LAST:event_guardarUsuarioNuevoMouseExited

    private void btnLimpiarPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarPanelMouseEntered
        // TODO add your handling code here:
        btnLimpiarPanel.setBackground(new java.awt.Color(255, 220, 116));
        btnLimpiarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(180, 219, 130), 4));
        btnLimpiarPanel.setForeground(new java.awt.Color(244, 141, 122));
    }//GEN-LAST:event_btnLimpiarPanelMouseEntered

    private void btnLimpiarPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarPanelMouseExited
        // TODO add your handling code here:
        btnLimpiarPanel.setBackground(new java.awt.Color(246, 209, 103));
        btnLimpiarPanel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnLimpiarPanel.setForeground(new java.awt.Color(153, 100, 232));
        btnLimpiarPanel.setText("LIMPIAR");
        btnLimpiarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 141, 122), 4));
    }//GEN-LAST:event_btnLimpiarPanelMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanelCargaUsuario;
    private javax.swing.JButton btnLimpiarPanel;
    private javax.swing.JButton guardarUsuarioNuevo;
    private javax.swing.JTextField ingresoApellidoUsuario;
    private javax.swing.JTextField ingresoContraseñaUsuario;
    private javax.swing.JTextField ingresoDireccionUsuario;
    private javax.swing.JTextField ingresoDniUsuario;
    private javax.swing.JTextField ingresoEmailUsuario;
    private javax.swing.JTextField ingresoNombreUsuario;
    private javax.swing.JTextField ingresoTelefonoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
