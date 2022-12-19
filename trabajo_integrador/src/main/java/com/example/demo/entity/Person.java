package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity (name="Person")
public class Person implements Serializable {
	 private static final long serialVersionUID = 1L;
	 //columnas de la tabla
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name",length=30)
	 @NotBlank(message="El campo no debe estar en vacio")
	 private String Name;
	 
	 @Column(name="lastname",length=30)
	 @NotBlank(message="El campo no debe estar en vacio")
	 private String lastname;

	 @Column(name="dni", unique=true)
	 @Min(value=7)
	 @Max(value=8)
	 private Integer dni;
	 
	 @Column(name="active")
	 private Boolean activity;
	 
	 @Column(name="ubication")
	 private Address Ubication;
	 
	 @Column(name="name_organization")
	 
	 private String nameOrganization;
	 
	 @Column(name="release_date")
	 private Date ReleaseDate;
	 
	 @Column(name="key_person",length=30)
	 @NotBlank(message="El campo no debe estar en blanco")
	 private String  key_person;
	 
	 @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 @JoinColumn(name="turn_id", referencedColumnName = "id")
		private Turn  turn;

	

	public Person(String name, String lastname, Integer dni, Address ubication,
			String emailOrganization, Date releaseDate, String key_person, Turn turn) {
		super();
		Name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.activity = true;
		Ubication = ubication;
		nameOrganization = emailOrganization;
		ReleaseDate = releaseDate;
		this.key_person = key_person;
		this.turn = turn;
	}
	public Person(String name, String lastname, Integer dni, Boolean activity, Address ubication,
			String emailOrganization, Date releaseDate, String key_person, Turn turn) {
		super();
		Name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.activity = activity;
		Ubication = ubication;
		nameOrganization = emailOrganization;
		ReleaseDate = releaseDate;
		this.key_person = key_person;
		this.turn = turn;
	}

	
	 
	 
	 

}
