package com.springboot.app.item.controlles;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.Producto;
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
    public List<Item> listar() {
        return service.listAll();
    }

    @HystrixCommand(fallbackMethod = "alternativoVer")
    @GetMapping("/ver/id/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return service.findById(id, cantidad);
    }

    public Item alternativoVer(Long id, Integer cantidad){
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre("Nuevo producto");
        producto.setPrecio(999.5);
        return new Item(producto, cantidad);
    }

}
