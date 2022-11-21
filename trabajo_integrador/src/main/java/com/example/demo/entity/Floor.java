package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="floors")
public class Floor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   private Integer floor;
	
   @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
   	private Address address;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getFloor() {
	return floor;
}

public void setFloor(Integer floor) {
	this.floor = floor;
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

public Floor() {
	super();
	// TODO Auto-generated constructor stub
}

public Floor(Integer floor, Address address) {
	super();
	this.floor = floor;
	this.address = address;
}
   
   
}
