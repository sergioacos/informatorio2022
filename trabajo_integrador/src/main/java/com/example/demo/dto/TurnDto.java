package com.example.demo.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.entity.Address;
import com.example.demo.entity.Event;
import com.example.demo.entity.Person;
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
public class TurnDto {
	//@NotNull
	//@NotEmpty
	private String key;
	@NotNull
	private Boolean activity;
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createDate;
	//@NotNull
	//@NotEmpty
	 private Person  person;
	@NotNull
	 private Event events;
}
