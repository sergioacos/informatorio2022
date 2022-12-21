package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.Address;
import com.example.demo.entity.Event;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
	
	@NotBlank(message="El campo no debe estar en vacio")
	@Size(max=30, min=3, message="Debe ingresar un nombre entre 3 y 30 caracteres")
	 private String nameOrganization;
	
	
	@Min(value=999999999)
	
	 private Long CuitOrganization;
	
	private Integer TelephoneNumber;
	
	 private LocalDateTime ReleaseDate;
	 @NotNull
	 @JsonInclude(Include.NON_NULL)
	 private Address AddressOrganization;
	 @JsonIgnore
	 private List<Event> events;
	 @Email(message="Debe ingresar un email valido")
	 private String EmailOrganization;
	 @NotNull
	 @Size(max=30, min=8, message="Debe ingresar una contraseña entre 8 y 30 caracteres")
	 private String  key_organization;
	 
	
	 
}
