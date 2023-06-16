package com.anydesk.backend.exception;

//Resportador de error de los objectos que no se encuentran
//Polimofirmos
public class ObjectNotFoundException extends Exception{
    public ObjectNotFoundException(String mensaje){
        super(mensaje);
    }
}
