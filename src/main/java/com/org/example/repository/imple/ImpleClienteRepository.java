package com.org.example.repository.imple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.org.example.clases.Cliente;
import com.org.example.enums.Archivos;
import com.org.example.repository.GenericsRepository;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImpleClienteRepository implements GenericsRepository<Cliente> {

    private final File file = new File(Archivos.CLIENTES.getRuta());
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Cliente> listClientes;

    @Override
    public void cargar() {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Cliente.class);
            this.listClientes = objectMapper.readValue(file, collectionType);
        } catch (Exception e) {
            this.listClientes = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listClientes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cliente getById(String id) {
        cargar();
        for (Cliente i : listClientes) {
            if (i.getIdCliente().equals(Integer.parseInt(id))) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> getAll() {
        cargar();
        return this.listClientes;

    }

    @Override
    public void add(Cliente item) {
        cargar();
        this.listClientes.add(item);
        guardar();
    }

    @Override
    public void update(Cliente item) {
        cargar();
        for (Cliente i : listClientes) {
            if (i.getIdCliente().equals(item.getIdCliente())) {
                i.setNombre(item.getNombre());
                i.setApellido(item.getApellido());
                i.setDni(item.getDni());
                i.setDireccion(item.getDireccion());
                i.setTelefono(item.getTelefono());
                i.setEmail(item.getEmail());
                i.setContrasenia(item.getContrasenia());
                i.setTelefono(item.getTelefono());
                i.setListaDePedidos(item.getListaDePedidos());
                break;
            }
        }
        guardar();
    }

    @Override
    public void delete(Cliente item) {
        int contador = 0;
        cargar();
        for (Cliente i : listClientes) {
            if(i.equals(item)){
                System.out.println("Entro" + i);
                listClientes.remove(i);
            }else{
                System.out.println("salio"+ i);
            }
        }
        guardar();
    }
}
