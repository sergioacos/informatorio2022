package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="addresses")
	public class Address implements Serializable {
		 private static final long serialVersionUID = 1L;
		 //columnas de la tabla
		 @Id
		 @GeneratedValue(strategy= GenerationType.IDENTITY)
		 private Long id;
		 @ManyToMany(cascade=CascadeType.PERSIST,fetch= FetchType.EAGER)
	     private Set<Street> streets;
	     
	     private NumberStreet Number;
	     
	     private Departament departament;
	     
	     private Floor floor;

}
