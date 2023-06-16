package com.anydesk.backend.services;

import com.anydesk.backend.entities.Persona;
import com.anydesk.backend.exception.ObjectNotFoundException;

import java.util.List;

public interface IPersonaService {
    List<Persona> obtenerPersonas();

    Persona buscarPersonaPorId(Long id) throws ObjectNotFoundException;

    Persona guardarPersona(Persona persona);

    void eliminarPersona(Long id) throws ObjectNotFoundException;
}
