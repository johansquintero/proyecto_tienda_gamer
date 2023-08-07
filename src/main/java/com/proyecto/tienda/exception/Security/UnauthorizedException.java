package com.proyecto.tienda.exception.Security;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(){
        super("No tiene los permisos necesarios");
    }
}
