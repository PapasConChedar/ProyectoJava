package com.org.example.service;

import com.org.example.clases.Productos;
import com.org.example.enums.Categoria;
import com.org.example.repository.imple.ImpleProductoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GestionImpleProducto {
    ImpleProductoRepository impleProductoRepository = new ImpleProductoRepository();


    public ImpleProductoRepository getImpleProductoRepository() {
        return impleProductoRepository;
    }

    public void setImpleProductoRepository(ImpleProductoRepository impleProductoRepository) {
        this.impleProductoRepository = impleProductoRepository;
    }
public Productos getById(String id){
        return impleProductoRepository.getById(id);


}
    public void cargar(){
        impleProductoRepository.cargar();
    }

    public void guardar(){
        impleProductoRepository.guardar();
    }

    public void add(Productos item){
        impleProductoRepository.add(item);
    }

    public void update(Productos item){
        impleProductoRepository.update(item);
    }

    public void delete(Productos item){
        impleProductoRepository.delete(item);
    }
    
    public List<Productos> getList(){
        return impleProductoRepository.getAll();
    }
    
    /**
     * Cuenta la cantidad de elementos de una lista y devuelve un Integer
     * que le daria al id al producto.
     * @return 
     */
    public Integer crearIdProducto(){
        return (impleProductoRepository.getAll()== null) ? 0 :  impleProductoRepository.getAll().size() ;
    }
    /**
     * Verifica si alguno de los String ingresados son nulos
     * @param  textos String que son los textos ingresados
     * @return en el caso que no tengan espacion vacion devuelve Verdadero
     */
    public boolean verificarIngresosVacios(String... textos){
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

    /**
     * Verifica si los String pasados coinciden o no
     * con los String de las bases
     * @param textos
     * @return si no coinciden devuelve TRUE
     */
    public boolean verificacionIngresosBases(String... textos){
        ArrayList<String> bases = new ArrayList<>();
        bases.add("   Ingrese Marca del Producto");
        bases.add("   Ingrese Nombre del Producto");
        bases.add("   Ingrese Fecha de Elaboracion xx/xx/xxxx");
        bases.add("   Ingrese Fecha de Vencimiento xx/xx/xxxx");
        bases.add("   Ingrese Stock Producto");
        bases.add("   Ingrese Precio Producto");
        for (String texto : textos) {
            for (String base : bases) {
                if (texto.equals(base)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public Productos selecionarCategoriaProductos(Productos item,int index){
        switch (index) {
            case 1:
                item.setCategoriaProducto(Categoria.LIMPIEZA);
                break;
            case 2:
                item.setCategoriaProducto(Categoria.COMIDA);
                break;
            case 3:
                item.setCategoriaProducto(Categoria.JUGUETERIA);
                break;
            case 4:
                item.setCategoriaProducto(Categoria.BEBIDAS);
                break;
            case 5:
                item.setCategoriaProducto(Categoria.CONGELADOS);
                break;
            case 6:
                item.setCategoriaProducto(Categoria.LACTEOS);
                break;
            case 7:
                item.setCategoriaProducto(Categoria.VARIOS);
                break;
            default:
                throw new AssertionError();
        }
        return item;
    }
    
    public Productos restarProductos(Productos solicitado, Productos archivo){
        Productos auxiliar = archivo;
        auxiliar.setStock(archivo.getStock()-solicitado.getStock());
        return auxiliar;
    }
    
    public void restarProductosLista(List<Productos> solicitados){
        cargar();
        for(Productos item : solicitados){
            for(Productos elemArchivo : impleProductoRepository.getAll()){
                if(elemArchivo.getNombre().equals(item.getNombre())){
                    impleProductoRepository.update(restarProductos(item, elemArchivo));
                    guardar();
                }
            }
        }
    }
    
    
    
    
    
    
}
