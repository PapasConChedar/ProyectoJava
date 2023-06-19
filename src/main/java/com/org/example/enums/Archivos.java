package com.org.example.enums;

public enum Archivos {
    CLIENTES("src\\main\\java\\com\\org\\example\\archivos\\clientes.json"),
    EMPLEADOS("src\\main\\java\\com\\org\\example\\archivos\\empleados.json"),
    PRODUCTOS("src\\main\\java\\com\\org\\example\\archivos\\productos.json");
    private final String ruta;

    Archivos(String ruta) {
        this.ruta = ruta;
    }

    public String getRuta() {
        return ruta;
    }
}