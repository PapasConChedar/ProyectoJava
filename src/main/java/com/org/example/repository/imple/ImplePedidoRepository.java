package com.org.example.repository.imple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.org.example.clases.Cliente;
import com.org.example.clases.Pedido;
import com.org.example.enums.Archivos;
import com.org.example.repository.GenericsRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImplePedidoRepository implements GenericsRepository<Pedido> {
    private final File file = new File(
            Archivos.PRODUCTOS.getRuta());
    private final ObjectMapper objectMapper = new ObjectMapper();
    private List<Pedido> listPedidos;

    @Override
    public void cargar() {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Pedido.class);
            this.listPedidos = objectMapper.readValue(file, collectionType);
        } catch (Exception e) {this.listPedidos = new ArrayList<>();
        }

    }

    @Override
    public void guardar() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(
                    file,
                    this.listPedidos);
        } catch (
                Exception e) {
            throw new RuntimeException();
        }
    }


    @Override
    public Pedido getById(String id) {
        cargar();
        for (Pedido i : listPedidos) {
            if (i.getNumPedido() == (Integer.parseInt(
                    id))) {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Pedido> getAll() {
        cargar();
        return this.listPedidos;
    }

    @Override
    public void add(Pedido item) {
        cargar();
        this.listPedidos.add(
                item);
        guardar();

    }

    @Override
    public void update(Pedido item) {
        cargar();
        for (Pedido i : listPedidos) {
            if (i.getNumPedido() == item.getNumPedido()) {
            }
            i.setPrecio(
                    item.getPrecio());
            i.setProductos(
                    item.getProductos());
            i.setEstado(item.getEstado());

            break;
        }
        guardar();
    }

    @Override
    public void delete(Pedido item) {
        cargar();
        for(Pedido i :listPedidos) {
            if (i.equals(
                    item)) {
                listPedidos.remove(
                        i);
            }

        }guardar();
    }


}