package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
@Setter
@NoArgsConstructor
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
	 
	
	 @OneToOne (mappedBy="organization",fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	 
	 private Address AddressOrganization;
	 
	 @Column(name="email_organization")
	 private String EmailOrganization;
	 
	 @Column(name="release_date")
	 private LocalDateTime ReleaseDate;
	 
	 @Column(name="key_organization",length=30)
	 private String  key_organization;
	 
	 @OneToMany (mappedBy= "organization")
	 
	  private List<Event> events;
	 
	 @OneToMany (mappedBy= "organization")
	 
	  private List<Turn> turns;

	public Organization(String nameOrganization, Integer cuitOrganization, Integer telephoneNumber,
			Address addressOrganization, String emailOrganization, LocalDateTime releaseDate, String key_organization,
			List<Event> events) {
		super();
		this.nameOrganization = nameOrganization;
		this.cuitOrganization = cuitOrganization;
		TelephoneNumber = telephoneNumber;
		AddressOrganization = addressOrganization;
		EmailOrganization = emailOrganization;
		ReleaseDate = releaseDate;
		this.key_organization = key_organization;
		this.events = events;
	}
}

