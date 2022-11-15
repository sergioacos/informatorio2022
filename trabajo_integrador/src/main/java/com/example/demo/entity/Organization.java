package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="Organization")
public class Organization implements Serializable {
	 private static final long serialVersionUID = 1L;
	 //columnas de la tabla
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name_organization",length=30)
	 private String NameOrganization;

	 @Column(name="cuit_organization")
	 private Integer CuitOrganization;
	 
	 @Column(name="telephone_number")
	 private Integer TelephoneNumber;
	 
	 @Column(name="address_organization")
	 private Address AddressOrganization;
	 
	 @Column(name="email_organization")
	 private String EmailOrganization;
	 
	 @Column(name="release_date")
	 private Date ReleaseDate;
	 
	// @Column(name="key_organization")
	 //private KeyAlfa  key_organization;
	 

}
