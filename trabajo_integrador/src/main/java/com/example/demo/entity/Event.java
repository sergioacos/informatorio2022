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

@Entity (name="Events")
public class Event implements Serializable {
	 private static final long serialVersionUID = 1L;
	 //columnas de la tabla
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name_event",length=30)
	 private String NameEvent;

	 
	 @Column(name="type")
	 private Boolean Type;
	 
	 
	 @OneToMany(mappedBy="event",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	 @Column(name="ubication_event")
	 private List<Address> ubications;
	 
	 @Column(name="activity")
	 private Boolean activity;
	 
	 @Column(name="create_date")
	 private Date CreateDate;
	 
	 @Column(name="organizations")
	 @ManyToMany(cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	 private List<Organization> organizations;
	 
	 @Column(name="turns")
	 @OneToMany(mappedBy="events",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
     private List<Turn> turns;

	 
	 
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNameEvent() {
		return NameEvent;
	}



	public void setNameEvent(String nameEvent) {
		NameEvent = nameEvent;
	}



	public Boolean getType() {
		return Type;
	}



	public void setType(Boolean type) {
		Type = type;
	}



	public List<Address> getUbications() {
		return ubications;
	}



	public void setUbications(List<Address> ubications) {
		this.ubications = ubications;
	}



	public Boolean getActivity() {
		return activity;
	}



	public void setActivity(Boolean activity) {
		this.activity = activity;
	}



	public Date getCreateDate() {
		return CreateDate;
	}



	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}



	public List<Organization> getOrganizations() {
		return organizations;
	}



	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}



	public List<Turn> getTurns() {
		return turns;
	}



	public void setTurns(List<Turn> turns) {
		this.turns = turns;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Event(Long id, String nameEvent, Boolean type, List<Address> ubications, Boolean activity, Date createDate,
			List<Organization> organizations, List<Turn> turns) {
		super();
		NameEvent = nameEvent;
		Type = type;
		this.ubications = ubications;
		this.activity = activity;
		CreateDate = createDate;
		this.organizations = organizations;
		this.turns = turns;
	}
	 
	 
	
}
