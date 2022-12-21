package com.example.demo.controller;

import java.security.KeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Organization;
import com.example.demo.entity.Person;
import com.example.demo.service.IPersonService;

@RestController
@RequestMapping(value = "api/v1/person")
public class PersonController {
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private IPersonService personService;

	@GetMapping(value = "/dni/{dni}")
	public ResponseEntity<HashMap<String, Object>> dni(@PathVariable(value = "dni") Integer dni) {
		HashMap<String, Object> response = new HashMap<>();
		PersonDto person = personService.findByDni(dni);
		log.info("person" + person.toString());

		// if(person!= null) {

		response.put("person", person);
		log.info("person" + person.toString());
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		// }else {
		// return new ResponseEntity<HashMap<String,Object>>(response,
		// HttpStatus.NOT_FOUND);
		// }
	}

	@GetMapping(value = "/all")
	public ResponseEntity<HashMap<String, Object>> all() {
		HashMap<String, Object> response = new HashMap<>();
		List<PersonDto> persons = personService.getAll();
		response.put("persons", persons);
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/lastname/{lastname}")
	public ResponseEntity<HashMap<String, Object>> lastname(@PathVariable(value = "lastname") String lastname) {
		HashMap<String, Object> response = new HashMap<>();
		List<PersonDto> persons = personService.findByLastname(lastname);
	

		if (persons.isEmpty() == false) {

			response.put("persons", persons);

			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		} else {
			response.put("persons", "No se encontraron personas con ese apellido");
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newPerson(@Valid @RequestBody PersonDto persondto) throws Exception {
		log.info("person" + persondto.toString());
		Map<String, Object> response = new HashMap<>();
		PersonDto newPerson = personService.save(persondto);
		response.put("person", newPerson);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody PersonDto personDto) throws Exception {
		log.info("person: " + personDto.toString());
		Map<String, Object> response = new HashMap<>();
		PersonDto updatePerson = personService.findByDni(personDto.getDni());
		if (updatePerson == null) {
			throw new NotFoundException();
			
		}
		if (updatePerson.getKey_person().equals(personDto.getKey_person())) {
			updatePerson = personService.save(personDto);
			response.put("mensaje", "La persona".concat(updatePerson.getName()).concat("ha sido actualizada"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		}throw new KeyException();
		
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntity<Map<String, Object>> deletePerson(@Valid @RequestBody Person person) throws Exception {
		log.info("person: " + person.toString());
		Map<String, Object> response = new HashMap<>();
		
			Person deleteperson = personService.findById(person.getId());
			if (deleteperson != null) {
			if (deleteperson.getKey_person().equals(person.getKey_person())) {

				personService.deletePerson(deleteperson);
				response.put("Mensaje", "La persona fue eliminada existosamente");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}  throw new KeyException();
			
		}throw new NotFoundException();
	
		
	}
}
