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
            case 3: return ("El Email no cumple con los parametros");
            case 4: return ("La Contraseña no cumple con parametros");
            case 5: return ("Ingreso invalido, Cliente Repetido");
            case 6: return ("Alguno de los ingresos no cumple con los Carateres Minimos");
            case 7: return ("Campos Vacios");
            case 8: return ("Ingreso Caracteres en Lugar de Numero");
            case 9: return ("Campos no fueron modificados");
        }
        return ("");
    }
}


