/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.ventanas.vistas;

import com.org.example.clases.Cliente;
import com.org.example.clases.Pedido;
import com.org.example.clases.Productos;
import com.org.example.enums.EstadoPedido;
import com.org.example.service.GestionImpleCliente;
import com.org.example.service.GestionImplePedido;
import com.org.example.service.Utils;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Agus-Notebook
 */
public class VistaComprasUsuarios extends javax.swing.JPanel {

    private GestionImpleCliente gestorCliente;
    private GestionImplePedido gestor;
    private DefaultTableModel modeloTablaPedido;
    private DefaultTableModel modeloTablaProductos;
    private TableRowSorter tablaFlitro;
    private String filtro;
    private Cliente cliente;


    private class renderizadorTabla extends
            DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object item, boolean isSelected, boolean hasFocus, int row, int column) {
            if (item instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) item;
                return checkBox;
            }
            return super.getTableCellRendererComponent(
                    table,
                    item,
                    isSelected,
                    hasFocus,
                    row,
                    column);
        }
    }

    /**
     * Creates new form VistaCompras
     */
    public VistaComprasUsuarios(Cliente user) {
        cliente = user;
        gestor = new GestionImplePedido();
        gestorCliente = new GestionImpleCliente();
        String[] titulosPedidos = {"N° Pedido", "Total", "Cant Productos","Estado", "Selecionado"};
        Boolean[] tiposPedidos = {false, false, false,false, true};
        Class[] objetosPedidos = {String.class, String.class, String.class, String.class, Boolean.class};

        String[] titulosProductos = {"Nombre", "Cant Productos", "Precio Unitario"};
        Boolean[] titulosProductosClass = {false, false, false};
        Class[] titulosObjeto = {String.class, String.class, String.class};

        modeloTablaPedido = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return tiposPedidos[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            public Class getColumnClass(int indice) {
                return objetosPedidos[indice];
            }
        };

        modeloTablaProductos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return titulosProductosClass[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            public Class getColumnClass(int indice) {
                return titulosObjeto[indice];
            }
        };

        modeloTablaPedido.setColumnIdentifiers(titulosPedidos);
        modeloTablaProductos.setColumnIdentifiers(titulosProductos);

        initComponents();
        cargarTablaPedido();
        tablaPedidos.setModel(modeloTablaPedido);
        tablaProductoDePedidos.setModel(modeloTablaProductos);

        tablaPedidos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && tablaPedidos.getSelectedRow() != -1) {
                    int filaSeleccionada = tablaPedidos.getSelectedRow();
                    modeloTablaProductos.setRowCount(0);
                    cargarTablaProductos(cliente.getListaDePedidos().get(filaSeleccionada).getProductos());
                    precioTotalPedido.setText("$ "+String.valueOf(tablaPedidos.getValueAt(filaSeleccionada, 1)));
                }
            }
        });

        selecionTotal.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tablaProductoDePedidos.getRowCount(); i++) {
                    if (selecionTotal.isSelected()) {
                        for (int j = 0; j < tablaProductoDePedidos.getRowCount(); j++) {
                            tablaProductoDePedidos.setValueAt(true, j, 3);
                        }
                    } else {
                        for (int j = 0; j < tablaProductoDePedidos.getRowCount(); j++) {
                            tablaProductoDePedidos.setValueAt(false, j, 3);
                        }
                    }
                }
            }
        });
        
        selecionTotal.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tablaPedidos.getRowCount(); i++) {
                    if (selecionTotal.isSelected()) {
                        for (int j = 0; j < tablaPedidos.getRowCount(); j++) {
                            tablaPedidos.setValueAt(true, j, 4);
                        }
                    } else {
                        for (int j = 0; j < tablaPedidos.getRowCount(); j++) {
                            tablaPedidos.setValueAt(false, j, 4);
                        }
                    }
                }
            }
        });
    }

    public void cargarTablaPedido() {
        if (cliente.getListaDePedidos() != null) {
            for (Pedido item : cliente.getListaDePedidos()) {
                Object[] infoDatos = new Object[5];
                infoDatos[0] = item.getNumPedido();
                infoDatos[1] = item.getPrecio();
                infoDatos[2] = item.getProductos().size();
                infoDatos[3] = item.getEstado();
                infoDatos[4] = false;
                modeloTablaPedido.addRow(infoDatos);

            }
        }
    }

    public void cargarTablaProductos(ArrayList<Productos> lista) {
        for (Productos item : lista) {
            Object[] infoDatos = new Object[3];
            infoDatos[0] = item.getNombre();
            infoDatos[1] = item.getStock();
            infoDatos[2] = item.getPrecio();
            modeloTablaProductos.addRow(infoDatos);
        }
    }

    public void filtro() {
        filtro = buscadorElementos.getText();
        tablaFlitro.setRowFilter(RowFilter.regexFilter(buscadorElementos.getText(), 0));
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundVistaCompras = new javax.swing.JPanel();
        btnBuscador = new javax.swing.JButton();
        buscadorElementos = new javax.swing.JTextField();
        btnBorrarSeleccionados = new javax.swing.JButton();
        textoPrecioTotal = new javax.swing.JLabel();
        btnConfirmarPedido = new javax.swing.JButton();
        selecionTotal = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductoDePedidos = new javax.swing.JTable();
        icono = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        precioTotalPedido = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(800, 510));
        setMinimumSize(new java.awt.Dimension(800, 510));
        setName(""); // NOI18N

        backgroundVistaCompras.setBackground(new java.awt.Color(134, 150, 254));
        backgroundVistaCompras.setMaximumSize(new java.awt.Dimension(800, 560));
        backgroundVistaCompras.setMinimumSize(new java.awt.Dimension(800, 560));
        backgroundVistaCompras.setName(""); // NOI18N
        backgroundVistaCompras.setPreferredSize(new java.awt.Dimension(800, 560));

        btnBuscador.setBackground(new java.awt.Color(204, 255, 204));
        btnBuscador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        btnBuscador.setText("Buscar:");
        btnBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscadorActionPerformed(evt);
            }
        });

        buscadorElementos.setText("Ingrese N°Pedido");
        buscadorElementos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscadorElementosMouseClicked(evt);
            }
        });
        buscadorElementos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscadorElementosKeyTyped(evt);
            }
        });

        btnBorrarSeleccionados.setBackground(new java.awt.Color(189, 205, 214));
        btnBorrarSeleccionados.setText("BORRAR");
        btnBorrarSeleccionados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarSeleccionadosMouseClicked(evt);
            }
        });

        textoPrecioTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        textoPrecioTotal.setText("TOTAL:");

        btnConfirmarPedido.setBackground(new java.awt.Color(189, 205, 214));
        btnConfirmarPedido.setText("PAGAR");
        btnConfirmarPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarPedidoMouseClicked(evt);
            }
        });

        selecionTotal.setBackground(new java.awt.Color(134, 150, 254));
        selecionTotal.setText("Seleccionar Todos");

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaPedidos);

        tablaProductoDePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaProductoDePedidos);

        icono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        icono.setForeground(new java.awt.Color(0, 0, 0));
        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comprasMini.png"))); // NOI18N
        icono.setText("  MIS COMPRAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(precioTotalPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(precioTotalPedido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundVistaComprasLayout = new javax.swing.GroupLayout(backgroundVistaCompras);
        backgroundVistaCompras.setLayout(backgroundVistaComprasLayout);
        backgroundVistaComprasLayout.setHorizontalGroup(
            backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundVistaComprasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                        .addComponent(icono)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundVistaComprasLayout.createSequentialGroup()
                        .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                                .addComponent(btnBorrarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 46, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundVistaComprasLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(textoPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConfirmarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundVistaComprasLayout.createSequentialGroup()
                            .addComponent(btnBuscador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buscadorElementos, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selecionTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21))
        );
        backgroundVistaComprasLayout.setVerticalGroup(
            backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buscadorElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addComponent(selecionTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundVistaComprasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icono)
                        .addGap(30, 30, 30)))
                .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoPrecioTotal))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundVistaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundVistaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscadorElementosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorElementosKeyTyped
        // TODO add your handling code here:
        tablaFlitro = new TableRowSorter(tablaPedidos.getModel());
        tablaPedidos.setRowSorter(tablaFlitro);

    }//GEN-LAST:event_buscadorElementosKeyTyped

    private void buscadorElementosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorElementosMouseClicked
        // TODO add your handling code here:
        buscadorElementos.setText("");
    }//GEN-LAST:event_buscadorElementosMouseClicked

    private void btnBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscadorActionPerformed
        // TODO add your handling code here:

        buscadorElementos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = buscadorElementos.getText();
                repaint();
                filtro();
            }

        });
    }//GEN-LAST:event_btnBuscadorActionPerformed

    private void btnBorrarSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarSeleccionadosMouseClicked
        // TODO add your handling code here:

        for (int i = 0; i < tablaPedidos.getRowCount(); i++) {
            if ((boolean) tablaPedidos.getValueAt(i, 3)) {
                gestor.borrarPedido(Integer.parseInt(String.valueOf(tablaPedidos.getValueAt(i, 0)).toString()), cliente);

                Utils.borrarFilaDeTabla(tablaPedidos, i);

            }
        }
    }//GEN-LAST:event_btnBorrarSeleccionadosMouseClicked

    private void btnConfirmarPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarPedidoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnConfirmarPedidoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundVistaCompras;
    private javax.swing.JButton btnBorrarSeleccionados;
    private javax.swing.JButton btnBuscador;
    private javax.swing.JButton btnConfirmarPedido;
    private javax.swing.JTextField buscadorElementos;
    private javax.swing.JLabel icono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel precioTotalPedido;
    private javax.swing.JCheckBox selecionTotal;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTable tablaProductoDePedidos;
    private javax.swing.JLabel textoPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
