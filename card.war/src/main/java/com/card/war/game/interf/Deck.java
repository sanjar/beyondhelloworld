package com.card.war.game.interf;

import com.card.war.game.Card;

public interface Deck {

	public void create(int numberOfSuits, int numberOfRanks);
	public void shuffle();
	public Card deal();
}
