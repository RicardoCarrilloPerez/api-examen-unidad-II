package com.example.demo.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.entities.Item;
import com.example.demo.persistence.repositories.ItemRepository;

@Service
public class ItemServiceImplementation implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Item save(Item item) {		
		return this.itemRepository.save(item);
	}

	@Override
	public Item update(Long id, Item item) {
		Optional<Item> itemOptional = null;
		itemOptional = this.itemRepository.findById(id);
				
		if (itemOptional.isPresent()) {
			itemOptional.get().setId(item.getId());
			itemOptional.get().setNameItem(item.getNameItem());
			itemOptional.get().setPrecio(item.getPrecio());
			
			this.itemRepository.save(itemOptional.get());
		}
		return itemOptional.orElseThrow();
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return this.itemRepository.findAll();
	}

	@Override
	public Optional<Item> findById(Long id) {
		// TODO Auto-generated method stub
		return this.itemRepository.findById(id);
	}

	@Override
	public ResponseEntity<Item> deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Item> itemOptional = null;
		ResponseEntity<Item> responseEntity = null;
		
		itemOptional = this.itemRepository.findById(id);
		
		if (itemOptional.isPresent()) {
			this.itemRepository.delete(itemOptional.get());
			responseEntity = ResponseEntity.noContent().build();
		}else {
			responseEntity = ResponseEntity.notFound().build();
			
		}
		return responseEntity;
	}

}
