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
import javax.persistence.JoinColumn;
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
@Entity(name="numbers_street")
public class NumberStreet implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@Column(unique=true)
   private Integer number;
   
   @OneToMany(mappedBy="number",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
  // @JoinColumn (name="addres_id")
   private List <Address> addresses;



public NumberStreet(Integer number, List<Address> addresses) {
	super();
	this.number = number;
	this.addresses = addresses;
}
   
   
}
