package com.example.demo.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event,Long>{
	public Event findByCreateDate(LocalDateTime createDate);
}
