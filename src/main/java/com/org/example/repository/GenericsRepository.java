package com.org.example.repository;

import java.util.List;

public interface GenericsRepository<T> {

    void cargar();

    void guardar();

    T getById(String id);

    List<T> getAll();

    void add(T item);

    void update(T item);

    void delete(T item);
}
