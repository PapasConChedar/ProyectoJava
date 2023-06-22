package com.org.example;
import com.org.example.clases.Cliente;
import com.org.example.repository.imple.ImpleClienteRepository;
import com.org.example.service.GestionImpleCliente;
import com.org.example.ventanas.Login;
import com.org.example.ventanas.MenuInicio;
import com.org.example.ventanas.MenuUsuario;
import org.example.ventanas.vistas.VistaMiUsuario;


public class Main {
    public static void main(String[] args) {
        Cliente nuevo = new Cliente("Agus",
        "miranda",
        "38439118",
        "ostende123",
        2,
        "45365434536",
        "email@gmaol.com",
        "123123123",
        "1234putoelquelee");
        MenuUsuario login = new MenuUsuario(nuevo);
        login.setVisible(true);
        
     //   MenuInicio menu = new MenuInicio();
      //  menu.setVisible(true);


    }
}