package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.Address;
import com.example.demo.entity.Event;
import com.example.demo.entity.Organization;
import com.example.demo.entity.Turn;
import com.fasterxml.jackson.annotation.JsonFormat;

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
public class EventDto {
	@NotNull
	@NotEmpty
	@Size(max = 30, min = 4, message = "Debe ingresar un nombre entre 4 y 30 caracteres")
	private String NameEvent;

	@NotNull
	private Boolean esRecurrente;

	@Size(min = 1, message = "Debe ingresar una ubicacion ")
	private List<Address> ubications;

	private Boolean activity;

	@NotBlank(message = "Elcampo no puede estar en blanco")
	@Size(max = 40, min = 20, message = "Debe ingresar una contraseseña correcta ")
	private String keyEvent;

	private LocalDateTime CreateDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateEvent;

	@NotNull
	private Organization organization;

	private List<Turn> turns;

}
