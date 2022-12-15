package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.example.demo.entity.Address;
import com.example.demo.entity.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganDto {
	@NotNull
	@NotEmpty
	//@Min(value=4)
	//@Max(value=30)
	@Size(max=30, min=3, message="Debe ingresar un nombre entre 3 y 30 caracteres")
	 private String nameOrganization;
	@Positive(message="Ingrese un número de cuit válido")
	 private Integer CuitOrganization;
	 private LocalDateTime ReleaseDate;
	 private Address AddressOrganization;
	 private List<Event> events;
	 @Email(message="Debe ingresar un email valido")
	 private String EmailOrganization;
	 @Size(max=30, min=8, message="Debe ingresar una contraseña entre 8 y 30 caracteres")
	 private String  key_organization;
	 
	
	 
}
