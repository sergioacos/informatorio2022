package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
@Entity(name="floors")
public class Floor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   private Integer floor;
	
   @ManyToOne ()
   @JoinTable(name="adress_id")
	private List<Address> addresses;
}
