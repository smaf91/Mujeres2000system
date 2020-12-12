package com.mujeres2000.system.Controller;

import com.mujeres2000.system.Service.ProductoService;
import com.mujeres2000.system.model.Producto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    Log log = LogFactory.getLog(UsuarioController.class);

    @PostMapping(path = "/crear")
    //@Operation(summary = "Guarda un nuevo producto", description = "Guarda un nuevo producto a la base de datos")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        log.info("Sistema guarda nuevo producto: " + producto.getProducto_nombre());
        productoService.crearProducto(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{producto_id}")
    //@Operation(summary = "busca un producto ya guardado", description = "busca un producto ya guardado")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer producto_id) {
        log.info("Sistema guarda nuevo producto: " + producto_id);
        Producto productoEncontrado = productoService.buscarProducto(producto_id);
        return new ResponseEntity<>(productoEncontrado, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{producto_id}")
    //@Operation(summary = "Elimina un producto ya guardado", description = "Elimina un producto ya guardado")
    public ResponseEntity<?> eliminarProducto(@PathVariable("producto_id") Integer producto_id) {
        log.info("Sistema guarda nuevo producto: " + producto_id);
        productoService.eliminarProducto(producto_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
