package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.example.demo.entity.Address;
import com.example.demo.entity.Event;

public class OrganDto {
	@NotNull
	@NotEmpty
	//@Min(value=4)
	//@Max(value=30)
	@Size(max=30, min=3, message="Debe ingresar un nombre entre 3 y 30 carateres")
	 private String nameOrganization;
	@Positive(message="Ingrese un número de cuit válido")
	 private Integer CuitOrganization;
	 private Date ReleaseDate;
	 private Address AddressOrganization;
	 private List<Event> events;
	 @Email(message="Debe ingresar un email valido")
	 private String EmailOrganization;
	 
	public String getNameOrganization() {
		return nameOrganization;
	}
	public void setNameOrganization(String nameOrganization) {
		this.nameOrganization = nameOrganization;
	}
	public Integer getCuitOrganization() {
		return CuitOrganization;
	}
	public void setCuitOrganization(Integer cuitOrganization) {
		CuitOrganization = cuitOrganization;
	}
	public Date getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}
	public Address getAddressOrganization() {
		return AddressOrganization;
	}
	public void setAddressOrganization(Address addressOrganization) {
		AddressOrganization = addressOrganization;
	}
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	public String getEmailOrganization() {
		return EmailOrganization;
	}
	public void setEmailOrganization(String emailOrganization) {
		EmailOrganization = emailOrganization;
	}
	public OrganDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrganDto(String nameOrganization, Integer cuitOrganization, Date releaseDate, Address addressOrganization,
			List<Event> events, String emailOrganization) {
		super();
		this.nameOrganization = nameOrganization;
		CuitOrganization = cuitOrganization;
		ReleaseDate = releaseDate;
		AddressOrganization = addressOrganization;
		this.events = events;
		EmailOrganization = emailOrganization;
	}
	
	 
}
