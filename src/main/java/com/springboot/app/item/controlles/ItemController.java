package com.springboot.app.item.controlles;

import com.springboot.app.item.models.Item;
import com.springboot.app.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/listar")
    public List<Item> listar(){
        return service.listAll();
    }

    @GetMapping("/ver/id/{id}/cantidad/{cantidad}")
    public Item detalle (@PathVariable Long id, @PathVariable Integer cantidad){
        return service.findById(id, cantidad);
    }
}
