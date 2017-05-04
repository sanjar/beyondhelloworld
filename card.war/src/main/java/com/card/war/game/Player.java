package com.card.war.game;

public class Player {

	private String name;
	private int score = 0;
	
	public Player(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getScrore() {
		return score;
	}

	public void setScrore(int scrore) {
		this.score = scrore;
	}

	public boolean addPoints(int points) {
		score = score + points;
		System.out.println(name + " current score:" + score);
		return true;
	}
	
	
}
