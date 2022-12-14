package com.example.demo.wrapper;

import com.example.demo.dto.TurnDto;
import com.example.demo.entity.Turn;

public class TurnWrapper {
	public static Turn dtoToEntity(TurnDto dto) {
		if(dto==null)return new Turn ();
		Turn entity = new Turn();
		entity.setKey(dto.getKey());
		entity.setActivity(dto.getActivity());
		entity.setPerson(dto.getPerson());
		entity.setCreateDate(dto.getCreateDate());
		entity.setEvents(dto.getEvents());
		
		return entity;
	}
	public static TurnDto entityToDto(Turn entity) {
		if(entity==null)return new TurnDto ();
		TurnDto dto = new TurnDto();
		dto.setKey(entity.getKey());
		dto.setActivity(entity.getActivity());
		dto.setPerson(entity.getPerson());
		dto.setCreateDate(entity.getCreateDate());
		dto.setEvents(entity.getEvents());
		
		return dto;
	}
}
