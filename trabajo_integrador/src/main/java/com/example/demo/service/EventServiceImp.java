package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Organization;
import com.example.demo.repository.IEventRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.wrapper.EventWrapper;
@Service
public class EventServiceImp implements IEventService {
	@Autowired
	private IEventRepository eventRepository;
	@Autowired
   private IUserRepository organRepository;
	
	@Override
	public EventDto save(EventDto eventDto) {
		Organization organ=organRepository.findByCuitOrganization(eventDto.getOrganization().getCuitOrganization());
		Event event= EventWrapper.dtoToEntity(eventDto);
		event.setOrganization(organ);
		event.setCreateDate(LocalDateTime.now());
		/*if(event.getCreateDate().isBefore(event.getDateEvent())) { */event.setActivity(true);
		
		eventDto= EventWrapper.entityToDto(eventRepository.save(event));
		return eventDto;
	}

	@Override
	public EventDto update(EventDto eventDto) {
		
		Organization organ=organRepository.findByCuitOrganization(eventDto.getOrganization().getCuitOrganization());
		Event event= EventWrapper.dtoToEntity(eventDto);
		if(event.getCreateDate().isBefore(event.getDateEvent())) { event.setActivity(true);
		eventDto.setOrganization(organ);
		eventDto= EventWrapper.entityToDto(eventRepository.save(event));
		return eventDto;
		}
		return eventDto;
	}

	@Override
	public void delete(Event event) {
		// TODO Auto-generated method stub
		event.setActivity(false);
		eventRepository.save(event);
		
	}

	@Override
	public Event findById(Long id) {
		Event event=eventRepository.findById(id).orElse(null);
		return event;
	}

	@Override
	public Event findByCreateDate(LocalDateTime createDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
