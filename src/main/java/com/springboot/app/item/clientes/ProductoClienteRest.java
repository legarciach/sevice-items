package com.springboot.app.item.clientes;

import com.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "service-productos")
public interface ProductoClienteRest {

    @GetMapping("listar")
    public List<Producto> findAll();

    @GetMapping("/ver/{id}")
    public Producto findById(@PathVariable Long id);

}
