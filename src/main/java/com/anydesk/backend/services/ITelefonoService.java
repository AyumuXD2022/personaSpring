package com.anydesk.backend.services;

import com.anydesk.backend.entities.Telefono;
import com.anydesk.backend.exception.ObjectNotFoundException;

import java.util.List;

public interface ITelefonoService {
    List<Telefono> findAllTelefonos();

    Telefono findTelefono(Long id) throws ObjectNotFoundException;

    Telefono saveTelefono(Telefono telefono);

    void eliminarTelefono(Long id) throws ObjectNotFoundException;
}
