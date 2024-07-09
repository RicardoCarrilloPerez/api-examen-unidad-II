package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.persistence.entities.Item;
import com.example.demo.persistence.entities.Persona;
import com.example.demo.persistence.service.PersonaService;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.getAll();
    }

    @PostMapping
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
        // Validación para asegurar que el campo email no sea nulo
        if (persona.getEmail() == null || persona.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Intenta guardar la persona y devuelve el resultado
        try {
            Persona savedPersona = personaService.save(persona);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPersona);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Persona> update(@PathVariable("id")UUID id,@RequestBody @Validated Persona persona) {
        return ResponseEntity.ok(this.personaService.update(id, persona));
}
    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> delete(@PathVariable("id")UUID id) {
        return this.personaService.deletebyId(id);
}
    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable("id")UUID id) {
        return ResponseEntity.of(this.personaService.findById(id));
}
}
