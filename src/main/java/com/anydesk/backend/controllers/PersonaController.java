package com.anydesk.backend.controllers;

import com.anydesk.backend.entities.Persona;
import com.anydesk.backend.exception.ObjectNotFoundException;
import com.anydesk.backend.services.IPersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas")  //GET
    public ResponseEntity<List<Persona>> findAllPersonas(){
        return ResponseEntity.ok(this.personaService.obtenerPersonas());
    }

    @GetMapping("/persona/{id}") //Get
    public ResponseEntity<Persona> findPersona(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok(this.personaService.buscarPersonaPorId(id));
    }

    @PostMapping("/persona") //Post singular
    public ResponseEntity<?> savePersona(@RequestBody @Valid Persona persona){
        Map<String, Object> response = new HashMap<>();
        Persona personaNueva = this.personaService.guardarPersona(persona);

        response.put("mensaje","Se ha aguardo");
        response.put("persona",personaNueva);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    //Actualizar ya vamos a manejar errores
    @PutMapping("/persona/{id}")
    public ResponseEntity<?>updatePersona(@RequestBody @Valid Persona persona,@PathVariable Long id) throws ObjectNotFoundException {
        Map<String,Object> response = new HashMap<>();
        Persona personaActual = this.personaService.buscarPersonaPorId(id);

        personaActual.setNombre(persona.getNombre());
        personaActual.setApellido(persona.getApellido());
        personaActual.setEmail(persona.getEmail());
        personaActual.setFechaNacimiento(persona.getFechaNacimiento());

        Persona personaUpdate = this.personaService.guardarPersona(personaActual);

        response.put("mensaje","Se ha actualizado");
        response.put("persona",personaUpdate);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }


    @DeleteMapping("/persona/{id}") ///Delete
    public ResponseEntity<?> deletePersona(@PathVariable Long id) throws ObjectNotFoundException {
        Map<String,Object> response = new HashMap<>();
        this.personaService.eliminarPersona(id);
        response.put("mensaje","Se ha eliminado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}
