package com.card.war.game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WarAppTest {
	
	War war, war2;
	Player p, p2;
	List<Player> pList;
	
	@Before
	public void setUp(){
		war = new War();
		p = new Player("p1");
		p2 = new Player("p2");
		pList = new ArrayList<Player>();
		pList.add(p);
		pList.add(p2);	
	}

	@Test
	public void VisualTest() {
		war.getPlayerList().addAll(pList);
		war.play(4, 16, 2);
	}

	@Test
	public void testCreatePlayer() throws Exception {
		war2 = new War();
		war2.createPlayerAndAddToList("p1");
		war2.createPlayerAndAddToList("p2");		
		assertEquals("p2", war2.getPlayerList().get(1).getName());
	}
	
}
