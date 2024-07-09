package com.example.demo.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.persistence.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
