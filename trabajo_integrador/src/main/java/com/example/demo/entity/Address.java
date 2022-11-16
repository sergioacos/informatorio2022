package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="addresses")
	public class Address implements Serializable {
		 private static final long serialVersionUID = 1L;
		 //columnas de la tabla
		 @Id
		 @GeneratedValue(strategy= GenerationType.IDENTITY)
		 private Long id;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
		 private List<Street> streets;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	     private List<NumberStreet> Number;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	     private List<Departament> departament;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	     private List<Floor> floor;

}
