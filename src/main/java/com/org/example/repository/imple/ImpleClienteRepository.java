package com.org.example.repository.imple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.example.clases.Cliente;
import com.org.example.enums.Archivos;
import com.org.example.repository.GenericsRepository;

import java.io.File;
import java.util.List;

public class ImpleClienteRepository implements GenericsRepository<Cliente> {

    private final File file = new File(Archivos.CLIENTES.getRuta());
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Cliente> clientes;

    @Override
    public void cargar() {
    }

    @Override
    public void guardar() {
    }

    @Override
    public Cliente getById(String id) {
        return null;

    }

    @Override
    public List<Cliente> getAll() {
        return null;
    }

    @Override
    public void add(Cliente item) {
    }

    @Override
    public void update(Cliente item) {
    }

    @Override
    public void delete(Cliente item) {
    }
}
