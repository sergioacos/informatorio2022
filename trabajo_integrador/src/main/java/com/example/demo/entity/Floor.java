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
	@Column
   private Integer floor;
	
	public Floor(Integer floor) {
		super();
		this.floor = floor;
	}
	
 
   
}
