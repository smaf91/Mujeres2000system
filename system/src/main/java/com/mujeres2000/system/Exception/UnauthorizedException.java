package com.mujeres2000.system.Exception;

public class UnauthorizedException extends RuntimeException {
    //Manejo de excepciones
    //CONTRUCTORES

    public UnauthorizedException() {
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
