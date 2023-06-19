package com.org.example.service;

import com.org.example.clases.Productos;
import com.org.example.repository.imple.ImpleProductoRepository;

public class GestionImpleProducto {
    ImpleProductoRepository impleProductoRepository = new ImpleProductoRepository();

    public void cargar(){
        impleProductoRepository.cargar();
    }

    public void guardar(){
        impleProductoRepository.guardar();
    }

    public void add(Productos item){
        impleProductoRepository.add(item);
    }

    public void uodate(Productos item){
        impleProductoRepository.update(item);
    }

    public void delete(Productos item){
        impleProductoRepository.delete(item);
    }





}
