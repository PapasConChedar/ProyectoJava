package com.org.example.Exceptions;

public class ProductoCargaDatosException extends  Exception{
    int tipoError = 0;

    public ProductoCargaDatosException() {

    }

    public  ProductoCargaDatosException(int error) {
        super("Error al cargar los datos: ");
        tipoError = error;
        escribirMensaje();

    }

    public String escribirMensaje(){
        switch(tipoError) {
            case 1: return ("No se pudo cargar el archivo");
            case 2: return ("No se pudo guardar el archivo");
            case 3: return ("No se pudo agregar el producto");
            case 4: return ("No se pudo actualizar el producto");
            case 5: return ("No se pudo eliminar el producto");
            case 6: return ("No se pudo encontrar el producto");
            case 7: return ("Campos Vacios");
            case 8: return ("Formato Fechas no Permitidos");
            case 9: return ("Ingreso Caracteres en Lugar de Numero");
            case 10: return("Producto solicitado no cumple con los requisitos");
        }
        return ("");
    }
}
