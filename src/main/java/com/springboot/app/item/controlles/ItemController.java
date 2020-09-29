package com.springboot.app.item.controlles;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.app.item.models.Item;
import com.springboot.app.item.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.app.commons.models.entity.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class ItemController {

    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private Environment env;

    @Autowired
    private ItemService service;

    @Value("${configuracion.texto}")
    private String config;

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

    @GetMapping("/obtener-configuracion")
    public ResponseEntity<?>obtenerConfiguracion(@Value("${server.port}") String puerto){
        log.info(config);
        Map<String,String> json = new HashMap<String,String>();
        json.put("config", config);
        json.put("puerto", puerto);

        if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")){
            json.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
            json.put("autor.email", env.getProperty("configuracion.autor.email"));
        }

        return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto){
        log.info("Entro a crear");
        return service.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@RequestBody Producto producto,@PathVariable Long id){
        log.info("Entro a editar");
        return service.edit(producto, id);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        log.info("Entro a eliminar");
        service.deleteById(id);
    }

}
