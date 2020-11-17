package com.ITAcademy.DiceRoller_CRUD_Security_JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long>{

	Player findByName(String name);

}
