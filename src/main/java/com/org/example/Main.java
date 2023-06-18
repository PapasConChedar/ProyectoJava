package com.org.example;


import com.org.example.Exceptions.UsuarioNoEncontradoException;
import com.org.example.clases.Cliente;
import com.org.example.service.GestionImpleCliente;
import com.org.example.ventanas.Login;
import com.org.example.ventanas.MenuInicio;

public class Main {
    public static void main(String[] args) {
        Login menu = new Login();
       menu.setVisible(
               true);
       // GestionImpleCliente gestionImpleCliente = new GestionImpleCliente();
       // try {
          //  gestionImpleCliente.VerificarDatosLogin(
          //          "cliente2@example.com",
           //         "secreto456");
      //  } catch (
          //      UsuarioNoEncontradoException e) {
          //  System.out.println(
         //           e.getMessage() + e.escribirMensaje());
      //  }

        //gestionImpleCliente.cargar();
        //gestionImpleCliente.getAll();


    }
}