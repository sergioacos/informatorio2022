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
import javax.persistence.OneToMany;

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
	 @OneToMany(mappedBy="organization",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	 private List<Address> AddressOrganization;
	 
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
		return NameOrganization;
	}

	public void setNameOrganization(String nameOrganization) {
		NameOrganization = nameOrganization;
	}

	public Integer getCuitOrganization() {
		return CuitOrganization;
	}

	public void setCuitOrganization(Integer cuitOrganization) {
		CuitOrganization = cuitOrganization;
	}

	public Integer getTelephoneNumber() {
		return TelephoneNumber;
	}

	public void setTelephoneNumber(Integer telephoneNumber) {
		TelephoneNumber = telephoneNumber;
	}

	public List<Address> getAddressOrganization() {
		return AddressOrganization;
	}

	public void setAddressOrganization(List<Address> addressOrganization) {
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

	public Organization(String nameOrganization, Integer cuitOrganization, Integer telephoneNumber/*,
			List<Address> addressOrganization, String emailOrganization, Date releaseDate, String key_organization,
			List<Event> events*/) {
		super();
		NameOrganization = nameOrganization;
		CuitOrganization = cuitOrganization;
		TelephoneNumber = telephoneNumber;
		/*AddressOrganization = addressOrganization;
		EmailOrganization = emailOrganization;
		ReleaseDate = releaseDate;
		this.key_organization = key_organization;
		this.events = events;*/
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", NameOrganization=" + NameOrganization + ", CuitOrganization="
				+ CuitOrganization + ", TelephoneNumber=" + TelephoneNumber + ", AddressOrganization="
				+ AddressOrganization + ", EmailOrganization=" + EmailOrganization + ", ReleaseDate=" + ReleaseDate
				+ ", key_organization=" + key_organization + ", events=" + events + "]";
	}
	

}
