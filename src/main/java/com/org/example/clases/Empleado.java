package com.org.example.clases;

import java.io.Serializable;
import java.util.Objects;

public class Empleado extends Persona implements Serializable {
    private Integer idEmpleado;
    private String email;
    private String contrasenia;


    public Empleado(String persona, String apellido, String dni, String direccion) {
        super(persona, apellido, dni, direccion);
        this.idEmpleado = idEmpleado;
    }

    public Empleado() {
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", email='" + email + '\'' +
                ", contraseña='" + contrasenia + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idEmpleado);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.contrasenia);
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        return Objects.equals(this.idEmpleado, other.idEmpleado);
    }
    
    
}
