package com.org.example;


import com.org.example.Exceptions.UsuarioNoEncontradoException;
import com.org.example.clases.Cliente;
import com.org.example.service.GestionImpleCliente;
import com.org.example.ventanas.Login;
import com.org.example.ventanas.MenuInicio;
import org.example.ventanas.vistas.panelesTabbledVistas.PanelEdicionProducto;

public class Main {
    public static void main(String[] args) {
        MenuInicio menu = new MenuInicio();
       menu.setVisible(
               true);


    }
}