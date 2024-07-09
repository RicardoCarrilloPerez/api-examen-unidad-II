package com.example.demo.persistence.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.entities.Persona;
import com.example.demo.persistence.repositories.PersonaRepository;

@Service
public class PersonaServiceImplementation implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	 @Override
	    public Persona save(Persona persona) {
	       
		 if (persona.getEmail() == null) {
	            throw new IllegalArgumentException("El campo 'email' no puede ser null");
	        }
		 
	        if (persona.getId() == null) {
	            persona.setId(UUID.randomUUID()); 
	        }
	        
	        
	        return personaRepository.save(persona);
	    }

	@Override
	public Persona update(UUID id, Persona persona) {
		Optional<Persona> personaOptional = null;
		personaOptional = this.personaRepository.findById(id);
		
		if (personaOptional.isPresent()) {
			personaOptional.get().setId(persona.getId());
			personaOptional.get().setName(persona.getName());
			personaOptional.get().setAge(persona.getAge());
			personaOptional.get().setUniversity(persona.getUniversity());
			personaOptional.get().setEmail(persona.getEmail());
			personaOptional.get().setBirthdate(persona.getBirthdate());
			
			this.personaRepository.save(personaOptional.get());
		
		}
		return personaOptional.orElseThrow();
	}

	@Override
	public List<Persona> getAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> findById(UUID id) {
		// TODO Auto-generated method stub
		return this.personaRepository.findById(id);
	}

	@Override
	public ResponseEntity<Persona> deletebyId(UUID id) {
		// TODO Auto-generated method stub
		
		Optional<Persona> personaOptional = null;
		ResponseEntity<Persona> responseEntity = null;
		
		personaOptional = this.personaRepository.findById(id);
		
		if (personaOptional.isPresent()) {
			this.personaRepository.delete(personaOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		}else {
			responseEntity = ResponseEntity.notFound().build();
		}
		return responseEntity;
	}

}
