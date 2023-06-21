package com.org.example.clases;

import com.org.example.enums.EstadoPedido;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido extends Productos implements Serializable {
    private int numPedido;
    private int precio;
    private EstadoPedido Estado;
    private ArrayList<Productos> productos;

//region CONSTRUCTOR VACIO
    public Pedido(int idProducto, String marca, String nombre, String fecheaDeVencimiento, String fechaElavoracion, int stock, int precio, int numPedido, int precio1, ArrayList<Productos> productos) {
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

    public EstadoPedido getEstado() {
        return Estado;
    }

    public void setEstado(EstadoPedido estado) {
        Estado = estado;
    }
//endregion
    
}
