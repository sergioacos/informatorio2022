package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity(name="addresses")
	public class Address implements Serializable {
		 private static final long serialVersionUID = 1L;
		 //columnas de la tabla
		 @Id
		 @GeneratedValue(strategy= GenerationType.IDENTITY)
		 private Long id;
		 
		 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
		 private Street street;
		 
		 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	     private NumberStreet number;
		 
		 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	     private Departament departament;
		 
		 
		 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	     private Floor floor;
		 
		 //@Column(name="address_organization")
		 //@JsonIgnore
		 @OneToOne(mappedBy = "AddressOrganization", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
		 
		 private Organization organization;
		 
		 //@JsonIgnore
		 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
		 
		 private Event event;

		public Address(Street street, NumberStreet number, Departament departament, Floor floor,
				Organization organization, Event event) {
			super();
			this.street = street;
			this.number = number;
			this.departament = departament;
			this.floor = floor;
			this.organization = organization;
			this.event = event;
		}

	
		 

	
		 
		 
}
