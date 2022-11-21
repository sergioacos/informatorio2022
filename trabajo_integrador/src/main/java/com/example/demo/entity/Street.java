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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Street() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Street(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	   
	   
}
