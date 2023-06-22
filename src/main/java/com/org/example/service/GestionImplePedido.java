package com.org.example.service;

import com.org.example.clases.Cliente;
import com.org.example.clases.Pedido;
import com.org.example.clases.Productos;
import com.org.example.enums.EstadoPedido;
import com.org.example.repository.imple.ImplePedidoRepository;
import com.org.example.repository.imple.ImpleProductoRepository;

import java.util.ArrayList;

public class GestionImplePedido {
    ImplePedidoRepository implePedidoRepository = new ImplePedidoRepository();
    public void cargar(){
        implePedidoRepository.cargar();
    }


    public void guardar(){
        implePedidoRepository.guardar();
    }
    public void add (Pedido item){
        implePedidoRepository.add(item);
    }
    public void Update(Pedido item){
        implePedidoRepository.update(item);

    }
    public void delete(Pedido item){
        implePedidoRepository.delete(item);
    }


    public Integer crearNumPedido(){
        return((implePedidoRepository.getAll())==null) ? 0:implePedidoRepository.getAll().size();
    }


    public void cambiarEstadoPedido(EstadoPedido estado, Pedido pedido){
        pedido.setEstado(estado);
    }
    public Pedido crearPedido(ArrayList<Productos> listProducto){
        Pedido i = new Pedido();
        i.setNumPedido(crearNumPedido());
        i.setProductos(listProducto);
        i.setPrecio(calcularPrecio(listProducto));
        i.setEstado(EstadoPedido.IMPAGO);
        return i;
    }

    public int calcularPrecio(ArrayList<Productos> listProductos){
        int total= 0;
        for (Productos producto:listProductos) {
            total += producto.getPrecio();
        }
        return total;

    }
    public void pagarPedido(String id){
        implePedidoRepository.getAll();
      implePedidoRepository.getById(id).setEstado(EstadoPedido.PAGO);
    }

}
