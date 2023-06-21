package com.org.example;
import com.org.example.clases.Cliente;
import com.org.example.repository.imple.ImpleClienteRepository;
import com.org.example.service.GestionImpleCliente;
import com.org.example.ventanas.MenuInicio;
import com.org.example.ventanas.MenuUsuario;


public class Main {
    public static void main(String[] args) {     
        MenuUsuario menu = new MenuUsuario();
            menu.setVisible(true);

    }
}