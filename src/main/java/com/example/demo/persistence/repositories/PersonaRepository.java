package com.example.demo.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, UUID> {

}
