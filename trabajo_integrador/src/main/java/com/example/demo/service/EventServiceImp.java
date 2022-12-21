package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Organization;
import com.example.demo.repository.IEventRepository;
import com.example.demo.repository.IOrganRepository;
import com.example.demo.wrapper.EventWrapper;
@Service
public class EventServiceImp implements IEventService {
	@Autowired
	private IEventRepository eventRepository;
	@Autowired
   private IOrganRepository organRepository;
	
	@Override
	public EventDto save(EventDto eventDto) {
		Organization organ=organRepository.findByCuitOrganization(eventDto.getOrganization().getCuitOrganization());
		Event event= EventWrapper.dtoToEntity(eventDto);
		event.setOrganization(organ);
		event.setCreateDate(LocalDateTime.now());
		event.setActivity(true);
		List<Event> eventexist= eventRepository.findByNameEvent(event.getNameEvent());
		
		if(eventexist.isEmpty()==false) {
			for(Event e:eventexist) {
			e.setActivity(false);
			eventRepository.save(e);
		}
		}
		eventDto= EventWrapper.entityToDto(eventRepository.save(event));
		return eventDto;
	}

	@Override
	public EventDto update(EventDto eventDto) {
		Event eventexist= eventRepository.findByNameEventAndActivityTrue(eventDto.getNameEvent());
		if (eventexist!=null) {
			Event eventPersist= new Event();
			eventPersist.setKeyEvent(eventexist.getKeyEvent());
			eventPersist.setNameEvent(eventexist.getNameEvent());
			eventPersist.setUbications(eventexist.getUbications());
			eventPersist.setDateEvent(eventexist.getDateEvent());
			eventPersist.setActivity(eventexist.getActivity());
			//verifico la fecha no sea anterior
			if(eventexist.getCreateDate().isAfter(eventDto.getDateEvent())) { eventPersist.setActivity(false);}
			List<Event> eventExist= eventRepository.findByNameEvent(eventPersist.getNameEvent());
			//verifica no haya dos nombres iguales
			if(eventExist.isEmpty()==false) {
				for(Event e:eventExist) {
				e.setActivity(false);
				eventRepository.save(e);
			}
			eventexist=eventRepository.save(eventPersist);
			eventDto= EventWrapper.entityToDto(eventRepository.save(eventexist));
			return eventDto;
			} return eventDto;
		}
		
		return null;
	}

	@Override
	public void delete(Event event) {
		// borrado logico
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

	@Override
	public List<Event> findByNameEvent(String nameEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event findByNameEventAndActivityTrue(String nameEvent) {
		// TODO Auto-generated method stub
		return null;
	}

}
