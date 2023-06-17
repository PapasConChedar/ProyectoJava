package com.org.example.repository;



import com.org.example.clases.Empleado;

import java.util.List;

public interface EmpleadoRepository extends GenericsRepository<Empleado> {
    @Override
    Empleado getById(String dni);
    @Override
    List<Empleado> getAll();
    @Override
    void add(Empleado empleado);
    @Override
    void update(Empleado empleado);
    @Override
    void delete(Empleado empleado);
}
