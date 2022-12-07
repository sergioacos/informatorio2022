package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity (name="Organization")
public class Organization implements Serializable {
	 private static final long serialVersionUID = 1L;
	 //columnas de la tabla
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name_organization",length=30)
	 private String nameOrganization;

	 @Column(name="cuit_organization")
	 private Integer cuitOrganization;
	 
	 @Column(name="telephone_number")
	 private Integer TelephoneNumber;
	 
	
	 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	 private Address AddressOrganization;
	 
	 @Column(name="email_organization")
	 private String EmailOrganization;
	 
	 @Column(name="release_date")
	 private Date ReleaseDate;
	 
	 @Column(name="key_organization",length=30)
	 private String  key_organization;
	 
	 @ManyToMany (mappedBy= "organizations")
	  private List<Event> events;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameOrganization() {
		return nameOrganization;
	}

	public void setNameOrganization(String nameOrganization) {
		this.nameOrganization = nameOrganization;
	}

	public Integer getCuitOrganization() {
		return cuitOrganization;
	}

	public void setCuitOrganization(Integer cuitOrganization) {
		this.cuitOrganization = cuitOrganization;
	}

	public Integer getTelephoneNumber() {
		return TelephoneNumber;
	}

	public void setTelephoneNumber(Integer telephoneNumber) {
		TelephoneNumber = telephoneNumber;
	}

	public Address getAddressOrganization() {
		return AddressOrganization;
	}

	public void setAddressOrganization(Address addressOrganization) {
		AddressOrganization = addressOrganization;
	}

	public String getEmailOrganization() {
		return EmailOrganization;
	}

	public void setEmailOrganization(String emailOrganization) {
		EmailOrganization = emailOrganization;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}

	public String getKey_organization() {
		return key_organization;
	}

	public void setKey_organization(String key_organization) {
		this.key_organization = key_organization;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(Long id, String nameOrganization, Integer cuitOrganization, Integer telephoneNumber,
			Address addressOrganization, String emailOrganization, Date releaseDate, String key_organization,
			List<Event> events) {
		super();
		this.id = id;
		this.nameOrganization = nameOrganization;
		this.cuitOrganization = cuitOrganization;
		TelephoneNumber = telephoneNumber;
		AddressOrganization = addressOrganization;
		EmailOrganization = emailOrganization;
		ReleaseDate = releaseDate;
		this.key_organization = key_organization;
		this.events = events;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", nameOrganization=" + nameOrganization + ", CuitOrganization="
				+ cuitOrganization + ", TelephoneNumber=" + TelephoneNumber + ", AddressOrganization="
				+ AddressOrganization + ", EmailOrganization=" + EmailOrganization + ", ReleaseDate=" + ReleaseDate
				+ ", key_organization=" + key_organization + ", events=" + events + "]";
	}



}
