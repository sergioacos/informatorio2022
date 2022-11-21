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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name="Turns")
public class Turn implements Serializable {
	 private static final long serialVersionUID = 1L;
	 //columnas de la tabla
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	  
	 @Column(name="key")
	 private String key;
	 
	 
	 @Column(name="activity")
	 private Boolean activity;
	 
	 @Column(name="create_date")
	 private Date CreateDate;
	 
	 @OneToOne(fetch=FetchType.LAZY)
	 private Person  person;
	 
	 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	 private Event events;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Event getEvents() {
		return events;
	}

	public void setEvents(Event events) {
		this.events = events;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Turn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turn(String key, Boolean activity, Date createDate, Person person, Event events) {
		super();
		this.key = key;
		this.activity = activity;
		CreateDate = createDate;
		this.person = person;
		this.events = events;
	}
	 
	
}
