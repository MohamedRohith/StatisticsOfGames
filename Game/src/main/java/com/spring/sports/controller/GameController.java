package com.spring.sports.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sports.model.Game;
import com.spring.sports.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GameService service;
	@PostMapping("/login")
	public String Login(@RequestBody Map<String, String> loginData) {
		String uname = loginData.get("uname");
		String pwd = loginData.get("pwd");
		String result = service.checkLogin(uname, pwd);
		return result;
	}
	@PostMapping("/adduser")
	public Game Adduser(@RequestBody Game game) {
		return service.addUser(game);
	}
	@GetMapping
	public List<Game> listAll(){
		return service.getUser();
	}
	@GetMapping(value = "/sort/desc/{column_value}")
	public List<Game> descendingOrder(@PathVariable(value = "column_value") String column_value) {
		return service.sortDescending(column_value);
	}
	@GetMapping(value = "/sort/asc/{name}")
	public List<Game> ascendingOrder(@PathVariable(value = "name") String name) {
		return service.sortAscending(name);
	}
	@GetMapping(value = "/pagination/{pnu}/{psize}")
	public List<Game> pagination(@PathVariable(value = "pnu") int pnu,@PathVariable(value = "psize") int psize)  {
		return service.pagination(pnu,psize);
	}
	@GetMapping(value = "/pands/{pnu}/{psize}/{column_value}")
	public List<Game> paginationData(@PathVariable(value = "pnu") int pnu,@PathVariable(value = "psize") int psize, @PathVariable(value = "column_value") String column_value)  {
		return service.paginationAndSorting(pnu,psize,column_value);
	}
	

}
