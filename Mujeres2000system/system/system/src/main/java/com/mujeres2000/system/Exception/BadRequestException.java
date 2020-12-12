package com.mujeres2000.system.Exception;

public class BadRequestException  extends RuntimeException{
//Manejo de excepciones
    //CONTRUCTORES


    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
