package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.TurnDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Organization;
import com.example.demo.entity.Turn;
import com.example.demo.repository.IEventRepository;
import com.example.demo.repository.ITurnRepository;
import com.example.demo.service.IEventService;
import com.example.demo.service.IOrganService;
import com.example.demo.service.ITurnService;

@RestController
@RequestMapping(value="api/v1/turn")
public class TurnController {
	
	private static final Logger log = LoggerFactory.getLogger(TurnController.class);
	
	@Autowired
	private ITurnService turnService;
	
	@Autowired
	private IEventService eventService;
	@Autowired
	private IOrganService organservice;
	
	@PostMapping("/")
	public ResponseEntity<Map<String,Object>> createTurn(@Valid @RequestBody TurnDto turnDto) throws Exception{
		Map<String,Object> response= new HashMap<>();
		     //Event event =turnService turnDto.getEvents().getId();
		log.info("imprimo"+ turnDto.toString());
		Event event=eventService.findById(turnDto.getEvents().getId());
		Organization orga=organservice.findById(turnDto.getOrganization().getId());
		//log.info("imprimo"+ orga.toString());
		//Long id=turnDto.getOrganization().getId();
		//log.info("id"+ id.toString());
		    turnDto.setEvents(event);
		    turnDto.setOrganization(orga);
		if (event.getEsRecurrente()) {
			if (turnService.findByCreateDate(turnDto.getCreateDate())!=null) {
	
				TurnDto newTurn= turnService.save(turnDto);
				response.put("turn", newTurn);
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
			} response.put("turn", "No existe un turno disponible en el horario seleccionado");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
	}
		turnDto.setCreateDate(event.getDateEvent());
		TurnDto newTurn= turnService.save(turnDto);
		response.put("turn", newTurn);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		    //return null;
	
	}
	@GetMapping(value="/organization/{id}")
	public ResponseEntity<HashMap<String, Object>> id(@PathVariable(value = "id")Long id){
		HashMap<String,Object> response= new HashMap<>();
		Organization organ= organservice.findById(id);
		if(organ!= null) {
		List<TurnDto> turns = turnService.findByOrganization(organ);
		if(turns.isEmpty()) {
			response.put("message", "La organizacion no posee turnos");
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
			response.put("turns", turns);	
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		} response.put("message", "La organizacion no fue encontrada");
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		
	}
	@GetMapping(value="/organization/{orgId}/event/{eventId}")
	public ResponseEntity<HashMap<String, Object>> id(@PathVariable(value = "orgId")Long orgId,@PathVariable(value="eventId")Long eventId) {
		HashMap<String,Object> response= new HashMap<>();
		Organization organ= organservice.findById(orgId);
		Event event= eventService.findById(eventId);
		if(organ!= null&& event!=null) {
		List<TurnDto> turns = turnService.findByEventsAndOrganization(event, organ);
		if(turns.isEmpty()) {
			response.put("message", "No se encontraron turnos");
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
			response.put("turns", turns);	
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		} response.put("message", "Los datos son incorrectos");
			return new ResponseEntity<HashMap<String,Object>>(response, HttpStatus.NOT_FOUND);
		
	}
	/*@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>>all(){
		HashMap<String,Object> response = new HashMap<>();
		List<TurnDto> turns = turnService.getAll();
		response.put("turns",turns);
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
	}
	@GetMapping("/active")
	public ResponseEntity<HashMap<String, Object>>active(){
		HashMap<String,Object> response = new HashMap<>();
		Organization Organ= organservice.
		List<TurnDto> turns = turnService.getActive();
		if(turns!=null) { response.put("turns",turns);
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.OK);
		}
		response.put("mensaje", "No existen  turnos activos");
		return new ResponseEntity<HashMap<String,Object>>(response,HttpStatus.NOT_FOUND);
	}*/
}
