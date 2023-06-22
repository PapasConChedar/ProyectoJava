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

        Login login = new Login();
        login.setVisible(true);

    }
}