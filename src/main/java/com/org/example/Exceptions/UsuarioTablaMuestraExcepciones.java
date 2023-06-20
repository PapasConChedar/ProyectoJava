/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.org.example.Exceptions;

/**
 *
 * @author Agus-Notebook
 */
public class UsuarioTablaMuestraExcepciones extends Exception{
    int tipoError=0;

    /**
     * Creates a new instance of <code>UsuarioTablaMuestraExcepciones</code>
     * without detail message.
     */
    public UsuarioTablaMuestraExcepciones(int error) {
        super("Error en la Tabla: ");
        this.tipoError = error;
        
    }
    public String escribirMensaje(){
        switch (tipoError) {
            case 1: return ("Error en la carga");
            case 2: return ("No Selecciono Ningun Elemento");
            case 3 : return ("El Cliente apunta a null");
        }
        return("");
    }

}
