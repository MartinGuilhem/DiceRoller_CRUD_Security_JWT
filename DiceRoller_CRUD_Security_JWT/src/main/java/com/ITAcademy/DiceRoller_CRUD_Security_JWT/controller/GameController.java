package com.ITAcademy.DiceRoller_CRUD_Security_JWT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Game;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.service.GameServiceImpl;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.service.PlayerServiceImpl;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class GameController {
	
	// Use of methods from Service
	@Autowired
	GameServiceImpl gameServiceImpl;
	@Autowired
	PlayerServiceImpl playerServiceImpl;

	
	// PLAYER {ID} ROLLS THE DICES (CREATE GAME)
 	@PostMapping("/players/{id}/games")
 	public Game rollTheDices(@PathVariable(name ="id") Long id) {
 		Player player = playerServiceImpl.getPlayer(id);
 		Long gameId=gameServiceImpl.rollDices(player);
 		return gameServiceImpl.getGameById(gameId);	 		
 	}
	 	
	// GET GAMES FROM PLAYER
	@GetMapping("/players/{id}/games")
	public List<Game> listGames(@PathVariable(name = "id") Player player) {
		return gameServiceImpl.listGames(player);
	}
	
	// DELETE ALL GAMES FROM PLAYER
	@DeleteMapping("/players/{id}/games")
	public String deleteGames(@PathVariable(name = "id") Player player) {
		List<Game> games = player.getGame();
		for (Game g : games) {
			Long gameId = g.getId();
			gameServiceImpl.deleteGame(gameId);
		}
		player.setWinAvg(0.00);
		playerServiceImpl.updatePlayer(player);			
		return "\n Games from " + player.getName() + " have been deleted";
	}

}
