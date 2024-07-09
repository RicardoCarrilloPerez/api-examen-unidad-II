package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.persistence.service.ItemService;
import com.example.demo.persistence.service.PersonaService;


@RestController
@RequestMapping("/api/v1/items")
@Validated
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    private PersonaService personaService;

    @GetMapping
    public List<Item> get() {
        return this.itemService.getAll();
    }
    
    @PostMapping
    public ResponseEntity<Item> save(@RequestBody @Validated Item item) {
        return ResponseEntity.created(null).body(this.itemService.save(item));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable("id")Long id,@RequestBody @Validated Item item) {
        return ResponseEntity.ok(this.itemService.update(id, item));
}
    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable("id") Long id) {
        return this.itemService.deleteById(id);
}
    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable("id") Long id) {
        return ResponseEntity.of(this.itemService.findById(id));
}
}