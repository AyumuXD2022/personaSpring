package com.anydesk.backend.services;

import com.anydesk.backend.entities.Direccion;
import com.anydesk.backend.exception.ObjectNotFoundException;

import java.util.List;

public interface IDireccionService {
    List<Direccion> findAllDireccion();
    Direccion obtenerDireccion(Long id) throws ObjectNotFoundException;
    Direccion saveDireccion(Direccion direccion);
    void deleteDireccion(Long id) throws ObjectNotFoundException;
}
