package com.mujeres2000.system.Exception;

public class NotFoundException extends RuntimeException{
    //Manejo de excepciones
    //CONTRUCTORES

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
