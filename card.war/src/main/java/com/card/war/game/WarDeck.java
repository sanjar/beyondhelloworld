package com.card.war.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.card.war.game.interf.Deck;

public class WarDeck implements Deck{
	
	private int totalCards;
	private List<Integer> deckOfCards;
	private int numberOfPlayers;
	private int eachPlayerCardCount;
	private int[][] playerCardsArray;
	private int currentDeckPosition = 0; // starts at zero and moves to end of each
	private List<Player> players;
	private int points;
	private int winningPlayer = 0;
	
	public WarDeck(int numberOfPlayers, List<Player> players) {
		this.numberOfPlayers = numberOfPlayers;
		this.players = players;
	}

	public void create(int numberOfSuits, int numberOfRanks) {
		// this.numberOfRanks = numberOfRanks;
		this.totalCards = numberOfSuits * numberOfRanks;
		
		// For each suit put a sequence up to the user defined ranks
		deckOfCards = new ArrayList<Integer>();
		for (int i = 0; i < numberOfSuits; i++) {
			for (int s = 0; s < numberOfRanks; s++) {
				deckOfCards.add(s + 1);
			}
		}
		System.out.println("Deck has been created with " + numberOfSuits + " suits and " + numberOfRanks + " ranks!");
	}

	public void shuffle() {
		Collections.shuffle(deckOfCards);
		System.out.println("Deck has been shuffled");
	}

	public Card deal() {
		eachPlayerCardCount = totalCards / numberOfPlayers;
		playerCardsArray = new int[eachPlayerCardCount][numberOfPlayers];
		// loop through shuffled deck and place cards into an array column for each player
		int position = 0;
		for (int i = 0; i < eachPlayerCardCount; i++) {
			for (int z = 0; z < numberOfPlayers; z++) {
				playerCardsArray[i][z] = deckOfCards.get(position);
				position++;
			}
		}
		System.out.println("cards have been dealt to all " + numberOfPlayers + " players!");
		return new Card(playerCardsArray);
	}

	public List<Integer> getDeckOfCards() {
		return deckOfCards;
	}

	public boolean getNextCards() {
		// make sure there is enough cards to do another round
		if (currentDeckPosition > (eachPlayerCardCount - numberOfPlayers)) {
			return false;
		}
		winningPlayer = compareCards();
		players.get(winningPlayer).addPoints(points);
		// reset points to base
		points = 2;
		currentDeckPosition++;
		return true;
	}

	public String getWinner() {
		String scoreOut = "";
		int winner = 0;
		int startScore = 0;
		int playerScore =0;
		for (int i = 0; i < numberOfPlayers; i++) {
			if (playerScore == startScore){
				scoreOut = "There has been a Tie!!!";
			}
			playerScore = players.get(i).getScrore();
			System.out.println(players.get(i).getName() + " score is " + playerScore);
			if (playerScore > startScore) {
				winner = i;
				startScore = playerScore;
			}
			scoreOut = players.get(winner).getName() + " is the winner!";
		
		}
		return scoreOut;
	}

	public int compareCards() {
		// read each players cards and pick winner
		int winner = 0;
		// int player;
		points = numberOfPlayers;
		int baseScore = 0;

		for (int player = 0; player < numberOfPlayers; player++) {
			int cardValue = playerCardsArray[currentDeckPosition][player];
			System.out.println(players.get(player).getName() + " card is " + cardValue);
			if (cardValue == baseScore) {
				System.out.println("cards match WAR!!");
				for (int playerB = 0; playerB < numberOfPlayers; playerB++) {
					if(currentDeckPosition+2< eachPlayerCardCount){
						cardValue = playerCardsArray[currentDeckPosition + 2][playerB];
						if (cardValue > baseScore) {
							winner = playerB;
							baseScore = cardValue;
						}
					}
				}
				currentDeckPosition = currentDeckPosition + 2; // update position in deck war points will be higher
				points = points + (numberOfPlayers * 2); // additional war
															// points
			}
			if (cardValue > baseScore) {
				winner = player;
				baseScore = cardValue;
			}
			// points = points + numberOfPlayers; //default points
		}
		// if cards match go down 2 cards for each player
		currentDeckPosition++;
		System.out.println(players.get(winner).getName() + " wins this turn.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return winner;
	}

}
