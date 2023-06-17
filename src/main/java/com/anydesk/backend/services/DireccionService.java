package com.anydesk.backend.services;

import com.anydesk.backend.entities.Direccion;
import com.anydesk.backend.exception.ObjectNotFoundException;
import com.anydesk.backend.respositories.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DireccionService implements IDireccionService{

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Direccion> findAllDireccion(){
        return this.direccionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Direccion obtenerDireccion(Long id) throws ObjectNotFoundException {
        return this.buscadorDireccion(id);
    }

    @Override
    @Transactional
    public Direccion saveDireccion(Direccion direccion) {
        return this.direccionRepository.save(direccion);
    }

    @Override
    @Transactional
    public void deleteDireccion(Long id) throws ObjectNotFoundException {
        this.direccionRepository.delete(this.buscadorDireccion(id));
    }

    private Direccion buscadorDireccion (Long id) throws ObjectNotFoundException {
        Direccion direccion = this.direccionRepository.findById(id).orElse(null);
        if(direccion != null){
            return direccion;
        }else {
            throw new ObjectNotFoundException("Direccion con ID: " + id + " no se encuentra en la bases de datos");
        }
    }
}
