package com.mujeres2000.system.Controller;

import com.mujeres2000.system.Exception.UnauthorizedException;
import com.mujeres2000.system.Service.ProductoService;
import com.mujeres2000.system.model.Producto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    Log log = LogFactory.getLog(UsuarioController.class);

    @PostMapping(path = "/crear")
    //@Operation(summary = "Guarda un nuevo producto", description = "Guarda un nuevo producto a la base de datos")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto, HttpServletRequest request) {
//        Integer usuarioId = (Integer) request.getSession().getAttribute("USUARIO_ID");
        Integer usuarioId = 1;
        if (usuarioId == null) {
            throw new UnauthorizedException("Sesion no detectada, favor inicie sesion");
        }
        log.info("Llamada a crear producto con usuario id:" + usuarioId);
        productoService.crearProducto(producto, usuarioId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/{producto_id}")
    //@Operation(summary = "busca un producto ya guardado", description = "busca un producto ya guardado")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer producto_id, HttpServletRequest request) {
//        Integer usuarioId = (Integer) request.getSession().getAttribute("USUARIO_ID");
        Integer usuarioId = 1;
        if (usuarioId == null) {
            throw new UnauthorizedException("Sesion no detectada, favor inicie sesion");
        }
        log.info("Llamada a obtener producto con id: " + producto_id + " usuario id: " + usuarioId);
        Producto productoEncontrado = productoService.buscarProducto(producto_id, usuarioId);
        return new ResponseEntity<>(productoEncontrado, HttpStatus.OK);
    }

    @GetMapping
    //@Operation(summary = "busca un producto ya guardado", description = "busca un producto ya guardado")
    public ResponseEntity<List<Producto>> listarProductos(HttpServletRequest request) {
//        Integer usuarioId = (Integer) request.getSession().getAttribute("USUARIO_ID");
        Integer usuarioId = 1;
        if (usuarioId == null) {
            throw new UnauthorizedException("Sesion no detectada, favor inicie sesion");
        }
        log.info("Llamada a obtener listado de productos usuario id: " + usuarioId);
        List<Producto> productos = productoService.listarProductos(usuarioId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{producto_id}")
    //@Operation(summary = "Elimina un producto ya guardado", description = "Elimina un producto ya guardado")
    public ResponseEntity<?> eliminarProducto(@PathVariable("producto_id") Integer producto_id, HttpServletRequest request) {
//        Integer usuarioId = (Integer) request.getSession().getAttribute("USUARIO_ID");
        Integer usuarioId = 1;
        if (usuarioId == null) {
            throw new UnauthorizedException("Sesion no detectada, favor inicie sesion");
        }
        log.info("Llamada a eliminar producto con usuario id:" + usuarioId);
        productoService.eliminarProducto(producto_id, usuarioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
