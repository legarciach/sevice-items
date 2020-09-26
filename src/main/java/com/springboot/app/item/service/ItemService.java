package com.springboot.app.item.service;

import com.springboot.app.item.models.Item;

import java.util.List;

public interface ItemService {

    public List<Item> listAll();

    public Item findById(Long id, Integer cantidad);

}
