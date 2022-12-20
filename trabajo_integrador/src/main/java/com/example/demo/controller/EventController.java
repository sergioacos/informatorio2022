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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Organization;
import com.example.demo.service.IEventService;
import com.example.demo.service.IOrganService;
import com.example.demo.wrapper.EventWrapper;

@RestController
@RequestMapping(value = "api/v1/event")
public class EventController {
	private static final Logger log = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private IEventService eventService;
	@Autowired
	private IOrganService organservice;

	@PostMapping("/")
	public ResponseEntity<Map<String, Object>> newEvent(@Valid @RequestBody EventDto eventdto) throws Exception {
		log.info("event" + eventdto.toString());
		Map<String, Object> response = new HashMap<>();
		
		Organization orga=organservice.findById(eventdto.getOrganization().getId());
		eventdto.setOrganization(orga);
		EventDto newEvent = eventService.save(eventdto);
		response.put("event", newEvent);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	
	@PutMapping("/")
	public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody EventDto eventDto) {
		log.info("event: " + eventDto.toString());
		Map<String, Object> response = new HashMap<>();
		Organization organ = eventDto.getOrganization();

		//if (eventDto == null) {
			//response.put("mensaje", "No se pudo actualizar la informacion del evento.");
			//return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		//}
		if (organ.getKey_organization().equals(eventDto.getKeyEvent())) {
			EventDto updateEvent = eventService.update(eventDto);
			response.put("person", updateEvent + "ha sido actualizada");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		}
		response.put("mensaje", "Los datos ingresados no son correctos.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}

	// rever!!!!
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Map<String, Object>> deleteEvent(@Valid @RequestBody EventDto eventDto) {
		log.info("event: " + eventDto.toString());
		Map<String, Object> response = new HashMap<>();
		Organization organ = eventDto.getOrganization();

		/*if (eventDto == null) {
			response.put("mensaje", "No se pudo actualizar la informacion del evento.");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}*/
		if (organ.getKey_organization().equals(eventDto.getKeyEvent())) {
			Event event = EventWrapper.dtoToEntity(eventDto);
			/* Event updateEvent = */ eventService.delete(event);
			response.put("person", event + "ha sido eliminada");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

		}
		response.put("mensaje", "Los datos ingresados no son correctos.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
	}

}
