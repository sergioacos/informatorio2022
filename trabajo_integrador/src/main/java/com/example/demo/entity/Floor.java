package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
@Entity(name="floors")
public class Floor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   private Integer floor;
	
	@OneToMany(mappedBy = "departament", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Organization> organizations;
}
