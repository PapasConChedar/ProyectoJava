package com.org.example.service;

import com.org.example.clases.Pedido;
import com.org.example.repository.imple.ImplePedidoRepository;
import com.org.example.repository.imple.ImpleProductoRepository;

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
}
