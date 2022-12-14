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
	 private LocalDateTime createDate;
	 
	 @OneToOne(mappedBy= "turn")
	 private Person  person;
	 
	 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	 @JoinColumn(name="event_id", nullable=false)
	 private Event events;
	 
	 @ManyToOne (fetch= FetchType.LAZY, cascade=CascadeType.PERSIST)
	 @JoinColumn(name="organization_id", nullable=false)
	 private Organization organization;

	public Turn(String key, Boolean activity, LocalDateTime createDate, Person person, Event events) {
		super();
		this.key = key;
		this.activity = activity;
		this.createDate = createDate;
		this.person = person;
		this.events = events;
	}

	
	 
	
}
