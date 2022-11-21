package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
@Entity(name="numbers_street")
public class NumberStreet implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   private Integer number;
   
   @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
  // @JoinColumn (name="addres_id")
   private Address address;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getNumber() {
	return number;
}

public void setNumber(Integer number) {
	this.number = number;
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

public NumberStreet() {
	super();
	// TODO Auto-generated constructor stub
}

public NumberStreet(Integer number, Address address) {
	super();
	this.number = number;
	this.address = address;
}
   
   
}
