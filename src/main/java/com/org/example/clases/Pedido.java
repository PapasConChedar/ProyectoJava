package com.org.example.clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido extends Productos implements Serializable {
    private int numPedido;
    private int precio;
    enum EstadoPago {PAGO, IMPAGO, PENDIENTE}
    private ArrayList<Productos> productos;

//region CONSTRUCTOR VACIO
    public Pedido(String marca, String nombre, String fecheaDeVencimiento, String fechaElavoracion, int stock, int precio, int numPedido, int precio1, ArrayList<Productos> productos) {
        super(marca, nombre, fecheaDeVencimiento, fechaElavoracion, stock, precio);
        this.numPedido = numPedido;
        this.precio = precio1;
        this.productos = productos;
    }
    //endregion

    //region GETTERS AND SETTERS

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    @Override
    public int getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }

    //endregion
    
}
