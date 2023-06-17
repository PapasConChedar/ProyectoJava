package com.org.example.clases;

public class Empleado extends Persona{
private String idEmpleado;
private String email;
private String contraseña;


// region CONSTRUCTOR VACIO
    public Empleado(String persona, String apellido, String dni, String direccion) {
        super(persona, apellido, dni, direccion);
    }
    // endregion

    //region GETTERS AND SETTERS
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
// endregion

    //region TOSTRING
    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
    //endregion
}
