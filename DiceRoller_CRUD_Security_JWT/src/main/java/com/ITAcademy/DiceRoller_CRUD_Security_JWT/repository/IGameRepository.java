
package com.ITAcademy.DiceRoller_CRUD_Security_JWT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Game;
import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;

@Repository
public interface IGameRepository extends JpaRepository<Game, Long> {

	// List all games from player
	List<Game> findAllByPlayer(Player player);
}
