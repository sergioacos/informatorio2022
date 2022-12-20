package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity(name="streets")
public class Street implements Serializable{
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		//@Column(unique=true)
	   private String name;
	   
		public Street(String name) {
			super();
			this.name = name;
		}
	   
	   
	   
	   
	 /*  @OneToMany(mappedBy="street",cascade=CascadeType.PERSIST,fetch= FetchType.LAZY)
	  // @JoinColumn (name="addres_id")
	   private List <Address> addresses;

	public Street(String name, List<Address> addresses) {
		super();
		this.name = name;
		this.addresses = addresses;
	}*/


	
	   
	   
}
