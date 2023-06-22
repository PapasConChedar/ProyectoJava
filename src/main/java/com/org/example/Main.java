package com.org.example;
import com.org.example.clases.Cliente;
import com.org.example.repository.imple.ImpleClienteRepository;
import com.org.example.service.GestionImpleCliente;
import com.org.example.ventanas.MenuInicio;
import com.org.example.ventanas.MenuUsuario;
import org.example.ventanas.vistas.VistaMiUsuario;


public class Main {
    public static void main(String[] args) {     
        
        Cliente user = new Cliente();
        user.setNombre("Agustin");
        user.setApellido("Miranda");
        user.setDireccion("Avurtarda 528");
        user.setEmail("emailimaginario@gmail.com");
        user.setDni("354453663");
        user.setTelefono("2254596229");
        user.setContrasenia("putoquelee");
        MenuUsuario menu = new MenuUsuario(user);
            menu.setVisible(true);

    }
}