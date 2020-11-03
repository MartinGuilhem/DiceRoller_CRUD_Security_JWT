package com.ITAcademy.DiceRoller_CRUD_Security_JWT.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	int dice1;
	@Column
	int dice2;
	@Column
	boolean won;
	
	// Entities relationship
	@ManyToOne()
	@JoinColumn(name = "player_id")
	private Player player;
	
	// CONSTRUCTORS
	public Game() {}

	public Game(Long id, int dice1, int dice2, boolean won, Player player) {
		this.id = id;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.won = won;
		this.player = player;
	}

	// GETTERS AND SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDice1() {
		return dice1;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Game [ dice1=" + dice1 + ", dice2=" + dice2 + ", Win?=" + won + ", player=" + player
				+ "]";
	}

}
