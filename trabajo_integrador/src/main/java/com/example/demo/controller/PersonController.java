package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Organization;
import com.example.demo.entity.Person;
import com.example.demo.service.IPersonService;

@RestController
@RequestMapping(value="api/v1/person")
public class PersonController {
	private static  final Logger log = LoggerFactory.getLogger(PersonController.class);
	 @Autowired
	 private IPersonService personService;
	 
	 @GetMapping(value="/dni/{dni}")
		public ResponseEntity<HashMap<String, Object>> dni(@PathVariable(value = "dni")Integer dni){
			HashMap<String,Object> response= new HashMap<>();
			PersonDto person= personService.findByDni(dni);
			log.info("person"+ person.toString());
			
			//if(person!= null) {
				
				response.put("person", person);
				log.info("person"+ person.toString());
				return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
			//}else {
				//return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
			//}
		}
	
@GetMapping(value="/all")
	
	public ResponseEntity<HashMap<String, Object>>all(){
		HashMap<String,Object> response = new HashMap<>();
		List<PersonDto> persons = personService.getAll();
		 response.put("persons",persons);
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
     }

@PostMapping("/")
    public ResponseEntity<Map<String,Object>> newPerson(@Valid @RequestBody PersonDto persondto )throws Exception{
	log.info("person"+persondto.toString());
	Map<String,Object> response= new HashMap<>();
	PersonDto newPerson= personService.save(persondto);
	response.put("person", newPerson);
	return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
@PutMapping("/")
public ResponseEntity<Map<String, Object>> update(@RequestBody PersonDto personDto){
	log.info("person: "+ personDto.toString());
	Map<String, Object> response = new HashMap<>();
	PersonDto updatePerson = personService.findByDni(personDto.getDni());
	if(updatePerson == null) {
		response.put("mensaje", "No se pudo actualizar la informacion de la persona.");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
	}
	if(updatePerson.getKey_person().equals(personDto.getKey_person())) {
	 updatePerson = personService.save(personDto);
	 response.put("person", updatePerson+"ha sido actualizada");
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	
	
	
	}response.put("mensaje", "Los datos ingresados no son correctos.");
	return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
}
@DeleteMapping(value="/delete")
public ResponseEntity<Map<String, Object>>deletePerson(@Valid @RequestBody Person person)throws Exception{
	log.info("person: "+ person.toString());
	Map<String,Object> response= new HashMap<>();
	if(person.getId() != null&&person.getKey_person()!=null) {
	Person deleteperson = personService.findById(person.getId());
	//log.info("person1: "+ deleteperson.toString());
	if(deleteperson.getKey_person().equals(person.getKey_person())) {
	
	 personService.deletePerson(deleteperson);
 response.put("Mensaje", "La persona fue eliminada existosamente");
 return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);}
	 response.put("Mensaje", "La contraseña ingresada no es correcta");
	 return new ResponseEntity<Map<String,Object>>(response, HttpStatus.UNAUTHORIZED);
	
 } response.put("Mensaje", "La persona no pudo ser eliminada verifique los datos ingresados");
 
	return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			
//public void deletePerson(@PathVariable (value="id") Long id) {
	
	//personService.deletePerson(id);
	
}
}

