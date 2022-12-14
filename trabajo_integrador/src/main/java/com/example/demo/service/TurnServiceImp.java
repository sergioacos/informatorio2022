package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.TurnDto;
import com.example.demo.entity.Turn;
import com.example.demo.repository.IEventRepository;
import com.example.demo.repository.IPersonRepository;
import com.example.demo.repository.ITurnRepository;
import com.example.demo.wrapper.TurnWrapper;
@Service
public class TurnServiceImp implements ITurnService{
	
	@Autowired
	private ITurnRepository turnRepository;
	
	@Autowired
	private IPersonRepository personRepository;
	
	@Autowired
	private IEventRepository eventRepository;

	@Override
	public TurnDto save(TurnDto turnDto) {
		Turn turn= TurnWrapper.dtoToEntity(turnDto);
		turn.setKey(RandomStringUtils.random(10));
		while (turnRepository.findByKey(turn.getKey())!= null) {
		turn.setKey(RandomStringUtils.random(10));}
		turnDto = TurnWrapper.entityToDto(turnRepository.save(turn));
		return turnDto;
		
	}

	@Override
	public List<TurnDto> getAll() {
		List<Turn>turns=turnRepository.findAll();
		List<TurnDto>turnsDto= new ArrayList();
		for (Turn e:turns) {
		TurnDto turnDto=TurnWrapper.entityToDto(e);
		turnsDto.add(turnDto);
		}
		return turnsDto;
	}

	@Override
	public List<TurnDto> getActive() {
		List<Turn>turns=turnRepository.findAll();
		List<TurnDto>turnsDto= new ArrayList();
		for (Turn e:turns) {
		if(e.getActivity()) { TurnDto turnDto=TurnWrapper.entityToDto(e);
		turnsDto.add(turnDto);
		return turnsDto;}
		}
		return null;
	}

	@Override
	public List<TurnDto> activeOrgEventAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TurnDto findByCreateDate(LocalDateTime createDate) {
		Turn turn=turnRepository.findByCreateDate(createDate);
		TurnDto turnDto= TurnWrapper.entityToDto(turn);
		return turnDto;
	}

	@Override
	public TurnDto findByKey(String keyturn) {
		Turn turn=turnRepository.findByKey(keyturn);
		TurnDto turnDto= TurnWrapper.entityToDto(turn);
		return turnDto;
	}

	@Override
	public Turn findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	//public Turn findById(Long id) {
	//	Turn turn=eventRepository.findById(id).orElse(null);
	//	return null;
	//}

	
}
