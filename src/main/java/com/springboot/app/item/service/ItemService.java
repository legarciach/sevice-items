package com.springboot.app.item.service;

import com.springboot.app.item.models.Item;
import com.springboot.app.commons.models.entity.Producto;

import java.util.List;

public interface ItemService {

    public List<Item> listAll();
    public Item findById(Long id, Integer cantidad);
    public Producto save(Producto producto);
    public Producto edit(Producto producto, Long id);
    public void deleteById(Long id);

}
