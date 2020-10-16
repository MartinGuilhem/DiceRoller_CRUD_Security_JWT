
package com.ITAcademy.DiceRoller_CRUD_Security_JWT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Game;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;

public interface IGameDAO extends JpaRepository<Game, Long> {

	// List all games from player
	List<Game> findAllByPlayer(Player player);
}
