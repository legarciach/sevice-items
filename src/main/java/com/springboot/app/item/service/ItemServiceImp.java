package com.springboot.app.item.service;

import com.springboot.app.item.clientes.ProductoClienteRest;
import com.springboot.app.item.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImp  implements ItemService{

    @Autowired
    ProductoClienteRest clienteFeign;

    @Override
    public List<Item> listAll() {
        return clienteFeign.findAll().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clienteFeign.findById(id), cantidad);
    }
}
