package com.org.example.repository;


import com.org.example.clases.Cliente;
import com.org.example.interfaces.GenericsRepository;

import java.util.List;

public interface ClienteRepository extends GenericsRepository<Cliente> {
    Cliente getById(String dni);
    List<Cliente> getAll();
    void add(Cliente cliente);
    void update(Cliente cliente);
    void delete(Cliente cliente);

}
