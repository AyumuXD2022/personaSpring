package com.anydesk.backend.controllers;

import com.anydesk.backend.entities.Direccion;
import com.anydesk.backend.exception.ObjectNotFoundException;
import com.anydesk.backend.services.IDireccionService;
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
public class DireccionController {

    @Autowired
    private IDireccionService direccionService;

    @GetMapping("/direcciones")
    public ResponseEntity<List<Direccion>> findAll(){
        return ResponseEntity.ok(this.direccionService.findAllDireccion());
    }

    @GetMapping("/direccion/{id}")
    public ResponseEntity<Direccion> findDireccion(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok(this.direccionService.obtenerDireccion(id));
    }

    @PostMapping("/direccion")
    public ResponseEntity<?> saveDireccion(@RequestBody @Valid Direccion direccion){
        Map<String, Object> response = new HashMap<>();

        Direccion direccionNew = this.direccionService.saveDireccion(direccion);
        response.put("mensaje","Se ha aguardo");
        response.put("direccion",direccionNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/direccion/{id}")
    public ResponseEntity<?> saveDireccion(@RequestBody @Valid Direccion direccion, @PathVariable Long id) throws ObjectNotFoundException {
        Map<String,Object> response = new HashMap<>();
        Direccion direccionActual = this.direccionService.obtenerDireccion(id);

        direccionActual.setCalle(direccion.getCalle());
        direccionActual.setMunicipio(direccion.getMunicipio());

        Direccion direccionUpdate = this.direccionService.saveDireccion(direccionActual);

        response.put("mensaje","Se ha actualizado");
        response.put("persona",direccionUpdate);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/direccion/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ObjectNotFoundException {
        Map<String,Object> response = new HashMap<>();

        this.direccionService.deleteDireccion(id);

        response.put("mensaje","Se ha eliminado");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}
