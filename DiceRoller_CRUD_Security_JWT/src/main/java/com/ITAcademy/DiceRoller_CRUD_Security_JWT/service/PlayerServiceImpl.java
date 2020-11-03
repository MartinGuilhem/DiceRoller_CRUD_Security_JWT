package com.ITAcademy.DiceRoller_CRUD_Security_JWT.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dao.IPlayerDAO;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;

@Service
public class PlayerServiceImpl implements IPlayerService {

	// Use of methods from repository DAO
	@Autowired
	IPlayerDAO iPlayerDAO;

	// Create player
	@Override
	public Player createPlayer(Player player) {
		return iPlayerDAO.save(player);
	}

	// Get all players with their winAvg
	@Override
	public List<Player> listPlayers() {
		return iPlayerDAO.findAll();
	}
	
	// Get player by id
	@Override
	public Player getPlayer(Long id) {
		return iPlayerDAO.findById(id).get();
	}
	
	// Update player
	@Override
	public Player updatePlayer(Player player) {
		return iPlayerDAO.save(player);
	}
	
	// Get total ranking of all players
	@Override
	public Double getRanking(List<Player> players) {
		double ranking=0.00;
		double sumRanking=0.00;
		for (int i=0;i<players.size();i++) {
			ranking=players.get(i).getWinAvg();
			sumRanking = sumRanking + ranking;
		}
		return sumRanking / (double) players.size();
	}

	// Get player with lowest ranking
	@Override
	public Player Loser() {
		List<Player> players = this.listPlayers();
		Long id = null;
		double min = 100.00;
		for (int i=0;i<players.size();i++) {
			if (players.get(i).getWinAvg() < min) {
				min = players.get(i).getWinAvg();
				id = players.get(i).getId();
				System.out.println("\n\n### min= "+min+"id= "+id+"\n\n");
			}

		}
		return this.getPlayer(id);
	}

	// Get player with highest ranking
	@Override
	public Player Winner() {
		List<Player> players = this.listPlayers();
		Long id = null;
		double max = 0.00;
		for (int i=0;i<players.size();i++) {
			if (players.get(i).getWinAvg() > max) {
				max = players.get(i).getWinAvg();
				id = players.get(i).getId();
				System.out.println("\n\n### max= "+max+"id= "+id+"\n\n");
			}
		}
		return this.getPlayer(id);
	}

	// Delete player by id
	@Override
	public void deletePlayer(Long id) {
		iPlayerDAO.deleteById(id);
	}	
	
	// Delete all players and games
	@Override
	public void deletePlayers() {
		iPlayerDAO.deleteAll();
	}

}
