package com.mujeres2000.system.Configuration;

import com.mujeres2000.system.Exception.BadRequestException;
import com.mujeres2000.system.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
//Controller Advice maneja las excepciones colocadas en el codigo, para llamarmas
//se agrega (annotation  = "la ubicacion desde donde se van a comenzar hacer los
//llamados, en este caso seria desde el restcontroller
public class ExceptionConfig {

    //para poder manejar las excepciones creadas, se hace un llamado a través de la anotación
    //de Exception Handler
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception  e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
