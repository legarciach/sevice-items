package com.springboot.app.item.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Producto {

    private Long id;
    private String nombre;
    private Double precio;
    private Date createAt;
}
