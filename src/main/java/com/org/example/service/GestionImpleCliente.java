package com.org.example.service;

import com.org.example.Exceptions.UsuarioNoEncontradoException;
import com.org.example.clases.Cliente;
import com.org.example.repository.imple.ImpleClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class GestionImpleCliente {

    ImpleClienteRepository impleClienteRepository = new ImpleClienteRepository();

    public void cargar() {
        impleClienteRepository.cargar();
    }

    public void guardar() {
        impleClienteRepository.guardar();
    }

    public Cliente getById(String id) {
        return impleClienteRepository.getById(id);
    }

    public void add(Cliente item) {
        impleClienteRepository.add(item);
    }

    public void update(Cliente item) {
        impleClienteRepository.update(item);
    }

    public void delete(Cliente item) {
        impleClienteRepository.delete(item);
    }

    public void deleteById(Cliente cliente) {
        impleClienteRepository.delete(getById(String.valueOf(cliente.getIdCliente())));
    }

    public void deleteById(Integer id) {
        impleClienteRepository.delete(id);
    }

    public List<Cliente> getList() {
        return impleClienteRepository.getAll();
    }

    public Boolean verificarDatosLogin(String email, String Password) throws UsuarioNoEncontradoException {
        impleClienteRepository.cargar();
        boolean encontrado = false;
        for (Cliente cliente : impleClienteRepository.getAll()) {
            if (cliente.getEmail().equals(email) && cliente.getContrasenia().equals(Password)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public Cliente encontrarCliente(String email, String password) {
        impleClienteRepository.cargar();
        for (Cliente cliente : impleClienteRepository.getAll()) {
            if (cliente.getEmail().equals(email) && cliente.getContrasenia().equals(password)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean verificacionIngresoBases(String... textos) {
        boolean estado = true;
        ArrayList<String> bases = new ArrayList<>();
        bases.add("  Ingrese Nombre Cliente");
        bases.add("  Ingrese Apellido Cliente");
        bases.add("  Ingrese Direccion Cliente");
        bases.add("  Ingrese Email Cliente");
        bases.add("  Ingrese Telefono Cliente");
        bases.add("  Ingrese Dni Cliente");
        bases.add("  Ingrese Contraseña Cliente");
        int i = 0;
        for (String texto : textos) {
            if (texto.equals(bases.get(i))) {
                estado = false;
            }
        }
        return estado;
    }

    public boolean verificacionFormatoIngresos(String... cadenas) {
        for (String cadena : cadenas) {
            if (8 > cadena.length()) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarIngresosVacios(String... textos) {
        for (String i : textos) {
            if (i.equals("")) {
                return false;
            }
        }
        return true;
    }

    public Integer crearIdUsuario() {
        return (getList() == null) ? 0 : getList().size() - 1;
    }

    public Integer crearNumeroCuentaUsuarios(Cliente item) {
        return (item.hashCode() < 0) ? item.hashCode() * -1 : item.hashCode();
    }

    public boolean verificarUsuarioRepetido(Cliente item) {
        for (Cliente i : impleClienteRepository.getAll()) {
            if (i.getDni().equals(item.getDni())) {
                return false;
            }
        }
        return true;
    }


}
