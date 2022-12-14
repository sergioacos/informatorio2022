package com.example.demo.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EventDto;
import com.example.demo.entity.Event;
import com.example.demo.entity.Turn;

@Repository
public interface ITurnRepository extends JpaRepository<Turn,Long> {
	public Turn findByCreateDate(LocalDateTime createDate);
	public Turn findbyEventAndOrganization(Turn turn);
	public Turn findByKey(String keyturn);
}
