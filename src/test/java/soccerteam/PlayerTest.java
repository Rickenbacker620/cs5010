package soccerteam;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        this.player = new Player("John", "Doe", new Date(), Position.FORWARD, 10);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("John", player.getFirstName());
    }
}
