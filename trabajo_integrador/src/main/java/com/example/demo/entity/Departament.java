package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity(name="departaments")
public class Departament implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
   private String departament;


public Departament(String departament) {
	super();
	this.departament = departament;
}
   
  /* @OneToMany(mappedBy="departament",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
   
   //@JoinTable(name="adress_id")
   private List<Address> addresses;*/


/*public Departament(String departament, List <Address> addresses) {
	super();
	this.departament = departament;
	this.addresses = addresses;
}*/
   
}
