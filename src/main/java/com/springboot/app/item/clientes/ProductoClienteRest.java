package com.springboot.app.item.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.springboot.app.commons.models.entity.Producto;

import java.util.List;

@FeignClient(name = "service-productos")
public interface ProductoClienteRest {

    @GetMapping("listar")
    public List<Producto> findAll();

    @GetMapping("/ver/{id}")
    public Producto findById(@PathVariable Long id);

    @PostMapping("/crear")
    public Producto save(Producto producto);

    @PutMapping("/editar/{id}")
    public Producto edit(@RequestBody Producto producto, @PathVariable Long id);

    @DeleteMapping("/eliminar/{id}")
    public void deleteById(@PathVariable Long id);

}
