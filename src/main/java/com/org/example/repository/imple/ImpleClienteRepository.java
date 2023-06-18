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
        return this.listClientes.stream().filter(cliente -> cliente.getIdCliente().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> getAll() {
        return this.listClientes;

    }

    @Override
    public void add(Cliente item) {
        this.listClientes.add(item);
        guardar();
    }

    @Override
    public void update(Cliente item) {
        for (Cliente i : listClientes) {
            if (i.getIdCliente().equals(item.getIdCliente())) {
                i.setNombre(item.getNombre());
                i.setApellido(item.getApellido());
                i.setDni(item.getDni());
                i.setDireccion(item.getDireccion());
                i.setTelefono(item.getTelefono());
                i.setEmail(item.getEmail());
                i.setContraseña(item.getContraseña());
                i.setTelefono(item.getTelefono());
                i.setListaDePedidos(item.getListaDePedidos());
                break;
            }
        }
        guardar();
    }

    @Override
    public void delete(Cliente item) {
        this.listClientes.removeIf(cliente -> Objects.equals(cliente.getDni(), item.getDni()));
        guardar();
    }
}
