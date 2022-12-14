package com.example.demo.service;

import java.time.LocalDateTime;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;

public interface IEventService {
	public EventDto save(EventDto eventDto);
	public EventDto update (EventDto eventDto);
	public void delete (Event event);
	public Event findById(Long id) ;
	public Event findByCreateDate(LocalDateTime createDate);
}
