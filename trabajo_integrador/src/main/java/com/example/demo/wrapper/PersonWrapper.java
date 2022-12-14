package com.example.demo.wrapper;

import java.util.List;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;

public class PersonWrapper {
	public static Person dtoToEntity(PersonDto dto) {
		if (dto== null) return new Person();
		
		Person entity= new Person();
		entity.setName(dto.getName());
		entity.setLastname(dto.getLastname());
		entity.setDni(dto.getDni());
		entity.setKey_person(dto.getKey_person());
		
		return entity;
	}
	public static PersonDto entityToDto(Person entity) {
		if (entity== null) return new PersonDto();
		
		PersonDto dto= new PersonDto();
		dto.setName(entity.getName());
		dto.setLastname(entity.getLastname());
		dto.setDni(entity.getDni());
		dto.setKey_person(entity.getKey_person());
		
		return dto;
		
		
	}
}
