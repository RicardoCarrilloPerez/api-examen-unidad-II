package com.example.demo.persistence.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "te_item")
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
}
