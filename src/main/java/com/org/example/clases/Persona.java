package com.org.example.clases;

public class Persona {

    private String persona;
    private String apellido;
    private String dni;
    private String direccion;

//region CONSTRUCTOR VACIO
    public Persona(String persona, String apellido, String dni, String direccion) {
        this.persona = persona;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }
// endregion

    //region GETTERS AND SETTERS
    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
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
                "persona='" + persona + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
    //endregion
}
