package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;

public interface IPersonService {
	
	public List<PersonDto> getAll();
	
	// public PersonDto findByName(String name);
	 public Person findById(Long id) ;
	  public PersonDto save(PersonDto personDto);
	  public Person saveperson(Person person);
	  public void deletePerson(Person persondelete);
	  public List<PersonDto> findByLastname(String lastname);
	public PersonDto findByDni(Integer dni);
}
