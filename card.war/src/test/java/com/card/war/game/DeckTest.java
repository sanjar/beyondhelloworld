package com.card.war.game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	WarDeck deck = null;
	Player p, p2;
	List<Player> pList;

	@Before
	public void setUp() {
		p = new Player("p1");
		p2 = new Player("p2");
		pList = new ArrayList<Player>();
		pList.add(p);
		pList.add(p2);
		deck = new WarDeck( 2, pList);
		deck.create(4, 16);
	}

	@Test
	public void testCanCreateDeck() {
		assertNotNull(deck);
	}

	@Test
	public void testDeckSize() {
		assertEquals(64, deck.getDeckOfCards().size());
	}

	
	@Test
	public void testShuffle() throws Exception {
		int originalCard = deck.getDeckOfCards().get(5);
		deck.shuffle();
		int shuffledCard = deck.getDeckOfCards().get(5);
		assertNotEquals(originalCard, shuffledCard);
	}

	@Test
	public void testDeckDeal() throws Exception {
		int[][] deltDeckArray = deck.deal().getPlayerCardsArray();
		assertEquals(32, deltDeckArray.length);
	}
	
	
	@Test
	public void testGetNextCard() throws Exception {
		deck.shuffle();
		deck.deal();
		deck.getNextCards();
		
	}

}
