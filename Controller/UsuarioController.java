package com.mujeres2000.system.Controller;

import com.mujeres2000.system.Service.UsuarioService;
import com.mujeres2000.system.model.Usuario;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
//import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    Log log = LogFactory.getLog(UsuarioController.class);

    @PostMapping(path = "/registrar")
    //@Operation(summary = "Guarda nuevo usuario", description = "Guarda un nuevo usuario a la base de datos")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        log.info("Sistema guarda nuevo usuario: " + usuario);
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @PutMapping(path = "/modificar")
    //@Operation(summary = "Modifica usuario guardado", description = "Modifica usuario guardado en la base de datos")
    public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usuario) {
        log.info("Sistema actualiza usuario: " + usuario);
        usuarioService.modificarUsuario(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/usuario/{id}")
    //@Operation(summary = "Elimina usuario guardado", description = "Elimina usuario guardado en la base de datos")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("id") Usuario usuario) {
        log.info("Sistema elimina usuario: " + usuario);
        usuarioService.eliminarUsuario(usuario.getUsuario_ID());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path = "/usuario/{id}")
    //@Operation(summary = "Busca usuario guardado", description = "Busca usuario guardado en la base de datos")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") Integer id) {
        log.info("Sistema busca usuario: " + id);
        Optional<Usuario> usuario = usuarioService.obtenerPorId(id);
        if (Optional.empty().equals(usuario)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {
            Usuario usuarioBuscado = usuarioService.obtenerPorId(id).get();
            return new ResponseEntity<Usuario>(usuarioBuscado, HttpStatus.OK);
        }
    }
/* A RESOLVER
    @GetMapping(path = "/lista")
    // @Operation(summary = "Lista de usuarios", description = "Obtiene lista de usuarios registrados")
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> lista = usuarioService.BuscarTodosLosUsuarios(usuario);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }*/
}
