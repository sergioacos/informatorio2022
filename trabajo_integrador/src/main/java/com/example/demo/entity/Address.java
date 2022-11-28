package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="addresses")
	public class Address implements Serializable {
		 private static final long serialVersionUID = 1L;
		 //columnas de la tabla
		 @Id
		 @GeneratedValue(strategy= GenerationType.IDENTITY)
		 private Long id;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
		 private List<Street> streets;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	     private List<NumberStreet> number;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	     private List<Departament> departament;
		 
		 @OneToMany(mappedBy="address",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	     private List<Floor> floor;
		 
		 @Column(name="address_organization")
		 @OneToMany(mappedBy="AddressOrganization",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
		 
		 private List<Organization> organizations;
		 
		 
		 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
		 private Event event;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<Street> getStreets() {
			return streets;
		}

		public void setStreets(List<Street> streets) {
			this.streets = streets;
		}

		public List<NumberStreet> getNumber() {
			return number;
		}

		public void setNumber(List<NumberStreet> number) {
			this.number = number;
		}

		public List<Departament> getDepartament() {
			return departament;
		}

		public void setDepartament(List<Departament> departament) {
			this.departament = departament;
		}

		public List<Floor> getFloor() {
			return floor;
		}

		public void setFloor(List<Floor> floor) {
			this.floor = floor;
		}

		public List<Organization> getOrganizations() {
			return organizations;
		}

		public void setOrganizations(List<Organization> organizations) {
			this.organizations = organizations;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Address(List<Street> streets, List<NumberStreet> number, List<Departament> departament,
				List<Floor> floor, List<Organization> organizations, Event event) {
			super();
			this.streets = streets;
			this.number = number;
			this.departament = departament;
			this.floor = floor;
			this.organizations = organizations;
			this.event = event;
		}

		 
		 
}
