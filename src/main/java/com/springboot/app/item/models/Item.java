package com.springboot.app.item.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.springboot.app.commons.models.entity.Producto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Producto producto;
    private Integer cantidad;

    public Double getTotal() {
        return producto.getPrecio() * cantidad.doubleValue();
    }

}
