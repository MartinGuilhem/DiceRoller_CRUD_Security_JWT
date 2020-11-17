package com.ITAcademy.DiceRoller_CRUD_Security_JWT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Game;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.repository.IGameRepository;

@Service
public class GameServiceImpl implements IGameService {

	// Use of methods from repository Repository
	@Autowired
	IGameRepository iGameRepository;
	@Autowired 
	PlayerServiceImpl playerServiceImpl;

	// Create Game
	@Override
	public Game addGame(Game game) {
		return iGameRepository.save(game);
	}
	
	// GET game By ID
	@Override
	public Game getGameById(Long gameId) {
		return iGameRepository.findById(gameId).get();
	}
		
	// Get games from player
	@Override
	public List<Game> listGames(Player player) {
		return iGameRepository.findAllByPlayer(player);
	}

	// Delete Game
	@Override
	public void deleteGame(Long gameId) {
		iGameRepository.deleteById(gameId);
	}
	
	// Roll the dices
	@Override
	public Long rollDices(Player player) {		
		int dice1=(int) (Math.random()*(6-1+1)+1); 
		int dice2=(int) (Math.random()*(6-1+1)+1); 
		boolean won=won(dice1, dice2);
		
		Game game = new Game(null, dice1, dice2, won, player);
		this.addGame(game);
		player.setGame(game);
		updateWinAvGames(player);
		playerServiceImpl.updatePlayer(player);
		return game.getId();
	}
	
	// SETTING WINAVG FROM GAME
	@Override
	public void updateWinAvGames(Player player) {
		int gamesWon = 0;
		List<Game> games = listGames(player);
		for (int i=0;i<games.size();i++) { 
			if(games.get(i).isWon())
				gamesWon++;
		}
		double winAverage=(double) gamesWon / (double) games.size();
		player.setWinAvg(winAverage);
	}
	
	// Win or Not
	@Override
	public boolean won(int dice1, int dice2) {
		if(dice1+dice2==7) 
			return true;		
		else 
			return false;
	}

	// Delete all games
	@Override
	public void deleteGames() {
		iGameRepository.deleteAll();		
	}
}
