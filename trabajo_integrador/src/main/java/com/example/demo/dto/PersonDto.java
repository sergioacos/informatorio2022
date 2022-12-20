package com.example.demo.dto;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


public class PersonDto {

	@NotBlank
	@Size(max=30, min=4, message="Debe ingresar un nombre entre 4 y 30 caracteres")
	 private String Name;
	
	@NotBlank
	@Size(max=30, min=4, message="Debe ingresar un nombre entre 4 y 30 caracteres")
	 private String lastname;
	
	@NotNull
	@Positive(message="Ingrese un número de dni válido")
	 private Integer dni;
	
	
	@NotBlank
	 @Size(max=30, min=8, message="Debe ingresar un clave entre 8 y 30 caracteres")
	 private String  key_person;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "PersonDto [Name=" + Name + ", lastname=" + lastname + ", dni=" + dni + ", key_person=" + key_person
				+ "]";
	}

	public String getKey_person() {
		return key_person;
	}

	public void setKey_person(String key_person) {
		this.key_person = key_person;
	}

	public PersonDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonDto(
			@NotNull @NotEmpty @Size(max = 30, min = 4, message = "Debe ingresar un nombre entre 4 y 30 caracteres") String name,
			@NotNull @NotEmpty @Size(max = 30, min = 4, message = "Debe ingresar un nombre entre 4 y 30 caracteres") String lastname,
			@NotNull @NotEmpty @Positive(message = "Ingrese un número de dni válido") Integer dni,
			@NotNull @NotEmpty @Size(max = 30, min = 8, message = "Debe ingresar un clave entre 3 y 30 caracteres") String key_person) {
		super();
		Name = name;
		this.lastname = lastname;
		this.dni = dni;
		this.key_person = key_person;
	}
	 
	

}
