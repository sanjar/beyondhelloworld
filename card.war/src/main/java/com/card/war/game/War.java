package com.card.war.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class War {

	private List<Player> playerList;

	
	public static void main(String[] args) {
		War w = new War();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of players: ");
		int numPlayers = Integer.valueOf(scan.nextLine());
		for (int i = 0; i < numPlayers; i++) {
			System.out.println("Enter players name: ");
			String nameIn = scan.nextLine();
			w.createPlayerAndAddToList(nameIn);
		}
		System.out.println("Enter number of Suits: ");
		int numSuits = Integer.valueOf(scan.nextLine());
		System.out.println("Enter number of Ranks: ");
		int numRanks = Integer.valueOf(scan.nextLine());
		scan.close();

		w.play(numSuits, numRanks, numPlayers);
	}

	public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {
		WarDeck deck = new WarDeck(numberOfPlayers, playerList);
		deck.create(numberOfSuits, numberOfRanks);
		deck.shuffle();
		deck.deal();
		boolean looper = true;
		while (looper) {
			looper = deck.getNextCards();
		}
		System.out.println(deck.getWinner());
	}

	public Player createPlayerAndAddToList(String name) {
		Player wp = new Player(name);
		if(playerList == null){
			playerList = new ArrayList<Player>();
		}
		playerList.add(wp);
		return wp;
	}

	public List<Player> getPlayerList() {
		if(playerList == null){
			playerList = new ArrayList<Player>();
		}
		return playerList;
	}
	
	

}
