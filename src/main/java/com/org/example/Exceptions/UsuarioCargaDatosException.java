package com.org.example.Exceptions;

public class UsuarioCargaDatosException extends Exception{
    int tipoError = 0;

    public UsuarioCargaDatosException() {

    }

    public  UsuarioCargaDatosException(int error) {
        super("Error al cargar los datos:");
        tipoError = error;
        escribirMensaje();

    }

    public String escribirMensaje(){
        switch(tipoError) {
            case 1: return ("No se pudo cargar el archivo");
            case 2: return ("No se pudo guardar el archivo");
            case 3: return ("No se pudo agregar el Usuario");
            case 4: return ("No se pudo actualizar el Usuario");
            case 5: return ("No se pudo eliminar el Usuario");
            case 6: return ("No se pudo encontrar el Usuario");
            case 7: return ("Campos Vacios");
            case 8: return ("Ingreso Caracteres en Lugar de Numero");
        }
        return ("");
    }
}


