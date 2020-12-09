package com.mujeres2000.system.Controller;

import com.mujeres2000.system.Repository.UsuarioRepository;
import com.mujeres2000.system.model.Usuario;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    Log log = LogFactory.getLog(UsuarioController.class);

    @PostMapping(path="/nuevo-usuario")
    //@Operation(summary = "Guarda nuevo usuario", description= "Guarda un nuevo usuario a la base de datos")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        log.info("Sistema guarda nuevo usuario: " + usuario);
        usuarioRepository.save(usuario);
        return new ResponseEntity<>()(usuario, HttpStatus.CREATED);
    }

    @PutMapping(path= "/usuario")
    //@Operation(summary = "Modifica usuario guardado", description= "Modifica usuario guardado en la base de datos")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario){
        log.info("Sistema actualiza usuario: " + usuario);
        usuarioRepository.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

}
