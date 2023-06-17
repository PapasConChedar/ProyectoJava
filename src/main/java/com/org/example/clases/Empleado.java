package com.org.example.clases;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {
    private static int contador;
    private String idEmpleado;
    private String email;
    private String contraseña;


    public Empleado(String persona, String apellido, String dni, String direccion) {
        super(persona, apellido, dni, direccion);
        this.idEmpleado = String.valueOf(++Empleado.contador);
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}
