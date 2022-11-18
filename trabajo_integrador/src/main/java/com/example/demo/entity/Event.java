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
	 
	 @Column(name="ubication_event")
	 @OneToMany(mappedBy="event",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	 private List<Address> ubications;
	 
	 @Column(name="activity")
	 private Boolean activity;
	 
	 @Column(name="create_date")
	 private Date CreateDate;
	 
	
}
