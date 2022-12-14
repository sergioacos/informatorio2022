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
	 
	 @Column(name="name_organization")
	 private String nameOrganization;
	 
	 @Column(name="release_date")
	 private Date ReleaseDate;
	 
	 @Column(name="key_person",length=30)
	 private String  key_person;
	 
	 @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	 @JoinColumn(name="turn_id", referencedColumnName = "id")
		private Turn  turn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Boolean getActivity() {
		return activity;
	}

	public void setActivity(Boolean activity) {
		this.activity = activity;
	}

	public Address getUbication() {
		return Ubication;
	}

	public void setUbication(Address ubication) {
		Ubication = ubication;
	}

	public String getNameOrganization() {
		return nameOrganization;
	}

	public void setNameOrganization(String nameOrganization) {
		this.nameOrganization = nameOrganization;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getKey_person() {
		return key_person;
	}

	public void setKey_person(String key_person) {
		this.key_person = key_person;
	}

	public Turn getTurn() {
		return turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + Name + ", lastname=" + lastname + ", dni=" + dni + ", activity="
				+ activity + ", Ubication=" + Ubication + ", nameOrganization=" + nameOrganization + ", ReleaseDate="
				+ ReleaseDate + ", key_person=" + key_person + ", turn=" + turn + "]";
	}
	 
	 
	 

}
