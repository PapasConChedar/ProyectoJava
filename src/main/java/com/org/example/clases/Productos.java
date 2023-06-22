package com.org.example.clases;

import com.org.example.enums.Categoria;
import java.io.Serializable;
import java.util.Objects;

public class Productos implements Serializable {
    private int idProducto;
    private String marca;
    private String nombre;
    private String fecheaDeVencimiento;
    private String fechaElavoracion;
    private int stock;
    private int precio;
    private Categoria categoriaProducto;



    //region CONSTRUCTOR VACIO
    public Productos(){
        
    }
    
    public Productos(int id,String marca, String nombre, String fecheaDeVencimiento, String fechaElavoracion, int stock, int precio,Categoria categoriaProducCategoria) {
        this.idProducto = id;
        this.marca = marca;
        this.nombre = nombre;
        this.fecheaDeVencimiento = fecheaDeVencimiento;
        this.fechaElavoracion = fechaElavoracion;
        this.stock = stock;
        this.precio = precio;
        this.categoriaProducto= categoriaProducCategoria;
    }
//endregion

    // region GETTERS AND SETTERS
    public Integer getIdProducto(){
        return idProducto;
    }
    public void setIdProducto(int idProducto){
        this.idProducto = idProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecheaDeVencimiento() {
        return fecheaDeVencimiento;
    }

    public void setFecheaDeVencimiento(String fecheaDeVencimiento) {
        this.fecheaDeVencimiento = fecheaDeVencimiento;
    }

    public String getFechaElavoracion() {
        return fechaElavoracion;
    }

    public void setFechaElavoracion(String fechaElavoracion) {
        this.fechaElavoracion = fechaElavoracion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public Categoria getCategoriaProducto(){
        return this.categoriaProducto;
    }
    
    public void setCategoriaProducto(Categoria categoria){
        this.categoriaProducto = categoria;
    }
    
    
    //endregion

    //region TOSTRING
    @Override
    public String toString() {
        return "Productos{" +
                "marca='" + marca + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fecheaDeVencimiento='" + fecheaDeVencimiento + '\'' +
                ", fechaElavoracion='" + fechaElavoracion + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
    //endregion

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
        final Productos other = (Productos) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        return this.nombre == other.nombre;
    }
    
    
}
