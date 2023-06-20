package com.org.example.service;

import com.org.example.Exceptions.UsuarioNoEncontradoException;
import com.org.example.clases.Cliente;
import com.org.example.repository.imple.ImpleClienteRepository;

import java.util.ArrayList;
import java.util.Optional;

public class GestionImpleCliente {
    ImpleClienteRepository impleClienteRepository = new ImpleClienteRepository();

    public void cargar() {
        impleClienteRepository.cargar();
    }

    public void guardar() {
        impleClienteRepository.guardar();
    }

    public Cliente getById(String id) {
        return impleClienteRepository.getById(
                id);
    }

    public void add(Cliente item) {
        impleClienteRepository.add(
                item);
    }

    public void update(Cliente item) {
        impleClienteRepository.update(
                item);
    }

    public void delete(Cliente item) {
        impleClienteRepository.delete(
                item);
    }

    public void deleteById(Cliente cliente) {
        impleClienteRepository.delete(
                cliente);
    }

    public void getAll() {
        impleClienteRepository.getAll().forEach(
                System.out::println);
    }


    public Boolean verificarDatosLogin(String email, String Password) throws UsuarioNoEncontradoException {
        impleClienteRepository.cargar();
        boolean encontrado = false;
        for (Cliente cliente : impleClienteRepository.getAll()) {
            if (cliente.getEmail().equals(email) && cliente.getContraseña().equals(Password)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }


    public Optional<Cliente> encontrarCliente(String email, String password) {
        impleClienteRepository.cargar();
        for (Cliente cliente : impleClienteRepository.getAll()) {
            if (cliente.getEmail().equals(email) && cliente.getContraseña().equals(password)) {
                return Optional.of(cliente);
            }
        }
        return Optional.empty();
    }


    public boolean verificacionIngresoBases(String...textos){
        ArrayList<String> bases = new ArrayList<>();
        bases.add("   Ingrese Nombre del Usuario");
        bases.add("   Ingrese Apellido del Usuario");
        bases.add("   Ingrese Direccion del Usuario");
        bases.add("   Ingrese Email del Usuario");
        bases.add("   Ingrese Telefono del Usuario");
        bases.add("   Ingrese Contraseña del Usuario");
        bases.add("   Ingrese DNI del Usuario");
        for(String texto: textos){
            for (String base:bases){
                if(textos.equals(base)){
                    return false;
                }
            }
        } return true;
    }
    public boolean verificacionFormatoInteger(String... cadenas){
        for (String cadena : cadenas) {
            if (!cadena.matches("\\d+")) {
                return false;
            }
        }
        return true;
    }
    public boolean verificarIngresosVacios(String... textos){
        for(String i : textos){
            if(i.equals("")){
                return false;
            }
        }
        return true;
    }
    public Integer crearIdUsuario(){
        return (impleClienteRepository.getAll()== null) ? 0 :  impleClienteRepository.getAll().size() ;
    }
}
