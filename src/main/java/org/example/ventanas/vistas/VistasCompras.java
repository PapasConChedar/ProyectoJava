/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.ventanas.vistas;



import com.org.example.clases.Cliente;
import com.org.example.clases.Pedido;
import com.org.example.clases.Productos;
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
public class VistasCompras extends javax.swing.JPanel {
    private GestionImpleCliente gestorCliente = new GestionImpleCliente();
    private GestionImplePedido gestorPedidos = new GestionImplePedido();
    private DefaultTableModel modeloTablaPedido;
    private DefaultTableModel modeloTablaProductos;
    private TableRowSorter tablaFlitro;
    private String filtro;
    private Cliente cliente;
    private Pedido pedido1;


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
    public VistasCompras() {
        gestorPedidos.cargar();
        gestorCliente.cargar();
        String[] titulosPedidos = {"Id Clienta","N° Pedido", "Total", "Cant Productos","Estado", "Selecionado"};
        Boolean[] tiposPedidos = {false,false, false, false,false, true};
        Class[] objetosPedidos = {String.class,String.class, String.class, String.class, String.class, Boolean.class};

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


        tablaPedidos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && tablaPedidos.getSelectedRow() != -1) {
                    int filaSeleccionada = tablaPedidos.getSelectedRow();
                    modeloTablaProductos.setRowCount(0);

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
        for (Cliente cliente: gestorCliente.getList()){
        if (cliente.getListaDePedidos() != null) {
            for (Pedido item : cliente.getListaDePedidos()) {
                Object[] infoDatos = new Object[6];
                infoDatos[0] = cliente.getIdCliente();
                infoDatos[1] = item.getNumPedido();
                infoDatos[2] = item.getPrecio();
                infoDatos[3] = item.getProductos().size();
                infoDatos[4] = item.getEstado();
                infoDatos[5] = false;
                modeloTablaPedido.addRow(infoDatos);

             }
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
     * Creates new form VistasCompras
     */
   // public VistasCompras() {
   //     initComponents();
   // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        backgroundVistaCompras = new javax.swing.JPanel();
        btnBuscador = new javax.swing.JButton();
        buscadorElementos = new javax.swing.JTextField();
        btnBorrarSeleccionados = new javax.swing.JButton();
        btnConfirmarPedido = new javax.swing.JButton();
        selecionTotal = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        icono = new javax.swing.JLabel();

        setBackground(new java.awt.Color(162, 210, 255));
        setMaximumSize(new java.awt.Dimension(800, 560));
        setMinimumSize(new java.awt.Dimension(800, 560));

        backgroundVistaCompras.setBackground(new java.awt.Color(134, 150, 254));
        backgroundVistaCompras.setMaximumSize(new java.awt.Dimension(800, 560));
        backgroundVistaCompras.setMinimumSize(new java.awt.Dimension(800, 560));
        backgroundVistaCompras.setName(""); // NOI18N

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

        icono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comprasMini.png"))); // NOI18N
        icono.setText("Compras Usuarios");

        javax.swing.GroupLayout backgroundVistaComprasLayout = new javax.swing.GroupLayout(backgroundVistaCompras);
        backgroundVistaCompras.setLayout(backgroundVistaComprasLayout);
        backgroundVistaComprasLayout.setHorizontalGroup(
            backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundVistaComprasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icono)
                    .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(selecionTotal)
                        .addComponent(btnBorrarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                        .addGap(0, 182, Short.MAX_VALUE)
                        .addComponent(btnBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscadorElementos, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        backgroundVistaComprasLayout.setVerticalGroup(
            backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icono)
                .addGap(58, 58, 58)
                .addComponent(btnConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrarSeleccionados, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(selecionTotal)
                .addGap(288, 288, 288))
            .addGroup(backgroundVistaComprasLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(backgroundVistaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscadorElementos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroundVistaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backgroundVistaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscadorActionPerformed
        // TODO add your handling code here:

        buscadorElementos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = buscadorElementos.getText();
                repaint();
                //filtro();
            }

        });
    }//GEN-LAST:event_btnBuscadorActionPerformed

    private void buscadorElementosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscadorElementosMouseClicked
        // TODO add your handling code here:
        buscadorElementos.setText("");
    }//GEN-LAST:event_buscadorElementosMouseClicked

    private void buscadorElementosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorElementosKeyTyped
        // TODO add your handling code here:
        tablaFlitro = new TableRowSorter(tablaPedidos.getModel());
        tablaPedidos.setRowSorter(tablaFlitro);
    }//GEN-LAST:event_buscadorElementosKeyTyped

    private void btnBorrarSeleccionadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarSeleccionadosMouseClicked
        // TODO add your handling code here:

        for (int i = 0; i < tablaPedidos.getRowCount(); i++) {
            if ((boolean) tablaPedidos.getValueAt(i, 3)) {
                gestorPedidos.borrarPedido(Integer.parseInt(String.valueOf(tablaPedidos.getValueAt(i, 0)).toString()), cliente);

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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox selecionTotal;
    private javax.swing.JTable tablaPedidos;
    // End of variables declaration//GEN-END:variables
}
