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

    public Item save(Item item) {
    	return this.itemRepository.save(item);
    	
    }


    @Override
    public Item update(Long id, Item item) {
        Optional<Item> itemOptional = this.itemRepository.findById(id);
                
        if (itemOptional.isPresent()) {
            Item existingItem = itemOptional.get();
            existingItem.setName(item.getName());
            existingItem.setPrecio(item.getPrecio());
            return this.itemRepository.save(existingItem);
        }
        return itemOptional.orElseThrow();
    }

    @Override
    public List<Item> getAll() {
        return this.itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return this.itemRepository.findById(id);
    }

    @Override
    public ResponseEntity<Item> deleteById(Long id) {
        Optional<Item> itemOptional = null;
        ResponseEntity<Item> responseEntity = null;
        
        itemOptional = this.itemRepository.findById(id);
        
        if (itemOptional.isPresent()) {
            this.itemRepository.delete(itemOptional.get());
            responseEntity = ResponseEntity.noContent().build();
        } else {
           responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }
}
