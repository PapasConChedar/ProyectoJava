/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.example.ventanas.vistas;

import com.org.example.clases.Cliente;
import com.org.example.clases.Pedido;
import com.org.example.clases.Productos;
import com.org.example.enums.Categoria;
import com.org.example.enums.EstadoPedido;
import com.org.example.service.GestionImpleCliente;
import com.org.example.service.GestionImpleProducto;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nicolas
 */
public class PanelMisCompras extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private GestionImpleProducto gestorProductos;
    private GestionImpleCliente gestorCliente;
    private Cliente dato = new Cliente();
    private Productos item = new Productos();
    private TableRowSorter trsfiltro;
    private String filtro;

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
     * Creates new form PanelMisCompras
     */
    public PanelMisCompras(Cliente user) {
        dato = user;
        initComponents();
        String[] titulos = {"Id", "Marca", "Nombre", "Fecha Venciminto",
            "Fecha Elavoracion", "Stock", "Precio", "Categoria", "Cant Seleccionados",
            "Seleccion"};
        Boolean[] editables = {false, false, false, false, false, false, false, false, true, true};
        Class[] tipoObjetos = {String.class, String.class, String.class, String.class,
            String.class, String.class, String.class, String.class, Integer.class, Boolean.class};
        gestorProductos = new GestionImpleProducto();
        gestorCliente = new GestionImpleCliente();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return editables[column];
            }

            public Class getClumnClass(int indice) {
                return tipoObjetos[indice];
            }
        };
        modelo.setColumnIdentifiers(titulos);
        cargarTabla();

        tablaElementos.setModel(modelo);
        addCheckBox(9, tablaElementos);

    }

    public Double calcularPrecio(ArrayList<Productos> listProductos) {
        double total = 0;
        for (Productos producto : listProductos) {
            total += producto.getPrecio() * producto.getStock();
        }
        return total;

    }

    public void addCheckBox(int columna, JTable tabla) {
        TableColumn tc = tabla.getColumnModel().getColumn(columna);
        tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));
    }

    public void cargarTabla() {
        gestorProductos.cargar();
        for (Productos item : gestorProductos.getImpleProductoRepository().getAll()) {
            if (item.getStock() > 0) {
                Object[] infoDatos = new Object[10];
                infoDatos[0] = item.getIdProducto();
                infoDatos[1] = item.getMarca();
                infoDatos[2] = item.getNombre();
                infoDatos[3] = item.getFecheaDeVencimiento();
                infoDatos[4] = item.getFechaElavoracion();
                infoDatos[5] = item.getStock();
                infoDatos[6] = item.getPrecio();
                infoDatos[7] = item.getCategoriaProducto();
                infoDatos[8] = 0;
                infoDatos[9] = false;
                modelo.addRow(infoDatos);
            }
        }
    }

    public int verificarSeleccionados(int posicion) {
        int contador = 0;
        for (int i = 0; i < tablaElementos.getRowCount(); i++) {
            boolean seleccion = (boolean) tablaElementos.getValueAt(
                    i,
                    posicion);
            if (seleccion) {
                contador++;
            }
        }
        return contador;
    }

    public Productos obtenerProductoDeTabla(int posicion) {
        boolean seleccion = (boolean) tablaElementos.getValueAt(posicion, 9);
        if (seleccion) {
            String idProducto = tablaElementos.getValueAt(
                    posicion,
                    0).toString();
            return gestorProductos.getImpleProductoRepository().getById(
                    idProducto);
        }
        return null;
    }

    public ArrayList<Productos> productosSeleccionados() {
        ArrayList<Productos> seleccionados = new ArrayList<>();
        for (int i = 0; i < tablaElementos.getRowCount(); i++) {
            item = obtenerProductoDeTabla(i);
            if (item != null) {
                if (corroborarDescontar((int) tablaElementos.getValueAt(i, 8), item.getStock())) {
                    item.setStock((int) tablaElementos.getValueAt(i, 8));
                    seleccionados.add((item));
                } else {
                    JOptionPane.showMessageDialog(null, "No contamos con el Stock suficiente");
                    break;
                }
            }
        }
        return seleccionados;
    }

    public Pedido crearPedido() {
        Pedido compra = new Pedido();
        compra.setEstado(EstadoPedido.IMPAGO);
        compra.setPrecio(calcularPrecio(productosSeleccionados()));
        compra.setProductos(productosSeleccionados());
        compra.setNumPedido((dato.hashCode() < 0) ? dato.hashCode() * -1 : dato.hashCode());
        JOptionPane.showMessageDialog(null, "Pedido Agregado...");
        return compra;
    }

    public void actualizarTabla() {
        modelo.setRowCount(0);
        cargarTabla();
    }

    public boolean corroborarDescontar(int solicitado, int pedido) {
        if ( pedido < solicitado) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorTitulo = new javax.swing.JPanel();
        tablaProductos = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaElementos = new javax.swing.JTable();
        txtBuscarTablaPruductos = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAñadirPedido = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 215, 140));
        setForeground(new java.awt.Color(240, 215, 140));
        setMaximumSize(new java.awt.Dimension(800, 510));
        setMinimumSize(new java.awt.Dimension(800, 510));
        setPreferredSize(new java.awt.Dimension(800, 510));

        contenedorTitulo.setBackground(new java.awt.Color(121, 134, 199));

        tablaProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaProductos.setText("PRODUCTOS DISPONIBLES");

        javax.swing.GroupLayout contenedorTituloLayout = new javax.swing.GroupLayout(contenedorTitulo);
        contenedorTitulo.setLayout(contenedorTituloLayout);
        contenedorTituloLayout.setHorizontalGroup(
            contenedorTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorTituloLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(tablaProductos)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        contenedorTituloLayout.setVerticalGroup(
            contenedorTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorTituloLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(tablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        contenedor.setBackground(new java.awt.Color(204, 204, 255));

        tablaElementos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaElementos);

        txtBuscarTablaPruductos.setText("Ingrese Categoria");
        txtBuscarTablaPruductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarTablaPruductosMouseClicked(evt);
            }
        });
        txtBuscarTablaPruductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarTablaPruductosKeyTyped(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(22, 135, 167));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarTablaPruductos, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtBuscarTablaPruductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAñadirPedido.setText("AÑADIR PEDIDO");
        btnAñadirPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirPedidoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(contenedorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAñadirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedorTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAñadirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        txtBuscarTablaPruductos.setText("");
        txtBuscarTablaPruductos.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = txtBuscarTablaPruductos.getText();
                txtBuscarTablaPruductos.setText(cadena);
                repaint();
                filtro();
            }
        });
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarTablaPruductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarTablaPruductosKeyTyped
        // TODO add your handling code here:
        trsfiltro = new TableRowSorter(tablaElementos.getModel());
        tablaElementos.setRowSorter(trsfiltro);
    }//GEN-LAST:event_txtBuscarTablaPruductosKeyTyped

    private void btnAñadirPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirPedidoMouseClicked
        // TODO add your handling code here:
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Quiere agregar a su pedido " + verificarSeleccionados(9) + " Productos ?");
        if (confirmar == 0) {
            dato.getListaDePedidos().add(crearPedido());
            gestorCliente.update(dato);
            gestorProductos.restarProductosLista(productosSeleccionados());
            actualizarTabla();
        }
    }//GEN-LAST:event_btnAñadirPedidoMouseClicked

    private void txtBuscarTablaPruductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarTablaPruductosMouseClicked
        // TODO add your handling code here:
        txtBuscarTablaPruductos.setText("");
    }//GEN-LAST:event_txtBuscarTablaPruductosMouseClicked
    public void filtro() {
        filtro = txtBuscarTablaPruductos.getText();
        trsfiltro.setRowFilter(RowFilter.regexFilter(txtBuscarTablaPruductos.getText(), 7));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirPedido;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel contenedorTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaElementos;
    private javax.swing.JLabel tablaProductos;
    private javax.swing.JTextField txtBuscarTablaPruductos;
    // End of variables declaration//GEN-END:variables
}
