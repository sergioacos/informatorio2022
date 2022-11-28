package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Address;
import com.example.demo.entity.Event;

public class OrganDto {
	 private String nameOrganization;
	 private Integer CuitOrganization;
	 private Date ReleaseDate;
	 private Address AddressOrganization;
	 private List<Event> events;
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
