/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.org.example.ventanas;

import com.org.example.clases.Cliente;
import com.org.example.enums.Archivos;
import org.example.ventanas.vistas.VistaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import org.example.ventanas.vistas.PanelMisCompras;
import org.example.ventanas.vistas.VistaCompras;
import org.example.ventanas.vistas.VistaProductos;
import org.example.ventanas.vistas.VistaUsuarios;
import org.example.ventanas.vistas.VistaMiUsuario;
/**
 *
 * @author Agus-Notebook
 */
public class MenuUsuario extends javax.swing.JFrame {
    public static Cliente dato = new Cliente();
    int mouseX;
    int mouseY;
    /**
     * Creates new form Menu
     */
    public MenuUsuario(Cliente user) {
        initComponents();
        iniciarVista(1,contenido);
        reproducirMusica();
        dato = user;
    }
    public void reproducirMusica() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Archivos.CANCION.getRuta()));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Funcion que instancia un Jpanel Ventana seleccionado para que aparesca
     * en el Jpanel que lo "contenga" en el Menu Principal
     * @param valor Indica que tipo de ventana 
     */
    private void iniciarVista(int valor, JPanel contPanel){
        switch (valor) {
            case 1:
                componentesVista(new VistaPrincipal(),contPanel);
                break;
            case 2:
                componentesVista(new VistaMiUsuario(dato),contPanel);
                break;
            case 3:
                componentesVista(new PanelMisCompras(),contPanel);
                break;
            case 4:
                componentesVista(new VistaCompras(),contPanel);
                break;
            default:
                throw new AssertionError();
        }
    }
    /**
     * Metodo que recibe una Jpanel y se le settean caracteristicas y restablece
     * el Jpanel que lo esta conteniendo
     * @param vista 
     */
    private void componentesVista(JPanel vista,JPanel contenedor){
        vista.setSize(800, 560);
        vista.setLocation(0,0);
        
        contenedor.removeAll();
        contenedor.add(vista,BorderLayout.CENTER);
        contenedor.revalidate();
        contenedor.repaint(); 
    }
    /**
     * Metodo que permite setter a un Panel que contenga un Texto, un color
     * cuando el mouse entre
     * @param panelSelecionado Panel al que se le va a modificar el color
     * @param texto  Indica que texto va a modificar el color
     */
    private void setColorEventoMouseEntrando(JPanel panelSelecionado, JLabel texto){
        panelSelecionado.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, (new Color(81,204,210))));
        panelSelecionado.setBackground(new Color(81,204,210));
        texto.setForeground(Color.WHITE);
    }
    /**
     * Metodo que permite restaurar a un Panel que contenga un Texto el color
     * que tenia cuando el mouse salga del panel
     * @param panelSelecionado Panel al que se le va a modificar el color
     * @param texto  Indica que texto va a modificar el color
     */
    private void setColorEventoMouseSaliendo(JPanel panelSelecionado, JLabel texto){
        panelSelecionado.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, (new Color(142,233,239))));
        panelSelecionado.setBackground(new Color(142,233,239));
        texto.setForeground(new Color(57,136,158));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        backGroundMenu = new javax.swing.JPanel();
        barraSuperiorMenu = new javax.swing.JPanel();
        botonExitMenu = new javax.swing.JPanel();
        exitTextoMenu = new javax.swing.JLabel();
        panelOpciones = new javax.swing.JPanel();
        tituloMenu = new javax.swing.JLabel();
        iconoMenu = new javax.swing.JLabel();
        separadorMenu1 = new javax.swing.JSeparator();
        opcionMenu5 = new javax.swing.JPanel();
        BtnCerrarSesion = new javax.swing.JLabel();
        opcionMenu4 = new javax.swing.JPanel();
        btnNuevoPedido = new javax.swing.JLabel();
        opcionMenu3 = new javax.swing.JPanel();
        btnMisCompras = new javax.swing.JLabel();
        opcionMenu2 = new javax.swing.JPanel();
        btnEditarCuenta = new javax.swing.JLabel();
        opcionMenu1 = new javax.swing.JPanel();
        btnMiCuenta = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();

        jPanel2.setMaximumSize(new java.awt.Dimension(106, 58));
        jPanel2.setMinimumSize(new java.awt.Dimension(106, 58));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(1066, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backGroundMenu.setBackground(new java.awt.Color(255, 255, 255));
        backGroundMenu.setForeground(new java.awt.Color(57, 136, 158));
        backGroundMenu.setMaximumSize(new java.awt.Dimension(1066, 600));
        backGroundMenu.setMinimumSize(new java.awt.Dimension(1066, 600));
        backGroundMenu.setPreferredSize(new java.awt.Dimension(1066, 600));
        backGroundMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraSuperiorMenu.setMaximumSize(new java.awt.Dimension(1066, 40));
        barraSuperiorMenu.setMinimumSize(new java.awt.Dimension(1066, 40));
        barraSuperiorMenu.setOpaque(false);
        barraSuperiorMenu.setPreferredSize(new java.awt.Dimension(1066, 40));
        barraSuperiorMenu.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraSuperiorMenuMouseDragged(evt);
            }
        });
        barraSuperiorMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraSuperiorMenuMousePressed(evt);
            }
        });

        botonExitMenu.setBackground(new java.awt.Color(232, 246, 255));
        botonExitMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonExitMenu.setMaximumSize(new java.awt.Dimension(69, 40));
        botonExitMenu.setMinimumSize(new java.awt.Dimension(69, 40));
        botonExitMenu.setPreferredSize(new java.awt.Dimension(69, 40));

        exitTextoMenu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        exitTextoMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTextoMenu.setText("X");
        exitTextoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTextoMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTextoMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTextoMenuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout botonExitMenuLayout = new javax.swing.GroupLayout(botonExitMenu);
        botonExitMenu.setLayout(botonExitMenuLayout);
        botonExitMenuLayout.setHorizontalGroup(
            botonExitMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTextoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );
        botonExitMenuLayout.setVerticalGroup(
            botonExitMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTextoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout barraSuperiorMenuLayout = new javax.swing.GroupLayout(barraSuperiorMenu);
        barraSuperiorMenu.setLayout(barraSuperiorMenuLayout);
        barraSuperiorMenuLayout.setHorizontalGroup(
            barraSuperiorMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraSuperiorMenuLayout.createSequentialGroup()
                .addContainerGap(997, Short.MAX_VALUE)
                .addComponent(botonExitMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraSuperiorMenuLayout.setVerticalGroup(
            barraSuperiorMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraSuperiorMenuLayout.createSequentialGroup()
                .addComponent(botonExitMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        backGroundMenu.add(barraSuperiorMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        panelOpciones.setBackground(new java.awt.Color(121, 215, 220));
        panelOpciones.setMaximumSize(new java.awt.Dimension(270, 600));
        panelOpciones.setMinimumSize(new java.awt.Dimension(270, 600));

        tituloMenu.setBackground(new java.awt.Color(57, 136, 158));
        tituloMenu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tituloMenu.setForeground(new java.awt.Color(255, 255, 255));
        tituloMenu.setText("BIENVENIDO");

        separadorMenu1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        opcionMenu5.setBackground(new java.awt.Color(142, 233, 239));
        opcionMenu5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(142, 233, 239)));
        opcionMenu5.setMaximumSize(new java.awt.Dimension(126, 56));
        opcionMenu5.setMinimumSize(new java.awt.Dimension(126, 56));
        opcionMenu5.setPreferredSize(new java.awt.Dimension(126, 56));

        BtnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnCerrarSesion.setForeground(new java.awt.Color(57, 136, 158));
        BtnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salida.png"))); // NOI18N
        BtnCerrarSesion.setText(" Cerrar Sesion");
        BtnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCerrarSesionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout opcionMenu5Layout = new javax.swing.GroupLayout(opcionMenu5);
        opcionMenu5.setLayout(opcionMenu5Layout);
        opcionMenu5Layout.setHorizontalGroup(
            opcionMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opcionMenu5Layout.setVerticalGroup(
            opcionMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        opcionMenu4.setBackground(new java.awt.Color(142, 233, 239));
        opcionMenu4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(142, 233, 239)));
        opcionMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcionMenu4.setMaximumSize(new java.awt.Dimension(106, 58));
        opcionMenu4.setMinimumSize(new java.awt.Dimension(106, 58));
        opcionMenu4.setPreferredSize(new java.awt.Dimension(106, 58));

        btnNuevoPedido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNuevoPedido.setForeground(new java.awt.Color(57, 136, 158));
        btnNuevoPedido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cesta-de-la-compra.png"))); // NOI18N
        btnNuevoPedido.setText("Nuevo Pedido");
        btnNuevoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoPedidoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNuevoPedidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevoPedidoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout opcionMenu4Layout = new javax.swing.GroupLayout(opcionMenu4);
        opcionMenu4.setLayout(opcionMenu4Layout);
        opcionMenu4Layout.setHorizontalGroup(
            opcionMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opcionMenu4Layout.setVerticalGroup(
            opcionMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionMenu4Layout.createSequentialGroup()
                .addComponent(btnNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );

        opcionMenu3.setBackground(new java.awt.Color(142, 233, 239));
        opcionMenu3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(142, 233, 239)));
        opcionMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcionMenu3.setMaximumSize(new java.awt.Dimension(106, 58));
        opcionMenu3.setMinimumSize(new java.awt.Dimension(106, 58));
        opcionMenu3.setPreferredSize(new java.awt.Dimension(106, 58));

        btnMisCompras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMisCompras.setForeground(new java.awt.Color(57, 136, 158));
        btnMisCompras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMisCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrito-de-compras.png"))); // NOI18N
        btnMisCompras.setText("Mis Compras");
        btnMisCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMisComprasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMisComprasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMisComprasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout opcionMenu3Layout = new javax.swing.GroupLayout(opcionMenu3);
        opcionMenu3.setLayout(opcionMenu3Layout);
        opcionMenu3Layout.setHorizontalGroup(
            opcionMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMisCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opcionMenu3Layout.setVerticalGroup(
            opcionMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opcionMenu3Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(btnMisCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        opcionMenu2.setBackground(new java.awt.Color(142, 233, 239));
        opcionMenu2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(142, 233, 239)));
        opcionMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcionMenu2.setMaximumSize(new java.awt.Dimension(106, 58));
        opcionMenu2.setMinimumSize(new java.awt.Dimension(106, 58));
        opcionMenu2.setPreferredSize(new java.awt.Dimension(106, 58));

        btnEditarCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditarCuenta.setForeground(new java.awt.Color(57, 136, 158));
        btnEditarCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditarCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hombre.png"))); // NOI18N
        btnEditarCuenta.setText("Mi Cuenta");
        btnEditarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarCuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarCuentaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout opcionMenu2Layout = new javax.swing.GroupLayout(opcionMenu2);
        opcionMenu2.setLayout(opcionMenu2Layout);
        opcionMenu2Layout.setHorizontalGroup(
            opcionMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEditarCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opcionMenu2Layout.setVerticalGroup(
            opcionMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEditarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        opcionMenu1.setBackground(new java.awt.Color(142, 233, 239));
        opcionMenu1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 10, 1, 1, new java.awt.Color(142, 233, 239)));
        opcionMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        opcionMenu1.setMaximumSize(new java.awt.Dimension(126, 56));
        opcionMenu1.setMinimumSize(new java.awt.Dimension(126, 56));

        btnMiCuenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMiCuenta.setForeground(new java.awt.Color(57, 136, 158));
        btnMiCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMiCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home.png"))); // NOI18N
        btnMiCuenta.setText("Inicio");
        btnMiCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMiCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMiCuentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMiCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMiCuentaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout opcionMenu1Layout = new javax.swing.GroupLayout(opcionMenu1);
        opcionMenu1.setLayout(opcionMenu1Layout);
        opcionMenu1Layout.setHorizontalGroup(
            opcionMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMiCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opcionMenu1Layout.setVerticalGroup(
            opcionMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnMiCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(opcionMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opcionMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(opcionMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(opcionMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(opcionMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(iconoMenu))
                    .addGroup(panelOpcionesLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tituloMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(separadorMenu1))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpcionesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(tituloMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconoMenu)
                .addGap(10, 10, 10)
                .addComponent(opcionMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcionMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcionMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(opcionMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(opcionMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        backGroundMenu.add(panelOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 600));

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setMaximumSize(new java.awt.Dimension(800, 560));
        contenido.setMinimumSize(new java.awt.Dimension(800, 560));
        contenido.setPreferredSize(new java.awt.Dimension(800, 560));

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        backGroundMenu.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 800, 560));

        getContentPane().add(backGroundMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraSuperiorMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorMenuMousePressed
        // TODO add your handling code here:
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_barraSuperiorMenuMousePressed

    private void barraSuperiorMenuMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorMenuMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-mouseX,y-mouseY);
    }//GEN-LAST:event_barraSuperiorMenuMouseDragged

    private void exitTextoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTextoMenuMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitTextoMenuMouseClicked

    private void exitTextoMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTextoMenuMouseEntered
        // TODO add your handling code here:
        botonExitMenu.setBackground(new Color(237,80,122));
        exitTextoMenu.setForeground(new Color(232,246,255));
        
    }//GEN-LAST:event_exitTextoMenuMouseEntered

    private void exitTextoMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTextoMenuMouseExited
        // TODO add your handling code here:
        botonExitMenu.setBackground(new Color(232,246,255));
        exitTextoMenu.setForeground(Color.BLACK);
    }//GEN-LAST:event_exitTextoMenuMouseExited

 
    private void btnMiCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiCuentaMouseClicked
        // TODO add your handling code here:
        iniciarVista(1,contenido);
    }//GEN-LAST:event_btnMiCuentaMouseClicked

    private void btnEditarCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCuentaMouseClicked
        // TODO add your handling code here:
        iniciarVista(2,contenido);
    }//GEN-LAST:event_btnEditarCuentaMouseClicked

    private void btnMisComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisComprasMouseClicked
        // TODO add your handling code here:
        iniciarVista(3,contenido);
    }//GEN-LAST:event_btnMisComprasMouseClicked

    private void btnNuevoPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoPedidoMouseClicked
        // TODO add your handling code here:
        iniciarVista(4,contenido);
    }//GEN-LAST:event_btnNuevoPedidoMouseClicked

    private void btnMiCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiCuentaMouseEntered
        // TODO add your handling code here:
        setColorEventoMouseEntrando(opcionMenu1,btnMiCuenta);
    }//GEN-LAST:event_btnMiCuentaMouseEntered

    private void btnMiCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiCuentaMouseExited
        // TODO add your handling code here:
        setColorEventoMouseSaliendo(opcionMenu1, btnMiCuenta);
    }//GEN-LAST:event_btnMiCuentaMouseExited

    private void btnEditarCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCuentaMouseEntered
        // TODO add your handling code here:
        setColorEventoMouseEntrando(opcionMenu2,btnEditarCuenta);
    }//GEN-LAST:event_btnEditarCuentaMouseEntered

    private void btnEditarCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarCuentaMouseExited
        // TODO add your handling code here:
        setColorEventoMouseSaliendo(opcionMenu2, btnEditarCuenta);
    }//GEN-LAST:event_btnEditarCuentaMouseExited

    private void btnMisComprasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisComprasMouseEntered
        // TODO add your handling code here:
        setColorEventoMouseEntrando(opcionMenu3,btnMisCompras);
    }//GEN-LAST:event_btnMisComprasMouseEntered

    private void btnMisComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMisComprasMouseExited
        // TODO add your handling code here:
        setColorEventoMouseSaliendo(opcionMenu3, btnMisCompras);
    }//GEN-LAST:event_btnMisComprasMouseExited

    private void btnNuevoPedidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoPedidoMouseEntered
        // TODO add your handling code here:
        setColorEventoMouseEntrando(opcionMenu4,btnNuevoPedido);
    }//GEN-LAST:event_btnNuevoPedidoMouseEntered

    private void btnNuevoPedidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoPedidoMouseExited
        // TODO add your handling code here:
        setColorEventoMouseSaliendo(opcionMenu4, btnNuevoPedido);
    }//GEN-LAST:event_btnNuevoPedidoMouseExited

    private void BtnCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCerrarSesionMouseEntered
        // TODO add your handling code here:
        opcionMenu5.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, (new Color(237,80,122))));
        opcionMenu5.setBackground(new Color(237,80,122));
        BtnCerrarSesion.setForeground(new Color (232,246,255));
    }//GEN-LAST:event_BtnCerrarSesionMouseEntered

    private void BtnCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCerrarSesionMouseExited
        // TODO add your handling code here:
        opcionMenu5.setBorder(BorderFactory.createMatteBorder(1, 10, 1, 1, (new Color(142,233,239))));
        opcionMenu5.setBackground(new Color(142,233,239));
        BtnCerrarSesion.setForeground(new Color(57,136,158));
    }//GEN-LAST:event_BtnCerrarSesionMouseExited

    private void BtnCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCerrarSesionMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_BtnCerrarSesionMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnCerrarSesion;
    private javax.swing.JPanel backGroundMenu;
    private javax.swing.JPanel barraSuperiorMenu;
    private javax.swing.JPanel botonExitMenu;
    private javax.swing.JLabel btnEditarCuenta;
    private javax.swing.JLabel btnMiCuenta;
    private javax.swing.JLabel btnMisCompras;
    private javax.swing.JLabel btnNuevoPedido;
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel exitTextoMenu;
    private javax.swing.JLabel iconoMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel opcionMenu1;
    private javax.swing.JPanel opcionMenu2;
    private javax.swing.JPanel opcionMenu3;
    private javax.swing.JPanel opcionMenu4;
    private javax.swing.JPanel opcionMenu5;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JSeparator separadorMenu1;
    private javax.swing.JLabel tituloMenu;
    // End of variables declaration//GEN-END:variables

}
