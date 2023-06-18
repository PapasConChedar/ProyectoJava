package com.org.example.clases;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    private Integer idCliente;
    private String numeroCuenta;
    private String direccionEnte;
    private String email;
    private String contraseña;
    private String telefono;
    private String listaDePedidos;


    //region CONSTRUCTOR VACIO


    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String dni, String direccion, Integer idCliente, String numeroCuenta, String direccionEnte, String email, String contraseña, String telefono, String listaDePedidos) {
        super(nombre,
                apellido,
                dni,
                direccion);
        this.idCliente = idCliente;
        this.numeroCuenta = numeroCuenta;
        this.direccionEnte = direccionEnte;
        this.email = email;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.listaDePedidos = listaDePedidos;
    }


    //endregion

    //region GETTERS AND SETTERS

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

    public String getDireccionEnte() {
        return direccionEnte;
    }

    public void setDireccionEnte(String direccionEnte) {
        this.direccionEnte = direccionEnte;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getListaDePedidos() {
        return listaDePedidos;
    }

    public void setListaDePedidos(String listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

    //endregion

    //region TOSTRING
    @Override
    public String toString() {
        return "Cliente{" + "idCliente='" + idCliente + '\'' + ", numeroCuenta='" + numeroCuenta + '\'' + ", direccionEnte='" + direccionEnte + '\'' + ", email='" + email + '\'' + ", contraseña='" + contraseña + '\'' + ", telefono='" + telefono + '\'' + ", listaDePedidos='" + listaDePedidos + '\'' + '}';
    }

    //endregion
}
