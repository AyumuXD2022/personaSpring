package com.anydesk.backend.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

///Estara viendo si encuentra un error
//-Validacion de entrada de datos
//-Objecto no encontrado
//-Entre otra
@RestControllerAdvice
public class HandlerError {


    ///Error de busqueda
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public Map<String,Object> handlerNotFound(ObjectNotFoundException ex){
        Map<String,Object> errorMap = new HashMap();
        errorMap.put("mensaje",ex.getMessage());
        return errorMap;
    }

    //Validaciones
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handlerValidaciones(MethodArgumentNotValidException ex){
        Map<String,Object> errorMap = new HashMap<>();
        List<String> errors = ex.getFieldErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.toList());
        errorMap.put("errors",errors);
        errorMap.put("mensaje","Llenas los campos de manera correcta");
        return errorMap;
    }

    ///Error de operaciones
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataAccessException.class)
    public Map<String,Object> handlerErrorDataBase(DataAccessException ex){
        Map<String,Object> errorMap = new HashMap();
        errorMap.put("error","Error en hacer una operacion");
        return errorMap;
    }

}
