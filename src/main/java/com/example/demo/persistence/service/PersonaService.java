package com.example.demo.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.demo.persistence.entities.Persona;

public interface PersonaService {

	Persona save(Persona persona);
	
	Persona update(UUID id, Persona persona);
	
	List<Persona> getAll();
	
	Optional<Persona> findById(UUID id);
	
	ResponseEntity<Persona> deletebyId(UUID id);
	
}
