package com.org.example.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Persona implements Serializable {
    private Integer idCliente;
    private String numeroCuenta;
    private String email;
    private String contrasenia;
    private String telefono;
    private ArrayList<Pedido> listaDePedidos = new ArrayList<>();


    //region CONSTRUCTOR VACIO


    public Cliente() {
    }

    public Cliente(String nombre, String apellido,String dni, 
            String direccion, int idCliente,String numeroCuenta,String email,String contrasenia
            ,String telefono){
        super(nombre, apellido, dni, direccion);
        setIdCliente(idCliente);
        setNumeroCuenta(numeroCuenta);
        setEmail(email);
        setContrasenia(contrasenia);
        setTelefono(telefono);
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void setListaDePedidos(ArrayList<Pedido> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

   
    
    //endregion

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numeroCuenta);
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.contrasenia);
        hash = 47 * hash + Objects.hashCode(this.telefono);
        return hash;
    }
    
    
}
