package com.ITAcademy.DiceRoller_CRUD_Security_JWT.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player, Long>{

}
