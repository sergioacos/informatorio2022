package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.TurnDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Organization;
import com.example.demo.entity.Turn;

public interface ITurnService {
	public TurnDto save(TurnDto turnDto);
	public List<TurnDto> getAll();
	public List<TurnDto> getActive();
	public List<TurnDto> activeOrgEventAll();
	public TurnDto findByCreateDate(LocalDateTime createdate);
	public TurnDto findByKey(String keyturn);
	public List<TurnDto> findByEventsAndOrganization(Event event, Organization organization);
	public Turn findById(Long id);
	public List<TurnDto> findByOrganization( Organization organization);
}
