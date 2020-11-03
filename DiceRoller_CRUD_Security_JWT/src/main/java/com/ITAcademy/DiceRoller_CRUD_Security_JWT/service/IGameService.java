package com.ITAcademy.DiceRoller_CRUD_Security_JWT.service;

import java.util.List;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Game;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;

public interface IGameService {
	// Create Game
		public Game addGame(Game game);
		
		// Get game By ID
		public Game getGameById(Long gameId);
		
		// Get games from player
		public List<Game> listGames(Player player);

		// Delete Game
		public void deleteGame(Long gameId);
		
		// Delete all games
		public void deleteGames();
		
		// Roll the dices
		public Long rollDices(Player player);
		
		// Win or Not 
		public boolean won(int dice1, int dice2);

		void updateWinAvGames(Player player);

}
