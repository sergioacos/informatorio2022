package com.example.demo.wrapper;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;

public class EventWrapper {
	public static Event dtoToEntity(EventDto dto) {
		if(dto==null)return new Event();
		Event entity = new Event();
		entity.setNameEvent(dto.getNameEvent());
		entity.setEsRecurrente(dto.getEsRecurrente());
		entity.setKeyEvent(dto.getKeyEvent());
		entity.setUbications(dto.getUbications());
		entity.setActivity(dto.getActivity());
		entity.setCreateDate(dto.getCreateDate());
		entity.setDateEvent(dto.getDateEvent());
		entity.setOrganization(dto.getOrganization());
		entity.setTurns(dto.getTurns());
		
		return entity;
	}
	public static EventDto entityToDto(Event entity) {
		if(entity==null)return new EventDto();
		EventDto dto = new EventDto();
		dto.setNameEvent(entity.getNameEvent());
		dto.setEsRecurrente(entity.getEsRecurrente());
		dto.setKeyEvent(entity.getKeyEvent());
		dto.setUbications(entity.getUbications());
		dto.setActivity(entity.getActivity());
		dto.setCreateDate(entity.getCreateDate());
		dto.setDateEvent(entity.getDateEvent());
		dto.setOrganization(entity.getOrganization());
		dto.setTurns(entity.getTurns());
		
		return dto;
	}

}

