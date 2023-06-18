package com.org.example;


import com.org.example.Exceptions.UsuarioNoEncontradoException;
import com.org.example.service.GestionImpleCliente;
import com.org.example.ventanas.Login;
import com.org.example.ventanas.MenuInicio;

public class Main {
    public static void main(String[] args) {
        //Login menu = new Login();
       // menu.setVisible(
             //   true);
        GestionImpleCliente gestionImpleCliente = new GestionImpleCliente();
        try {
            gestionImpleCliente.VerificarDatosLogin(
                    "cliente2@example.com",
                    "contraseña2");
        } catch (
                UsuarioNoEncontradoException e) {
            System.out.println(
                    e.getMessage() + e.escribirMensaje());
        }

    }
}