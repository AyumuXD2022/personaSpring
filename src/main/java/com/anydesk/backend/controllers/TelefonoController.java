package com.anydesk.backend.controllers;

import com.anydesk.backend.entities.Telefono;
import com.anydesk.backend.exception.ObjectNotFoundException;
import com.anydesk.backend.services.ITelefonoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TelefonoController {

    @Autowired
    private ITelefonoService telefonoService;

    @GetMapping("/telefonos")
    public ResponseEntity<?> findAllTelefono(){
        return ResponseEntity.ok(this.telefonoService.findAllTelefonos());
    }

    @GetMapping("/telefono/{id}")
    public ResponseEntity<?>findTelefono(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok(this.telefonoService.findTelefono(id));
    }

    @PostMapping("/telefono")
    public ResponseEntity<?>saveTelefono(@RequestBody @Valid  Telefono telefono){
        Map<String, Object> response = new HashMap<>();
        Telefono telefonoNew = this.telefonoService.saveTelefono(telefono);

        response.put("mensaje","Se ha aguardo");
        response.put("direccion",telefonoNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/telefono/{id}")
    public ResponseEntity<?>editTelefono(@RequestBody @Valid Telefono telefono,@PathVariable Long id) throws ObjectNotFoundException {
        Map<String, Object> response = new HashMap<>();
        Telefono telefonoActual = this.telefonoService.findTelefono(id);

        telefonoActual.setIdTelefono(telefono.getIdTelefono());

        Telefono telefonoUpdate = this.telefonoService.saveTelefono(telefonoActual);
        response.put("mensaje","Se ha actualizado");
        response.put("direccion",telefonoUpdate);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/telefono/{id}")
    public ResponseEntity<?>deleteTelefono(@PathVariable Long id) throws ObjectNotFoundException {
        Map<String, Object> response = new HashMap<>();

        this.telefonoService.eliminarTelefono(id);

        response.put("mensaje","Se ha eliminado");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
