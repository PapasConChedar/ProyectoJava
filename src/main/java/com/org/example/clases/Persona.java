package com.org.example.clases;

import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;

//region CONSTRUCTOR VACIO
    public Persona(String nombre, String apellido, String dni, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }

    public Persona() {
    }
    // endregion

    //region GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
// endregion

    //region TOSTRING
    @Override
    public String toString() {
        return "Persona{" +
                "persona='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
    //endregion
}
