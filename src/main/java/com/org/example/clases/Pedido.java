package com.org.example.clases;

import com.org.example.enums.EstadoPedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Pedido implements Serializable {
    private int numPedido;
    private Double precio;
    private EstadoPedido Estado;
    private ArrayList<Productos> productos;

//region CONSTRUCTOR VACIO
    public Pedido(){
        
    }
    public Pedido(int numPedido, Double precio, ArrayList<Productos> productos) {
        setNumPedido(numPedido);
        setPrecio(precio);
        setProductos(productos);
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public EstadoPedido getEstado() {
        return Estado;
    }

    public void setEstado(EstadoPedido Estado) {
        this.Estado = Estado;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numPedido=" + numPedido + ", precio=" + precio + ", Estado=" + Estado + ", productos=" + productos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.numPedido;
        hash = 53 * hash + Objects.hashCode(this.precio);
        hash = 53 * hash + Objects.hashCode(this.Estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.numPedido != other.numPedido) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        return this.Estado == other.Estado;
    }
    
    

    
}
