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
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * @author Agus-Notebook
 */
public class PanelTablaUsuarios extends javax.swing.JPanel {

    private GestionImpleEmpleado gestionImpleEmpleado;
    private GestionImpleCliente gestionImpleCliente;
    private final DefaultTableModel modelo;
    private Cliente clienteSeleccionado = new Cliente();
    private TableRowSorter tablaFiltro = new TableRowSorter();
    private String filtro;

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
        String[] titulos = {"ID", "Tipo", "Nombre", "Direccion", "Email", "Contraseña", "Telefono", "Seleccion"};
        Boolean[] titulosEditables = {false, false, false, false, false, false, false, true};
        Class[] titulosObjetos = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};

        initComponents();
        gestionImpleEmpleado = new GestionImpleEmpleado();
        gestionImpleCliente = new GestionImpleCliente();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return titulosEditables[column];
            }

            public Class getColumnClass(int indice) {
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
        for (Cliente i : gestionImpleCliente.getList()) {
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
        for (Empleado j : gestionImpleEmpleado.getList()) {
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

    public Cliente obtenerClienteDeTabla(int posicion) {
        boolean seleccion = (boolean) tablaUsuarios.getValueAt(posicion, 6);
        if (seleccion) {
            String idCliente = tablaUsuarios.getValueAt(posicion, 0).toString();
            return gestionImpleCliente.getById(idCliente);
        }
        return null;
    }

    public ArrayList<Cliente> clientesSeleccionados() {
        ArrayList<Cliente> selecionados = new ArrayList<>();
        for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {
            clienteSeleccionado = obtenerClienteDeTabla(i);
            if (clienteSeleccionado != null) {
                selecionados.add(clienteSeleccionado);
            }
        }
        return selecionados;
    }

    public void borrarSeleccionados() {
        for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {
            if ((boolean) tablaUsuarios.getValueAt(i, 6)) {
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

        jComboBox1 = new javax.swing.JComboBox<>();
        backgroundPanelTablaUsuarios = new javax.swing.JPanel();
        buscador = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnBorrarSeleccionados = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        selectosTotal = new javax.swing.JCheckBox();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        setMaximumSize(new java.awt.Dimension(800, 510));
        setMinimumSize(new java.awt.Dimension(800, 510));
        setPreferredSize(new java.awt.Dimension(800, 510));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundPanelTablaUsuarios.setBackground(new java.awt.Color(204, 255, 204));
        backgroundPanelTablaUsuarios.setMaximumSize(new java.awt.Dimension(800, 560));
        backgroundPanelTablaUsuarios.setMinimumSize(new java.awt.Dimension(800, 560));
        backgroundPanelTablaUsuarios.setName(""); // NOI18N
        backgroundPanelTablaUsuarios.setPreferredSize(new java.awt.Dimension(800, 560));

        buscador.setText("Ingrese datos buscados");
        buscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorMouseClicked(evt);
            }
        });
        buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorKeyTyped(evt);
            }
        });

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

        btnBorrarSeleccionados.setBackground(new java.awt.Color(57, 136, 158));
        btnBorrarSeleccionados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBorrarSeleccionados.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarSeleccionados.setText("BORRAR");
        btnBorrarSeleccionados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBorrarSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarSeleccionadosMouseClicked(evt);
            }
        });

        tablaUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        scrollTabla.setViewportView(tablaUsuarios);

        selectosTotal.setText("Selecionar Todos");
        selectosTotal.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {
                    if (selectosTotal.isSelected()) {
                        for (int j = 0; j < tablaUsuarios.getRowCount(); j++) {
                            tablaUsuarios.setValueAt(true, j, 7);
                        }
                    } else {
                        for (int j = 0; j < tablaUsuarios.getRowCount(); j++) {
                            tablaUsuarios.setValueAt(false, j, 7);
                        }
                    }
                }
            }
        });

        javax.swing.GroupLayout backgroundPanelTablaUsuariosLayout = new javax.swing.GroupLayout(backgroundPanelTablaUsuarios);
        backgroundPanelTablaUsuarios.setLayout(backgroundPanelTablaUsuariosLayout);
        backgroundPanelTablaUsuariosLayout.setHorizontalGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelTablaUsuariosLayout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(backgroundPanelTablaUsuariosLayout.createSequentialGroup().addGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(btnBorrarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(16, 16, 16)).addGroup(backgroundPanelTablaUsuariosLayout.createSequentialGroup().addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE).addComponent(selectosTotal).addGap(33, 33, 33)))));
        backgroundPanelTablaUsuariosLayout.setVerticalGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(backgroundPanelTablaUsuariosLayout.createSequentialGroup().addGap(49, 49, 49).addGroup(backgroundPanelTablaUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(selectosTotal)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(btnBorrarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(33, 33, 33)));

        add(backgroundPanelTablaUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 791, 537));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarSeleccionadosMouseClicked
        // TODO add your handling code here:
        for (int i = 0; i < tablaUsuarios.getRowCount(); i++) {
            if ((boolean) tablaUsuarios.getValueAt(i, 7)) {
                if (tablaUsuarios.getValueAt(i, 1).equals("Cliente")) {
                    gestionImpleCliente.deleteById((int) tablaUsuarios.getValueAt(i, 0));
                } else {
                    gestionImpleEmpleado.deleteById((int) tablaUsuarios.getValueAt(i, 0));
                }
            }
        }

    }//GEN-LAST:event_btnBorrarSeleccionadosMouseClicked

    private void buscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorKeyTyped
        // TODO add your handling code here:
        tablaFiltro = new TableRowSorter(tablaUsuarios.getModel());
        tablaUsuarios.setRowSorter(tablaFiltro);
    }//GEN-LAST:event_buscadorKeyTyped

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
        buscador.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = buscador.getText();
                buscador.setText(cadena);
                repaint();
                filtro();
            }

        });
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void buscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorMouseClicked
        // TODO add your handling code here:
        buscador.setText("");
    }//GEN-LAST:event_buscadorMouseClicked

    public void filtro() {
        filtro = buscador.getText();
        tablaFiltro.setRowFilter(RowFilter.regexFilter(buscador.getText(), 2));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanelTablaUsuarios;
    private javax.swing.JButton btnBorrarSeleccionados;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JTextField buscador;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JCheckBox selectosTotal;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables

}
