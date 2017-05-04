package com.card.war.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WarPlayerTest {

	Player p;

	@Before
	public void setUP() {
		p = new Player("p1");
	}

	@Test
	public void testPlayerName() {
		assertEquals("p1", p.getName());
	}
	
	@Test
	public void testSetPlayerScore() throws Exception {
		p.setScrore(10);
		assertEquals(10,p.getScrore());
	}

}
