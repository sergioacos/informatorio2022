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

@Entity(name="addresses")
	public class Address implements Serializable {
		 private static final long serialVersionUID = 1L;
		 //columnas de la tabla
		 @Id
		 @GeneratedValue(strategy= GenerationType.IDENTITY)
		 private Long id;
		 
		
		 @OneToOne(mappedBy = "AddressOrganization", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
		 
		 private Organization organization;
		 
		 
		 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
		 @JoinColumn(name="event_id", referencedColumnName="id")
		 private Event event;
		 
		 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
			@JoinTable(name="address_street", joinColumns = @JoinColumn(name="address_id"), 
			inverseJoinColumns = @JoinColumn(name="street_id"))
			private Set<Street> street;
			
			@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
			@JoinTable(name="address_number", joinColumns = @JoinColumn(name="address_id"), 
			inverseJoinColumns = @JoinColumn(name="number_id"))
			private Set<NumberStreet> number;
			
			@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
			@JoinTable(name="address_department", joinColumns = @JoinColumn(name="address_id"), 
			inverseJoinColumns = @JoinColumn(name="department_id"))
			private Set<Departament> departament;
			
			@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
			@JoinTable(name="address_floor", joinColumns = @JoinColumn(name="address_id"), 
			inverseJoinColumns = @JoinColumn(name="floor_id"))
			private Set<Floor> floor;
			

			public Long getId() {
				return id;
			}


			public void setId(Long id) {
				this.id = id;
			}


			public Organization getOrganization() {
				return organization;
			}


			public void setOrganization(Organization organization) {
				this.organization = organization;
			}


			public Event getEvent() {
				return event;
			}


			public void setEvent(Event event) {
				this.event = event;
			}


			public Set<Street> getStreet() {
				return street;
			}


			public void setStreet(Set<Street> street) {
				this.street = street;
			}


			public Set<NumberStreet> getNumber() {
				return number;
			}


			public void setNumber(Set<NumberStreet> number) {
				this.number = number;
			}


			public Set<Departament> getDepartament() {
				return departament;
			}


			public void setDepartament(Set<Departament> departament) {
				this.departament = departament;
			}


			public Set<Floor> getFloor() {
				return floor;
			}


			public void setFloor(Set<Floor> floor) {
				this.floor = floor;
			}


			public static long getSerialversionuid() {
				return serialVersionUID;
			}
			


			public Address() {
				super();
				// TODO Auto-generated constructor stub
			}


			public Address(Organization organization, Event event, Set<Street> street, Set<NumberStreet> number,
					Set<Departament> departament, Set<Floor> floor) {
				super();
				this.organization = organization;
				this.event = event;
				this.street = street;
				this.number = number;
				this.departament = departament;
				this.floor = floor;
			}

			

	
	
		 

	
		 
		 
}
