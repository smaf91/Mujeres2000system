package com.mujeres2000.system.Controller;

import com.mujeres2000.system.Exception.UnauthorizedException;
import com.mujeres2000.system.Service.CostoService;
import com.mujeres2000.system.model.Costo;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/costo")
public class CostoController {
    @Autowired
    CostoService costoService;

    Log log = LogFactory.getLog(UsuarioController.class);

    @PostMapping(path = "/registrar")
    @Operation(summary = "Guarda nuevo costo", description = "Guarda un nuevo costo a la base de datos")
    public ResponseEntity<String> crearCosto(@RequestBody Costo costo, HttpServletRequest request) {
        log.info("Llamada a /registrar con costo: ");
//        Integer usuarioId = (Integer) request.getSession().getAttribute("USUARIO_ID");
        Integer usuarioId = 1;
        if (usuarioId == null) {
            throw new UnauthorizedException("Sesion no detectada, favor inicie sesion");
        }
        costoService.crearCosto(costo, usuarioId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar costos", description = "Listar costos")
    public ResponseEntity<List<Costo>> listarCostos(HttpServletRequest request) {
        log.info("Llamada a listar costos: ");
//        Integer usuarioId = (Integer) request.getSession().getAttribute("USUARIO_ID");
        Integer usuarioId = 1;
        if (usuarioId == null) {
            throw new UnauthorizedException("Sesion no detectada, favor inicie sesion");
        }
        List<Costo> costos = costoService.listarCostos(usuarioId);
        return new ResponseEntity<>(costos, HttpStatus.OK);
    }
}
