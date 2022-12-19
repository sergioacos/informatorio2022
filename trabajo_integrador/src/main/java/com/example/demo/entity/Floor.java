package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
@Setter
@NoArgsConstructor
@Entity(name="floors")
public class Floor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
   private Integer floor;
	
   @OneToMany(mappedBy="floor",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
   	private List <Address> addresses;


public Floor(Integer floor, List<Address> addresses) {
	super();
	this.floor = floor;
	this.addresses = addresses;
}
   
   
}
