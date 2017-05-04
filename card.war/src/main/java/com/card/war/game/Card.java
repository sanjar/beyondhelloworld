package com.card.war.game;

public class Card  {

	private int[][] playerCardsArray;
	
	public Card(int[][] playerCardsArray){
		this.playerCardsArray = playerCardsArray;
	}

	public int[][] getPlayerCardsArray() {
		return playerCardsArray;
	}

}
