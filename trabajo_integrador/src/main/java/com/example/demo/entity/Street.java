package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity(name="streets")
public class Street implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
	   private String name;
	   
	   @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	  // @JoinColumn (name="addres_id")
	   private Address address;
}
