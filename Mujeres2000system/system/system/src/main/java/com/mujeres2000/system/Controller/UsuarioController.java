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
        log.info("Sistema guarda nuevo usuario: " + usuario.getEmail());
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(path = "/ingresar")
    //@Operation(summary = "login del usuario", description = "ingreso del usuario ya registrado")
    public ResponseEntity<Usuario> ingresoUsuario(@RequestBody Usuario usuario) {
        log.info("Sistema permite ingreso del usuario: " + usuario.getEmail());
        try {
            usuarioService.ingresoUsuario(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            JSONObject response = new JSONObject();
            response.put("error", ponTuErrorAqui);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

            }
    /*JSONObject response = new JSONObject();
response.put("error", ponTuErrorAqui);
return new ResponseEntity<>(response, statusCode);*/

}
