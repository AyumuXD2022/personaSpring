package com.anydesk.backend.services;

import com.anydesk.backend.entities.Telefono;
import com.anydesk.backend.exception.ObjectNotFoundException;
import com.anydesk.backend.respositories.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelefonoService implements ITelefonoService{
    @Autowired
    private TelefonoRepository telefonoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Telefono>findAllTelefonos(){
        return this.telefonoRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Telefono findTelefono(Long id) throws ObjectNotFoundException {
        return this.buscadorTelefono(id);
    }
    @Override
    @Transactional
    public Telefono saveTelefono(Telefono telefono){
        return this.telefonoRepository.save(telefono);
    }
    @Override
    @Transactional
    public void eliminarTelefono(Long id) throws ObjectNotFoundException {
        this.telefonoRepository.delete(this.buscadorTelefono(id));
    }





    private Telefono buscadorTelefono(Long id) throws ObjectNotFoundException {
        Telefono telefono = this.telefonoRepository.findById(id).orElse(null);
        if (telefono != null){
            return telefono;
        }else {
            throw new ObjectNotFoundException("Telefono con ID: " + id + " no se encuentra en la bases de datos");
        }
    }
}
