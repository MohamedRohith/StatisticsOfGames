package com.spring.sports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.spring.sports.model.Game;
import com.spring.sports.repository.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository repository;
	public String checkLogin(String uname, String pwd) {
		Game user = repository.findByuname(uname);
		if(user ==null ) {
			return "no user found";
		}
		else
		{
			if(user.getPwd().equals(pwd)) {
				return "Login Successfu";
			}
			else
			{
				return "Login failed";
			}
		}
	}
	public Game addUser(Game game) {
		return repository.save(game);
	}
	public List<Game>getUser(){
		return repository.findAll();
	}
	public List<Game> paginationAndSorting(int pageNumber, int pageSize, String column_name){
		Page<Game> i =repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(column_name).ascending()));
		return i.getContent();
	}
	public List<Game> sortDescending(String field) {
		return repository.findAll(Sort.by(Direction.DESC,field));
	}
	public List<Game> sortAscending(String field) {
		return repository.findAll(Sort.by(Direction.ASC, field));
	}
	public List<Game>pagination(int pageNumber, int pageSize) {
		Page<Game> i=repository.findAll(PageRequest.of(pageNumber, pageSize));
		return i.getContent();
	}
	public List<Game>paginationAndSortingList(int pageNumber, int pageSize, String column_name) {
		Page<Game> i=repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(column_name).ascending()));
		return i.getContent();
	}
	

}
