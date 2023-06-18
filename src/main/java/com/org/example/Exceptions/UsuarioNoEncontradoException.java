package com.org.example.Exceptions;

public class UsuarioNoEncontradoException extends Exception{
    int tipoError = 0;

    public UsuarioNoEncontradoException() {

    }

    public  UsuarioNoEncontradoException(int error) {
        super("Login fallido: ");
        tipoError = error;
        escribirMensaje();

    }

    public String escribirMensaje(){
        switch(tipoError) {
            case 1: return ("Email no encontrado");
            case 2: return ("La Contraseña parece ser incorrecta");
        }
        return ("");
    }
}
