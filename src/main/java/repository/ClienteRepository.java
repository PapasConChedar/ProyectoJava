package repository;

import com.clases.proyectojava.Cliente;
import interfaces.GenericsRepository;

import java.util.List;

public interface ClienteRepository extends GenericsRepository<Cliente> {
    Cliente getById(String dni);
    List<Cliente> getAll();
    void add(Cliente cliente);
    void update(Cliente cliente);
    void delete(Cliente cliente);

}
