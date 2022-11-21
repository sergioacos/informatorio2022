package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name="departaments")
public class Departament implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   private String departament;
   
   @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
   //@JoinTable(name="adress_id")
   private Address address;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDepartament() {
	return departament;
}

public void setDepartament(String departament) {
	this.departament = departament;
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

public Departament() {
	super();
	// TODO Auto-generated constructor stub
}

public Departament(String departament, Address address) {
	super();
	this.departament = departament;
	this.address = address;
}
   
}
