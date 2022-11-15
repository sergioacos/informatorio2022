package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="Person")
public class Person implements Serializable {
	 private static final long serialVersionUID = 1L;
	 //columnas de la tabla
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name",length=30)
	 private String Name;
	 
	 @Column(name="lastname",length=30)
	 private String lastname;

	 @Column(name="dni")
	 private Integer dni;
	 
	 @Column(name="active")
	 private Boolean activity;
	 
	 @Column(name="ubication")
	 private Address Ubication;
	 
	 @Column(name="email_organization")
	 private String EmailOrganization;
	 
	 @Column(name="release_date")
	 private Date ReleaseDate;
	 
	// @Column(name="key_person")
	// private KeyAlfa  key_person;
	 

}
