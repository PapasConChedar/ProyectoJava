package com.org.example.clases;

import java.io.Serializable;

public class Productos implements Serializable {
    private int idProducto;
    private String marca;
    private String nombre;
    private String fecheaDeVencimiento;
    private String fechaElavoracion;
    private int stock;
    private int precio;
    enum Categoria {LIMPIEZA, COMIDA, JUGUETERIA}


    //region CONSTRUCTOR VACIO
    public Productos(){
        
    }
    
    public Productos(int id,String marca, String nombre, String fecheaDeVencimiento, String fechaElavoracion, int stock, int precio) {
        this.idProducto = id;
        this.marca = marca;
        this.nombre = nombre;
        this.fecheaDeVencimiento = fecheaDeVencimiento;
        this.fechaElavoracion = fechaElavoracion;
        this.stock = stock;
        this.precio = precio;
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
}
