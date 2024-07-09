package com.example.demo.persistence.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Item {

	@Id
	@Column(nullable = false)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String nameItem;
	
	@Column(nullable = false)
	private Double precio;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false, updatable = false)
	private Date createdOn;
}
