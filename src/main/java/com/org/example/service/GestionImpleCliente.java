package com.org.example.service;

import com.org.example.clases.Cliente;
import com.org.example.repository.imple.ImpleClienteRepository;

public class GestionImpleCliente {
    ImpleClienteRepository impleClienteRepository = new ImpleClienteRepository();

    public void cargar(){
        impleClienteRepository.cargar();
    }

    public void guardar(){
        impleClienteRepository.guardar();
    }

    public Cliente getById(String id){
        return impleClienteRepository.getById(id);
    }

    public void add(Cliente item){
        impleClienteRepository.add(item);
    }

    public void update(Cliente item){
        impleClienteRepository.update(item);
    }

    public void delete(Cliente item){
        impleClienteRepository.delete(item);
    }

    public void deleteById(Cliente cliente){
        impleClienteRepository.delete(cliente);
    }

    public void getAll(){
        impleClienteRepository.getAll();
    }

}
