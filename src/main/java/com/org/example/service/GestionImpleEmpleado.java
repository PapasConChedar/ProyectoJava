/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.example.service;

import com.org.example.clases.Cliente;
import com.org.example.clases.Empleado;
import com.org.example.repository.imple.ImpleEmpleadosRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Agus-Notebook
 */
public class GestionImpleEmpleado {
    private ImpleEmpleadosRepository impleEmpleadosRepository = new ImpleEmpleadosRepository();

    public void cargar() {
        impleEmpleadosRepository.cargar();
    }

    public void guardar() {
        impleEmpleadosRepository.guardar();
    }

    public Empleado getByid(String id) {
        return impleEmpleadosRepository.getById(id);
    }

    public void add(Empleado item) {
        impleEmpleadosRepository.add(item);
    }

    public void update(Empleado item) {
        impleEmpleadosRepository.update(item);
    }

    public void delete(Empleado item) {
        impleEmpleadosRepository.delete(getByid(String.valueOf(item.getIdEmpleado())));
    }

    public List<Empleado> getList() {
        return impleEmpleadosRepository.getAll();
    }

    public boolean verificarUsuarioRepetido(Empleado item) {
        for (Empleado i : impleEmpleadosRepository.getAll()) {
            if (i.getDni().equals(item.getDni())) {
                return false;
            }
        }
        return true;
    }

    public void deleteById(int id) {
        impleEmpleadosRepository.deleteById(id);
    }

    public Optional<Empleado> encontrarEmpleado(String email, String contraseña) {
        impleEmpleadosRepository.cargar();
        for (Empleado empleado : impleEmpleadosRepository.getAll()) {
            if (empleado.getEmail().equals(email) && empleado.getContrasenia().equals(contraseña)) {
                return Optional.of(empleado);
            }
        }
        return Optional.empty();
    }
}
