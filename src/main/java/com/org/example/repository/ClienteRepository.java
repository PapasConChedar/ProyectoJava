package com.org.example.repository;


import com.org.example.clases.Cliente;

import java.util.List;

public interface ClienteRepository extends GenericsRepository<Cliente> {
    @Override
    Cliente getById(String dni);
    @Override
    List<Cliente> getAll();
    @Override
    void add(Cliente cliente);
    @Override
    void update(Cliente cliente);
    @Override
    void delete(Cliente cliente);

}
