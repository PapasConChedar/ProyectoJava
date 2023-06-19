/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.org.example.repository.imple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.org.example.clases.Cliente;
import com.org.example.clases.Productos;
import com.org.example.enums.Archivos;
import com.org.example.repository.GenericsRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agus-Notebook
 */
public class impleProductoRepository implements GenericsRepository<Productos>{
    
    private final File file = new File (Archivos.PRODUCTOS.getRuta());
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Productos> listaProductos;
    

    @Override
    public void cargar() {
        try{
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Productos.class);
            this.listaProductos = objectMapper.readValue(file, collectionType);
        }catch(Exception e){
            this.listaProductos = new ArrayList<>();
        }
 
    }

    @Override
    public void guardar() {
        try{
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listaProductos);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Productos getById(String id) {
        cargar();
        return this.listaProductos.stream().filter(producto -> producto.getIdProducto().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Productos> getAll() {
        cargar();
        return this.listaProductos;
    }

    @Override
    public void add(Productos item) {
        cargar();
        this.listaProductos.add(item);
        guardar();
    }

    @Override
    public void update(Productos item) {
        cargar();
        for(Productos elemProducto:listaProductos){
            if(elemProducto.getIdProducto().equals(item.getIdProducto())){
                elemProducto.setMarca(item.getMarca());
                elemProducto.setNombre(item.getNombre());
                elemProducto.setFechaElavoracion(item.getFechaElavoracion());
                elemProducto.setFechaElavoracion(item.getFechaElavoracion());
                elemProducto.setStock(item.getStock());
                elemProducto.setPrecio(item.getPrecio());
            }
        }
        guardar();
    }

    @Override
    public void delete(Productos item) {

    }
    
}
