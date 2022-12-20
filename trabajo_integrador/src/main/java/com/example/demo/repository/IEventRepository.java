package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event,Long>{
	
	public Event findByCreateDate(LocalDateTime createDate);
	
	public List<Event> findByNameEvent(String nameEvent);
	
	public Event findByNameEventAndActivityTrue(String nameEvent);
}
