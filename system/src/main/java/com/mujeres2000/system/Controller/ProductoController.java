package com.mujeres2000.system.Controller;

import com.mujeres2000.system.Service.ProductoService;
import com.mujeres2000.system.Service.UsuarioService;
import com.mujeres2000.system.model.Usuario;
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
/*
    @PostMapping(path = "/crear")
    //@Operation(summary = "Guarda nuevo producto", description = "Guarda un nuevo producto a la base de datos")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        log.info("Sistema guarda nuevo usuario: " + usuario.getEmail());
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/borrar")
    //@Operation(summary = "Guarda nuevo usuario", description = "Guarda un nuevo usuario a la base de datos")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        log.info("Sistema guarda nuevo usuario: " + usuario.getEmail());
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
*/

}
