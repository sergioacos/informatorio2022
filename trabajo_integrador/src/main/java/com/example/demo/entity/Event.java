package com.example.demo.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity (name="Events")
public class Event implements Serializable {
	 private static final long serialVersionUID = 1L;
	 //columnas de la tabla
	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="name_event",length=30)
	 private String NameEvent;

	 
	 @Column(name="es_recurrente")
	 private Boolean esRecurrente;
	 
	 
	 @OneToMany(mappedBy="event",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	 @Column(name="ubication_event")
	 private List<Address> ubications;
	 
	 @Column(name="activity")
	 private Boolean activity;
	 
	 @Column(name="create_date")
	 private LocalDateTime createDate;
	 
	 @Column(name="date_Event")
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	 private LocalDateTime dateEvent;
	 
	// @Column(name="organizations")
	 @ManyToOne(cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	 @JoinColumn(name="organizations_id")
	 private Organization organization;
	 
	 @Column(name="key_Event")
	  private String keyEvent;
	 
	 @Column(name="turns")
	 @OneToMany(mappedBy="events",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
     private List<Turn> turns;

	

	public Event(Long id, String nameEvent, Boolean type, List<Address> ubications, Boolean activity,
			LocalDateTime createDate, LocalDateTime dateEvent, Organization organization, String keyEvent,
			List<Turn> turns) {
		super();
		this.id = id;
		NameEvent = nameEvent;
		esRecurrente = type;
		this.ubications = ubications;
		this.activity = activity;
		createDate = createDate;
		this.dateEvent = dateEvent;
		this.organization = organization;
		this.keyEvent = keyEvent;
		this.turns = turns;
	}

	
	 
	
}
