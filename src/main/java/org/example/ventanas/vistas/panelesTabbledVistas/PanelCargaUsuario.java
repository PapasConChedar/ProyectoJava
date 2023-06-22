/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.ventanas.vistas.panelesTabbledVistas;

import com.org.example.Exceptions.UsuarioCargaDatosException;
import com.org.example.clases.Cliente;
import com.org.example.clases.Empleado;
import com.org.example.service.GestionImpleCliente;
import com.org.example.service.GestionImpleEmpleado;
import com.org.example.service.Utils;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Agus-Notebook
 */
public class PanelCargaUsuario extends javax.swing.JPanel {
    private Utils utilidades = new Utils();
    private GestionImpleEmpleado gestorEmpleado;
    private GestionImpleCliente gestor;
    private Cliente dato = new Cliente();
    private Empleado empleado = new Empleado();

    /**
     * Creates new form NewPanelCargaUsuario
     */
    public PanelCargaUsuario() {
        initComponents();
        gestorEmpleado = new GestionImpleEmpleado();
        gestor = new GestionImpleCliente();
    }

    public void reestablecerTextoCargaUsuario() {
        ingresoNombre.setForeground(new Color(153, 153, 153));
        ingresoApellido.setForeground(new Color(153, 153, 153));
        ingresoDireccion.setForeground(new Color(153, 153, 153));
        ingresoEmail.setForeground(new Color(153, 153, 153));
        ingresoDni.setForeground(new Color(153, 153, 153));
        ingresoTelefono.setForeground(new Color(153, 153, 153));
        ingresoContrasenia.setForeground(new Color(153, 153, 153));
        ingresoNombre.setText("  Ingrese Nombre Cliente");
        ingresoApellido.setText("  Ingrese Apellido Cliente");
        ingresoDireccion.setText("  Ingrese Direccion Cliente");
        ingresoEmail.setText("  Ingrese Email Cliente");
        ingresoTelefono.setText("  Ingrese Telefono Cliente");
        ingresoDni.setText("  Ingrese Dni Cliente");
        ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
    }

    private void edicionLetraColortexto(JTextField ingreso) {
        ingreso.setText("");
        ingreso.setForeground(Color.BLACK);
    }

    public boolean verificacionIngresos() throws UsuarioCargaDatosException {
        if (gestor.verificacionIngresoBases(ingresoNombre.getText(), ingresoApellido.getText(), ingresoDireccion.getText(),
                ingresoEmail.getText(), ingresoTelefono.getText(), ingresoDni.getText(), ingresoContrasenia.getText())) {

            if (gestor.verificarIngresosVacios(ingresoNombre.getText(), ingresoApellido.getText(), ingresoDireccion.getText(),
                    ingresoEmail.getText(), ingresoTelefono.getText(), ingresoDni.getText(), ingresoContrasenia.getText())) {

                if (gestor.verificacionFormatoIngresos(ingresoEmail.getText(), ingresoTelefono.getText(), ingresoDni.getText(),
                        ingresoContrasenia.getText())) {
                    if(utilidades.validEmail(ingresoEmail.getText())){
                        if(utilidades.validPassword(ingresoContrasenia.getText())){  
                            return true;
                        }else{
                            throw new UsuarioCargaDatosException(4);
                        }
                    }else{
                        throw new UsuarioCargaDatosException(3);
                    }
                } else {
                    throw new UsuarioCargaDatosException(6);
                }
            } else {
                throw new UsuarioCargaDatosException(7);
            }
        } else {
            throw new UsuarioCargaDatosException(9);
        }
    }

    public void cargaUsuarioAlSistema() throws UsuarioCargaDatosException {
        if (verificacionIngresos()) {
            dato.setIdCliente(gestor.crearIdUsuario());
            dato.setNombre(ingresoNombre.getText());
            dato.setApellido(ingresoApellido.getText());
            dato.setDireccion(ingresoDireccion.getText());
            dato.setEmail(ingresoEmail.getText());
            dato.setTelefono(ingresoTelefono.getText());
            dato.setDni(ingresoDni.getText());
            dato.setContrasenia(ingresoContrasenia.getText());
            dato.setNumeroCuenta(String.valueOf(gestor.crearNumeroCuentaUsuarios(dato)));
            if (gestor.verificarUsuarioRepetido(dato)) {
                gestor.add(dato);
                reestablecerTextoCargaUsuario();
            } else {
                throw new UsuarioCargaDatosException(5);
            }
        } else {
            throw new UsuarioCargaDatosException(3);
        }
    }
    
    public void cargaEmpleadoAlSistema() throws UsuarioCargaDatosException {
        if (verificacionIngresos()) {
            empleado.setIdEmpleado(gestorEmpleado.getList().size());
            empleado.setNombre(ingresoNombre.getText());
            empleado.setApellido(ingresoApellido.getText());
            empleado.setDireccion(ingresoDireccion.getText());
            empleado.setEmail(ingresoEmail.getText());
            empleado.setDni(ingresoDni.getText());
            empleado.setContrasenia(ingresoContrasenia.getText());
            if (gestorEmpleado.verificarUsuarioRepetido(empleado)) {
                gestorEmpleado.add(empleado);
                reestablecerTextoCargaUsuario();
            } else {
                throw new UsuarioCargaDatosException(5);
            }
        } else {
            throw new UsuarioCargaDatosException(3);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanelCargaProducto = new javax.swing.JPanel();
        iconoPanelCarga = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        btnLimpiarIngreso1 = new javax.swing.JButton();
        btnGuardarIngreso = new javax.swing.JButton();
        panelIngreso = new javax.swing.JPanel();
        ingresoNombre = new javax.swing.JTextField();
        ingresoApellido = new javax.swing.JTextField();
        ingresoDireccion = new javax.swing.JTextField();
        ingresoEmail = new javax.swing.JTextField();
        ingresoTelefono = new javax.swing.JTextField();
        ingresoDni = new javax.swing.JTextField();
        ingresoContrasenia = new javax.swing.JTextField();
        checkTipoUsuario = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(800, 510));

        backgroundPanelCargaProducto.setBackground(new java.awt.Color(147, 118, 224));
        backgroundPanelCargaProducto.setMaximumSize(new java.awt.Dimension(800, 510));
        backgroundPanelCargaProducto.setMinimumSize(new java.awt.Dimension(800, 510));
        backgroundPanelCargaProducto.setPreferredSize(new java.awt.Dimension(800, 510));
        backgroundPanelCargaProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconoPanelCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lista-de-verificacion (1).png"))); // NOI18N
        backgroundPanelCargaProducto.add(iconoPanelCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, -1, -1));

        panelBotones.setBackground(new java.awt.Color(255, 170, 201));
        panelBotones.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 204, 255)));

        btnLimpiarIngreso1.setBackground(new java.awt.Color(172, 188, 255));
        btnLimpiarIngreso1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLimpiarIngreso1.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarIngreso1.setText("LIMPIAR");
        btnLimpiarIngreso1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpiarIngreso1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarIngreso1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarIngreso1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarIngreso1MouseExited(evt);
            }
        });
        btnLimpiarIngreso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarIngreso1ActionPerformed(evt);
            }
        });

        btnGuardarIngreso.setBackground(new java.awt.Color(172, 188, 255));
        btnGuardarIngreso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarIngreso.setText("GUARDAR");
        btnGuardarIngreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardarIngreso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarIngresoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarIngresoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarIngresoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnLimpiarIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiarIngreso1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backgroundPanelCargaProducto.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 350, -1));

        panelIngreso.setBackground(new java.awt.Color(188, 140, 242));
        panelIngreso.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 204, 255)));

        ingresoNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoNombre.setForeground(new java.awt.Color(153, 153, 153));
        ingresoNombre.setText("  Ingrese Nombre Cliente");
        ingresoNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ingresoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoNombreMouseClicked(evt);
            }
        });

        ingresoApellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoApellido.setForeground(new java.awt.Color(153, 153, 153));
        ingresoApellido.setText("  Ingrese Apellido Cliente");
        ingresoApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoApellidoMouseClicked(evt);
            }
        });

        ingresoDireccion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoDireccion.setForeground(new java.awt.Color(153, 153, 153));
        ingresoDireccion.setText("  Ingrese Direccion Cliente");
        ingresoDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoDireccionMouseClicked(evt);
            }
        });

        ingresoEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoEmail.setForeground(new java.awt.Color(153, 153, 153));
        ingresoEmail.setText("  Ingrese Email Cliente");
        ingresoEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoEmailMouseClicked(evt);
            }
        });

        ingresoTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoTelefono.setForeground(new java.awt.Color(153, 153, 153));
        ingresoTelefono.setText("  Ingrese Telefono Cliente");
        ingresoTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoTelefonoMouseClicked(evt);
            }
        });

        ingresoDni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoDni.setForeground(new java.awt.Color(153, 153, 153));
        ingresoDni.setText("  Ingrese Dni Cliente");
        ingresoDni.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoDniMouseClicked(evt);
            }
        });

        ingresoContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresoContrasenia.setForeground(new java.awt.Color(153, 153, 153));
        ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
        ingresoContrasenia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresoContraseniaMouseClicked(evt);
            }
        });

        checkTipoUsuario.setText("Tilde si el Usuario es un Empleado");

        javax.swing.GroupLayout panelIngresoLayout = new javax.swing.GroupLayout(panelIngreso);
        panelIngreso.setLayout(panelIngresoLayout);
        panelIngresoLayout.setHorizontalGroup(
            panelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIngresoLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(panelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ingresoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ingresoDni, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(ingresoTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(ingresoNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ingresoContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(checkTipoUsuario))
                        .addGroup(panelIngresoLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(ingresoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelIngresoLayout.setVerticalGroup(
            panelIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIngresoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ingresoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresoDni, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ingresoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkTipoUsuario)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        backgroundPanelCargaProducto.add(panelIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 480, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanelCargaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanelCargaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarIngreso1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarIngreso1MouseEntered
        // TODO add your handling code here:
        btnLimpiarIngreso1.setBackground(new Color(121, 215, 220));
        btnLimpiarIngreso1.setForeground(new Color(57, 136, 158));
    }//GEN-LAST:event_btnLimpiarIngreso1MouseEntered

    private void btnLimpiarIngreso1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarIngreso1MouseExited
        // TODO add your handling code here:
        btnLimpiarIngreso1.setBackground(new Color(57, 136, 158));
        btnLimpiarIngreso1.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnLimpiarIngreso1MouseExited

    private void btnLimpiarIngreso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarIngreso1ActionPerformed
        // TODO add your handling code here:
        ingresoNombre.setText("");
        ingresoApellido.setText("");
        ingresoDireccion.setText("");
        ingresoEmail.setText("");
        ingresoTelefono.setText("");
        ingresoDni.setText("");
        ingresoContrasenia.setText("");
        ingresoDni.setText("");
        reestablecerTextoCargaUsuario();

    }//GEN-LAST:event_btnLimpiarIngreso1ActionPerformed

    private void btnGuardarIngresoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarIngresoMouseEntered
        // TODO add your handling code here:
        btnGuardarIngreso.setBackground(new Color(121, 215, 220));
        btnGuardarIngreso.setForeground(new Color(57, 136, 158));
    }//GEN-LAST:event_btnGuardarIngresoMouseEntered

    private void btnGuardarIngresoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarIngresoMouseExited
        // TODO add your handling code here:
        btnGuardarIngreso.setBackground(new Color(57, 136, 158));
        btnGuardarIngreso.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnGuardarIngresoMouseExited

    private void ingresoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoNombreMouseClicked
        // TODO add your handling code here:
        if (ingresoNombre.getText().equals("  Ingrese Nombre Cliente")) {
            edicionLetraColortexto(ingresoNombre);
        }
        if (ingresoApellido.getText().isEmpty()) {
            ingresoApellido.setForeground(new Color(153, 153, 153));
            ingresoApellido.setText("  Ingrese Apellido Cliente");
        }
        if (ingresoDireccion.getText().isEmpty()) {
            ingresoDireccion.setForeground(new Color(153, 153, 153));
            ingresoDireccion.setText("  Ingrese Direccion Cliente");
        }
        if (ingresoEmail.getText().isEmpty()) {
            ingresoEmail.setForeground(new Color(153, 153, 153));
            ingresoEmail.setText("  Ingrese Email Cliente");
        }
        if (ingresoDni.getText().isEmpty()) {
            ingresoDni.setForeground(new Color(153, 153, 153));
            ingresoDni.setText("  Ingrese Dni Cliente");

        }
        if (ingresoTelefono.getText().isEmpty()) {
            ingresoTelefono.setForeground(new Color(153, 153, 153));
            ingresoTelefono.setText("  Ingrese Telefono Cliente");
        }
        if (ingresoContrasenia.getText().isEmpty()) {
            ingresoContrasenia.setForeground(new Color(153, 153, 153));
            ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
        }
    }//GEN-LAST:event_ingresoNombreMouseClicked

    private void ingresoApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoApellidoMouseClicked
        // TODO add your handling code here:
        if (ingresoNombre.getText().isEmpty()) {
            ingresoNombre.setForeground(new Color(153, 153, 153));
            ingresoNombre.setText("  Ingrese Nombre Cliente");
        }
        if (ingresoApellido.getText().equals("  Ingrese Apellido Cliente")) {
            edicionLetraColortexto(ingresoApellido);
        }
        if (ingresoDireccion.getText().isEmpty()) {
            ingresoDireccion.setForeground(new Color(153, 153, 153));
            ingresoDireccion.setText("  Ingrese Direccion Cliente");
        }
        if (ingresoEmail.getText().isEmpty()) {
            ingresoEmail.setForeground(new Color(153, 153, 153));
            ingresoEmail.setText("  Ingrese Email Cliente");
        }
        if (ingresoDni.getText().isEmpty()) {
            ingresoDni.setForeground(new Color(153, 153, 153));
            ingresoDni.setText("  Ingrese Dni Cliente");

        }
        if (ingresoTelefono.getText().isEmpty()) {
            ingresoTelefono.setForeground(new Color(153, 153, 153));
            ingresoTelefono.setText("  Ingrese Telefono Cliente");
        }
        if (ingresoContrasenia.getText().isEmpty()) {
            ingresoContrasenia.setForeground(new Color(153, 153, 153));
            ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
        }
    }//GEN-LAST:event_ingresoApellidoMouseClicked

    private void ingresoDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoDireccionMouseClicked
        // TODO add your handling code here:
        if (ingresoNombre.getText().isEmpty()) {
            ingresoNombre.setForeground(new Color(153, 153, 153));
            ingresoNombre.setText("  Ingrese Nombre Cliente");
        }
        if (ingresoApellido.getText().isEmpty()) {
            ingresoApellido.setForeground(new Color(153, 153, 153));
            ingresoApellido.setText("  Ingrese Nombre del Producto");
        }
        if (ingresoDireccion.getText().equals("  Ingrese Direccion Cliente")) {
            edicionLetraColortexto(ingresoDireccion);
        }
        if (ingresoEmail.getText().isEmpty()) {
            ingresoEmail.setForeground(new Color(153, 153, 153));
            ingresoEmail.setText("  Ingrese Email Cliente");
        }
        if (ingresoDni.getText().isEmpty()) {
            ingresoDni.setForeground(new Color(153, 153, 153));
            ingresoDni.setText("  Ingrese Dni Cliente");

        }
        if (ingresoTelefono.getText().isEmpty()) {
            ingresoTelefono.setForeground(new Color(153, 153, 153));
            ingresoTelefono.setText("  Ingrese Telefono Cliente");
        }
        if (ingresoContrasenia.getText().isEmpty()) {
            ingresoContrasenia.setForeground(new Color(153, 153, 153));
            ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
        }
    }//GEN-LAST:event_ingresoDireccionMouseClicked

    private void ingresoEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoEmailMouseClicked
        // TODO add your handling code here:
        if (ingresoNombre.getText().isEmpty()) {
            ingresoNombre.setForeground(new Color(153, 153, 153));
            ingresoNombre.setText("  Ingrese Nombre Cliente");
        }
        if (ingresoApellido.getText().isEmpty()) {
            ingresoApellido.setForeground(new Color(153, 153, 153));
            ingresoApellido.setText("  Ingrese Nombre del Producto");
        }
        if (ingresoDireccion.getText().isEmpty()) {
            ingresoDireccion.setForeground(new Color(153, 153, 153));
            ingresoDireccion.setText("  Ingrese Direccion Cliente");
        }
        if (ingresoEmail.getText().equals("  Ingrese Email Cliente")) {
            edicionLetraColortexto(ingresoEmail);
        }
        if (ingresoDni.getText().isEmpty()) {
            ingresoDni.setForeground(new Color(153, 153, 153));
            ingresoDni.setText("  Ingrese Dni Cliente");

        }
        if (ingresoTelefono.getText().isEmpty()) {
            ingresoTelefono.setForeground(new Color(153, 153, 153));
            ingresoTelefono.setText("  Ingrese Telefono Cliente");
        }
        if (ingresoContrasenia.getText().isEmpty()) {
            ingresoContrasenia.setForeground(new Color(153, 153, 153));
            ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
        }
    }//GEN-LAST:event_ingresoEmailMouseClicked

    private void ingresoTelefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoTelefonoMouseClicked
        // TODO add your handling code here:
        if (ingresoNombre.getText().isEmpty()) {
            ingresoNombre.setForeground(new Color(153, 153, 153));
            ingresoNombre.setText("  Ingrese Nombre Cliente");
        }
        if (ingresoApellido.getText().isEmpty()) {
            ingresoApellido.setForeground(new Color(153, 153, 153));
            ingresoApellido.setText("  Ingrese Apellido del Producto");
        }
        if (ingresoDireccion.getText().isEmpty()) {
            ingresoDireccion.setForeground(new Color(153, 153, 153));
            ingresoDireccion.setText("  Ingrese Direccion Cliente");
        }
        if (ingresoEmail.getText().isEmpty()) {
            ingresoEmail.setForeground(new Color(153, 153, 153));
            ingresoEmail.setText("  Ingrese Email Cliente");
        }
        if (ingresoDni.getText().isEmpty()) {
            ingresoDni.setForeground(new Color(153, 153, 153));
            ingresoDni.setText("  Ingrese Dni Cliente");
        }
        if (ingresoTelefono.getText().equals("  Ingrese Telefono Cliente")) {
            edicionLetraColortexto(ingresoTelefono);
        }
        if (ingresoContrasenia.getText().isEmpty()) {
            ingresoContrasenia.setForeground(new Color(153, 153, 153));
            ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
        }
    }//GEN-LAST:event_ingresoTelefonoMouseClicked

    private void ingresoDniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoDniMouseClicked
        // TODO add your handling code here:
        if (ingresoNombre.getText().isEmpty()) {
            ingresoNombre.setForeground(new Color(153, 153, 153));
            ingresoNombre.setText("  Ingrese Nombre Cliente");
        }
        if (ingresoApellido.getText().isEmpty()) {
            ingresoApellido.setForeground(new Color(153, 153, 153));
            ingresoApellido.setText("  Ingrese Apellido del Producto");
        }
        if (ingresoDireccion.getText().isEmpty()) {
            ingresoDireccion.setForeground(new Color(153, 153, 153));
            ingresoDireccion.setText("  Ingrese Direccion Cliente");
        }
        if (ingresoEmail.getText().isEmpty()) {
            ingresoEmail.setForeground(new Color(153, 153, 153));
            ingresoEmail.setText("  Ingrese Email Cliente");
        }
        if (ingresoDni.getText().equals("  Ingrese Dni Cliente")) {
            edicionLetraColortexto(ingresoDni);
        }
        if (ingresoTelefono.getText().isEmpty()) {
            ingresoTelefono.setForeground(new Color(153, 153, 153));
            ingresoTelefono.setText("  Ingrese Telefono Cliente");
        }
        if (ingresoContrasenia.getText().isEmpty()) {
            ingresoContrasenia.setForeground(new Color(153, 153, 153));
            ingresoContrasenia.setText("  Ingrese Contraseña Cliente");
        }
    }//GEN-LAST:event_ingresoDniMouseClicked

    private void ingresoContraseniaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresoContraseniaMouseClicked
        // TODO add your handling code here:
        if (ingresoNombre.getText().isEmpty()) {
            ingresoNombre.setForeground(new Color(153, 153, 153));
            ingresoNombre.setText("  Ingrese Nombre Cliente");
        }
        if (ingresoApellido.getText().isEmpty()) {
            ingresoApellido.setForeground(new Color(153, 153, 153));
            ingresoApellido.setText("  Ingrese Apellido del Producto");
        }
        if (ingresoDireccion.getText().isEmpty()) {
            ingresoDireccion.setForeground(new Color(153, 153, 153));
            ingresoDireccion.setText("  Ingrese Direccion Cliente");
        }
        if (ingresoEmail.getText().isEmpty()) {
            ingresoEmail.setForeground(new Color(153, 153, 153));
            ingresoEmail.setText("  Ingrese Email Cliente");
        }
        if (ingresoDni.getText().isEmpty()) {
            ingresoDni.setForeground(new Color(153, 153, 153));
            ingresoDni.setText("  Ingrese Dni Cliente");
        }
        if (ingresoTelefono.getText().isEmpty()) {
            ingresoTelefono.setForeground(new Color(153, 153, 153));
            ingresoTelefono.setText("  Ingrese Telefono Cliente");
        }
        if (ingresoContrasenia.getText().equals("  Ingrese Contraseña Cliente")) {
            edicionLetraColortexto(ingresoContrasenia);
        }
    }//GEN-LAST:event_ingresoContraseniaMouseClicked

    private void btnLimpiarIngreso1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarIngreso1MouseClicked
        // TODO add your handling code here:
        ingresoNombre.setText("");
        ingresoApellido.setText("");
        ingresoDireccion.setText("");
        ingresoEmail.setText("");
        ingresoTelefono.setText("");
        ingresoDni.setText("");
        ingresoContrasenia.setText("");
        reestablecerTextoCargaUsuario();
    }//GEN-LAST:event_btnLimpiarIngreso1MouseClicked

    private void btnGuardarIngresoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarIngresoMouseClicked
        // TODO add your handling code here:
        if (!checkTipoUsuario.isSelected()) {
            try {
                cargaUsuarioAlSistema();
            } catch (UsuarioCargaDatosException e) {
                JOptionPane.showMessageDialog(null, e.escribirMensaje());
            }
        } else {
            try {
                cargaEmpleadoAlSistema();
            } catch (UsuarioCargaDatosException e) {
                JOptionPane.showMessageDialog(null, e.escribirMensaje());
            }
        }
    }//GEN-LAST:event_btnGuardarIngresoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanelCargaProducto;
    private javax.swing.JButton btnGuardarIngreso;
    private javax.swing.JButton btnLimpiarIngreso1;
    private javax.swing.JCheckBox checkTipoUsuario;
    private javax.swing.JLabel iconoPanelCarga;
    private javax.swing.JTextField ingresoApellido;
    private javax.swing.JTextField ingresoContrasenia;
    private javax.swing.JTextField ingresoDireccion;
    private javax.swing.JTextField ingresoDni;
    private javax.swing.JTextField ingresoEmail;
    private javax.swing.JTextField ingresoNombre;
    private javax.swing.JTextField ingresoTelefono;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelIngreso;
    // End of variables declaration//GEN-END:variables
}
