package com.example.demo.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.persistence.entities.Item;

public interface ItemService {

	Item save(Item item);
	
	Item update(Long id, Item item);
	
	List<Item> getAll();
	
	Optional<Item> findById(Long id);
	
	ResponseEntity<Item> deleteById(Long id);
}
