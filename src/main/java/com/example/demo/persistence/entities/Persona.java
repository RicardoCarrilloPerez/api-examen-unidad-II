package com.example.demo.persistence.entities;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Persona {
	
	@Id
	@Column
	private UUID id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column
	private Integer age;
	
	@Column(length = 100, nullable = false)
	private String university;
	
	@Column(length = 20, nullable = false)
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date   birthdate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false, updatable = false)
	private Date createdOn;

}
