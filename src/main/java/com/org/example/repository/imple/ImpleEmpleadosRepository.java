package com.org.example.repository.imple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.org.example.clases.Empleado;
import com.org.example.enums.Archivos;
import com.org.example.repository.GenericsRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImpleEmpleadosRepository implements GenericsRepository<Empleado> {

    private final File file = new File(Archivos.EMPLEADOS.getRuta());
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Empleado> listEmpleados;

    @Override
    public void cargar() {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Empleado.class);
            this.listEmpleados = objectMapper.readValue(file, collectionType);
        } catch (Exception e) {
            this.listEmpleados = new ArrayList<>();
        }
    }

    @Override
    public void guardar() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, this.listEmpleados);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Empleado getById(String id) {
        cargar();
        return this.listEmpleados
                .stream()
                .filter(empleado -> empleado.getIdEmpleado().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Empleado> getAll() {
        cargar();
        return this.listEmpleados;
    }

    @Override
    public void add(Empleado item) {
        cargar();
        this.listEmpleados.add(item);
        guardar();
    }

    @Override
    public void update(Empleado item) {
        for (Empleado i : listEmpleados) {
            if (i.getDni().equals(item.getDni())) {
                i.setNombre(item.getNombre());
                i.setApellido(item.getApellido());
                i.setDni(item.getDni());
                i.setDireccion(item.getDireccion());
                i.setEmail(item.getEmail());
                i.setContraseña(item.getContraseña());
                guardar();
            }
        }
    }

    @Override
    public void delete(Empleado item) {
        this.listEmpleados.removeIf(i -> i.getDni().equals(item.getDni()));
        guardar();
    }


    public void deleteById(int id) {
        this.listEmpleados.removeIf(i -> i.getIdEmpleado().equals(id));
        guardar();
    }
}
