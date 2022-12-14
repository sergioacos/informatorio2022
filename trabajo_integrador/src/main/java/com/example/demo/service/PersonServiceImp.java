package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import com.example.demo.repository.IPersonRepository;
import com.example.demo.wrapper.PersonWrapper;

@Service
public class PersonServiceImp implements IPersonService {
	
	@Autowired
	private IPersonRepository personRepository;

	@Override
	public List<PersonDto> getAll() {
		//Person person= PersonWrapper.dtoToEntity(personDto);
		// TODO Auto-generated method stub
		List<PersonDto> listaDto=new ArrayList();
		List<Person> lista= personRepository.findAll();
		for(Person e:lista) {
		if(e.getActivity()) {PersonDto person = PersonWrapper.entityToDto(e);
		listaDto.add(person);}
		}
		return listaDto;
	}

	//@Override
	//public Person findByName(String name) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@Override
	public PersonDto save(PersonDto personDto) {
		Person person= PersonWrapper.dtoToEntity(personDto);
		person.setActivity(true);
		personDto = PersonWrapper.entityToDto(personRepository.save(person));
		return personDto;
	}
	public Person saveperson(Person person) {
		//Person person= PersonWrapper.dtoToEntity(person);
		person =personRepository.save(person);
		return person;
	}
	@Override
	public  void deletePerson(Person persondelete ) {
		//Person persondelete = personRepository.findById(id).orElse(null);
		//if(persondelete.getKey_person().equals(keyPerson)) {
		persondelete.setActivity(false);
		personRepository.save(persondelete);
		}
		
		
		
	//}

	@Override
	public PersonDto findByDni(Integer dni) {
		Person person= personRepository.findByDni(dni);
		PersonDto personDto=PersonWrapper.entityToDto(person);
		return personDto;
	}

	@Override
	public Person findById(Long id) {
		// TODO Auto-generated method stub
		Person person= personRepository.findById(id).orElse(null);
		return person;
	}

}
