/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.ventanas.vistas.panelesTabbledVistas;

import com.org.example.clases.Cliente;
import com.org.example.clases.Empleado;
import com.org.example.service.GestionImpleCliente;
import com.org.example.service.GestionImpleEmpleado;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Agus-Notebook
 */
public class PanelTablaUsuarios extends javax.swing.JPanel {
    private GestionImpleEmpleado gestorEmple;
    private GestionImpleCliente gestor;
    private final DefaultTableModel modelo;
    private Cliente clienteSeleccionado = new Cliente();

    private class rederizadorTabla extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object item, boolean isSelected, boolean hasFocus, int row, int column) {
            if (item instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) item;
                return checkBox;
            }
            return super.getTableCellRendererComponent(table, item, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        }

    }

    /**
     * Creates new form panelTablaUsuarios
     */
    public PanelTablaUsuarios() {
        String[] titulos = {"ID","Tipo", "Nombre", "Direccion", "Email", "Contraseña",
            "Telefono", "Seleccion"};
        Boolean[] titulosEditables = {false,false, false, false, false, false, false, true};
        Class[] titulosObjetos = {String.class,String.class, String.class, String.class,
            String.class, String.class, String.class, Boolean.class};

        initComponents();
        gestorEmple = new GestionImpleEmpleado();
        gestor = new GestionImpleCliente();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return titulosEditables[column];
            }

            public Class getColumnClass(int indice
            ) {
                return titulosObjetos[indice];
            }
        };

        modelo.setColumnIdentifiers(titulos);
        cargarTabla();
        tablaUsuarios.setModel(modelo);
    }

    /**
     * Carga la tabla con los valores que contiene el repositorio
     */
    public void cargarTabla() {
        for (Cliente i : gestor.getList()) {
            Object[] infDatos = new Object[8];
            infDatos[0] = i.getIdCliente();
            infDatos[1] = "Cliente";
            infDatos[2] = i.getNombre() + " " + i.getApellido();
            infDatos[3] = i.getDireccion();
            infDatos[4] = i.getEmail();
            infDatos[5] = i.getContrasenia();
            infDatos[6] = i.getTelefono();
            infDatos[7] = false;
            modelo.addRow(infDatos);
        }
        for(Empleado j : gestorEmple.getList()){
            Object[] infDatos = new Object[8];
            infDatos[0] = j.getIdEmpleado();
            infDatos[1] = "Empleado";
            infDatos[2] = j.getNombre() + " " + j.getApellido();
            infDatos[3] = j.getDireccion();
            infDatos[4] = j.getEmail();
            infDatos[5] = j.getContraseña();
            infDatos[6] = "-------";
            infDatos[7] = false;
            modelo.addRow(infDatos);
        }
    }

    public int verificarSeleccionados(int posicion) {
        int contador = 0;
        for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {
            boolean seleccion = (boolean) tablaUsuarios.getValueAt(i, posicion);
            if (seleccion) {
                contador++;
            }
        }
        return contador;
    }

    public Cliente obtenerClienteDeTabla(int posicion){
        boolean seleccion = (boolean) tablaUsuarios.getValueAt(posicion, 6);
        if (seleccion) {
            String idCliente = tablaUsuarios.getValueAt(posicion, 0).toString();
            return gestor.getById(idCliente);
        }
        return null;
    }

    public ArrayList<Cliente> clientesSeleccionados() {
        ArrayList<Cliente> selecionados = new ArrayList<>();
        for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {
                clienteSeleccionado = obtenerClienteDeTabla(i);
                if(clienteSeleccionado != null){
                    selecionados.add(clienteSeleccionado);
                }
        }
        return selecionados;
    }
    
    public void borrarSeleccionados(){
        for(int i = 0; i < tablaUsuarios.getRowCount();i++){
            if((boolean)tablaUsuarios.getValueAt(i, 6)){
                modelo.removeRow(i);
            }
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

        backgroundPanelTablaUsuarios = new javax.swing.JPanel();
        btnBusqueda = new javax.swing.JButton();
        btnEditarSeleccionados = new javax.swing.JButton();
        btnBorrarSeleccionados1 = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(800, 560));
        setMinimumSize(new java.awt.Dimension(800, 560));
        setPreferredSize(new java.awt.Dimension(800, 560));

        backgroundPanelTablaUsuarios.setBackground(new java.awt.Color(204, 255, 204));
        backgroundPanelTablaUsuarios.setMaximumSize(new java.awt.Dimension(800, 560));
        backgroundPanelTablaUsuarios.setMinimumSize(new java.awt.Dimension(800, 560));
        backgroundPanelTablaUsuarios.setName(""); // NOI18N
        backgroundPanelTablaUsuarios.setPreferredSize(new java.awt.Dimension(800, 560));

        btnBusqueda.setBackground(new java.awt.Color(57, 136, 158));
        btnBusqueda.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        btnBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        btnBusqueda.setText(" Buscar");
        btnBusqueda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        btnEditarSeleccionados.setBackground(new java.awt.Color(57, 136, 158));
        btnEditarSeleccionados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditarSeleccionados.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarSeleccionados.setText("EDITAR");
        btnEditarSeleccionados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarSeleccionadosMouseClicked(evt);
            }
        });

        btnBorrarSeleccionados1.setBackground(new java.awt.Color(57, 136, 158));
        btnBorrarSeleccionados1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrarSeleccionados1.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarSeleccionados1.setText("BORRAR");
        btnBorrarSeleccionados1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrarSeleccionados1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarSeleccionados1MouseClicked(evt);
            }
        });

        tablaUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        scrollTabla.setViewportView(tablaUsuarios);

        javax.swing.GroupLayout backgroundPanelTablaUsuariosLayout = new javax.swing.GroupLayout(backgroundPanelTablaUsuarios);
        backgroundPanelTablaUsuarios.setLayout(backgroundPanelTablaUsuariosLayout);
        backgroundPanelTablaUsuariosLayout.setHorizontalGroup(
            backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelTablaUsuariosLayout.createSequentialGroup()
                .addGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundPanelTablaUsuariosLayout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundPanelTablaUsuariosLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnBorrarSeleccionados1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        backgroundPanelTablaUsuariosLayout.setVerticalGroup(
            backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelTablaUsuariosLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelTablaUsuariosLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrarSeleccionados1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelTablaUsuariosLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanelTablaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanelTablaUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnEditarSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarSeleccionadosMouseClicked
        // TODO add your handling code here:
        System.out.println(clienteSeleccionado.toString());
        if (clienteSeleccionado != null) {
            JOptionPane.showMessageDialog(null, clienteSeleccionado.getNumeroCuenta());
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione al menos un elemento");
        }
    }//GEN-LAST:event_btnEditarSeleccionadosMouseClicked

    private void btnBorrarSeleccionados1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarSeleccionados1MouseClicked
        // TODO add your handling code here:
        if(verificarSeleccionados(6) >= 1){
            int confimar = JOptionPane.showConfirmDialog(null, 
                    "¿Seguro de Eliminar?\n("+verificarSeleccionados(6)+
                            ") Elementos Seleccionados...");
            if(confimar == 0){
                borrarSeleccionados();
                for(Cliente i : clientesSeleccionados()){
                    gestor.deleteById(i);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione al menos un elemento");
        }
    }//GEN-LAST:event_btnBorrarSeleccionados1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanelTablaUsuarios;
    private javax.swing.JButton btnBorrarSeleccionados1;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnEditarSeleccionados;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables

}
