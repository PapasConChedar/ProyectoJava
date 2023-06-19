package com.org.example.service;

import com.org.example.clases.Productos;
import com.org.example.repository.imple.ImpleProductoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GestionImpleProducto {
    ImpleProductoRepository impleProductoRepository = new ImpleProductoRepository();

    public void cargar(){
        impleProductoRepository.cargar();
    }

    public void guardar(){
        impleProductoRepository.guardar();
    }

    public void add(Productos item){
        impleProductoRepository.add(item);
    }

    public void uodate(Productos item){
        impleProductoRepository.update(item);
    }

    public void delete(Productos item){
        impleProductoRepository.delete(item);
    }
    /**
     * Cuenta la cantidad de elementos de una lista y devuelve un Integer
     * que le daria al id al producto.
     * @return 
     */
    public Integer crearIdProducto(){
        return impleProductoRepository.getAll().size();
    }
    /**
     * Verifica si alguno de los String ingresados son nulos
     * @param texto String a verificar
     * @return en el caso que no tengan espacion vacion devuelve Verdadero
     */
    public boolean verificarIngresosVacios(String... textos){
        //ArrayList<String> ingresoUsuarios = new ArrayList();
        //ingresoUsuarios.addAll(List.of(texto));
        for(String i : textos){
            if(i.equals("")){
                return false;
            }
        }
        return true;
    }
    /**
     * Verifica si los String ingresados cumplen con el fomato
     * establecido 
     * @param fechas String que son las Fechas
     * @return en el caso que no cumplan devuelve FALSE
     */
    public boolean verificacionFormatoFechas(String... fechas){
        //ArrayList<String> lista = new ArrayList<>();
        //lista.addAll(List.of(fechas));
        String regex = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        for (String fecha : fechas) {
            if (!pattern.matcher(fecha).matches()) {
                return false;
            }
        }
        return true;
    }
    /**
     * Verifica si los String pasados son numeros y no letras
     * @param cadenas
     * @return sino contiene letras devulve TRUE
     */
    public boolean verificacionFormatoInteger(String... cadenas){
        for (String cadena : cadenas) {
            if (!cadena.matches("\\d+")) {
                return false;
            }
        }
        return true;
    }



}
