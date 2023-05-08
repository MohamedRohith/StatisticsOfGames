package com.spring.sports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.sports.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer>{
	Game findByuname(String uname);

}
