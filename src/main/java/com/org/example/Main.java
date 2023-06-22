package com.org.example;
import com.org.example.clases.Cliente;
import com.org.example.repository.imple.ImpleClienteRepository;
import com.org.example.service.GestionImpleCliente;
import com.org.example.ventanas.Login;
import com.org.example.ventanas.MenuInicio;
import com.org.example.ventanas.MenuUsuario;
import java.util.ArrayList;
import org.example.ventanas.vistas.VistaMiUsuario;


public class Main {
    public static void main(String[] args) {
        GestionImpleCliente gestor = new GestionImpleCliente();
        Cliente nuevo = gestor.getList().get(0);
        MenuUsuario login = new MenuUsuario(nuevo);
        login.setVisible(true);
        
     //   MenuInicio menu = new MenuInicio();
      //  menu.setVisible(true);


    }
}