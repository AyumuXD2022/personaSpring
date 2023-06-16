package com.anydesk.backend.services;

import com.anydesk.backend.entities.Persona;
import com.anydesk.backend.exception.ObjectNotFoundException;
import com.anydesk.backend.respositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{

    //private final PersonaRepository personaRepository;

    //public PersonaServiceImpl(PersonaRepository personaRepository) {
    //    this.personaRepository = personaRepository;
    //}
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional(readOnly = true) ///No habra un delete, insert o update
    public List<Persona> obtenerPersonas(){
        //return personaRepository.findAll();
        return this.personaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona buscarPersonaPorId(Long id) throws ObjectNotFoundException {
        return this.buscadorPersona(id);
    }

    @Override
    @Transactional
    public Persona guardarPersona(Persona persona){
        return this.personaRepository.save(persona);
    }

    ///Actualizar porque habra errores

    @Override
    @Transactional
    public void eliminarPersona(Long id) throws ObjectNotFoundException {
        this.personaRepository.delete(this.buscadorPersona(id));
    }

    private Persona buscadorPersona(Long id) throws ObjectNotFoundException {
        Persona persona = this.personaRepository.findById(id).orElse(null);
        if(persona != null){
            return persona;
        }else {
            throw new ObjectNotFoundException("Persona con ID: " + id + " no se encuentra en la bases de datos");
        }
    }
}
