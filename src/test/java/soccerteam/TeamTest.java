package soccerteam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TeamTest {

  private List<Player> players;
  private Team team;
  private String res;

  @Before
  public void setUp() {
    // Initialize a list of players to use in the tests
    players = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      players.add(new Player("FirstNameGOALIE" + i, "LastNameGOALIE" + i, new Date(), Position.GOALIE, i));
      players.add(new Player("FirstNameDEFENDER" + i, "LastNameDEFENDER" + i, new Date(), Position.DEFENDER, i));
      players.add(new Player("FirstNameMIDFIELDER" + i, "LastNameMIDFIELDER" + i, new Date(), Position.DEFENDER, i));
      players.add(new Player("FirstNameFORWARD" + i, "LastNameFORWARD" + i, new Date(), Position.FORWARD, i));
    }
    team = new Team(20, players);
    StringBuilder playerList = new StringBuilder();
    for (Player player : players) {
      playerList.append(player.getFirstName()).append(" ").append(player.getLastName()).append(" ").append(player.getJerseyNumber()).append("\n");
    }
    res = playerList.toString();
  }

  @Test
  public void testTeamConstructorError() {
    String errorMessage = "";
    try {
      new Team(9, new ArrayList<>());
    } catch (Exception e){
      errorMessage = e.getMessage();
    }
    assertEquals("A team must have at least 10 players", errorMessage);
  }

  @Test
  public void testTeamConstructor() {
    Team t = new Team(15, players);
    assertEquals(res, t.getPlayerList());
    List<Player> players2 = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      players2.add(new Player("FirstNameGOALIE" + i, "LastNameGOALIE" + i, new Date(), Position.GOALIE, i));
      players2.add(new Player("FirstNameDEFENDER" + i, "LastNameDEFENDER" + i, new Date(), Position.DEFENDER, i));
      players2.add(new Player("FirstNameMIDFIELDER" + i, "LastNameMIDFIELDER" + i, new Date(), Position.DEFENDER, i));
      players2.add(new Player("FirstNameFORWARD" + i, "LastNameFORWARD" + i, new Date(), Position.FORWARD, i));
    }
    players2.add(new Player("FirstNameGOALIE6", "LastNameGOALIE6", new Date(), Position.GOALIE, 2));
    players2.add(new Player("FirstNameDEFENDER6", "LastNameDEFENDER6", new Date(), Position.DEFENDER, 2));
    players2.add(new Player("FirstNameMIDFIELDER6", "LastNameMIDFIELDER6", new Date(), Position.DEFENDER, 2));
    players2.add(new Player("FirstNameFORWARD6", "LastNameFORWARD6", new Date(), Position.FORWARD, 2));
    t = new Team(24, players2);
    assertFalse(t.getPlayerList().contains("FirstNameGOALIE1") && t.getPlayerList().contains("LastNameGOALIE1"));
    assertFalse(t.getPlayerList().contains("FirstNameDEFENDER1") && t.getPlayerList().contains("FirstNameDEFENDER1"));
    assertFalse(t.getPlayerList().contains("FirstNameMIDFIELDER1") && t.getPlayerList().contains("FirstNameMIDFIELDER1"));
    assertFalse(t.getPlayerList().contains("FirstNameFORWARD1") && t.getPlayerList().contains("FirstNameFORWARD1"));
  }

  @Test
  public void testAddPlayer() {
    Player newPlayer = new Player("New", "Player", new Date(), Position.FORWARD, 5);
    team.addPlayer(newPlayer);
    assertTrue(team.getPlayerList().contains(newPlayer.getFirstName()) && team.getPlayerList().contains(newPlayer.getLastName()));
  }

  @Test
  public void testGenerateJerseyNumber() {
    team.generateJerseyNumber();
    String playerList = team.getPlayerList();
    // This test ensures jersey numbers are generated and assigned but cannot directly verify uniqueness or correctness
    assertFalse(playerList.contains(" 0\n"));
  }

  @Test
  public void testSelectStartingLineup() {
    team.selectStartingLineup();
    // The starting lineup should contain 7 players
    String[] startingLineup = team.getStartingLineup().split("\n");
    assertEquals("Starting lineup should contain 7 players", 7, startingLineup.length);
  }

  @Test
  public void testGetPlayerList() {
    String playerList = team.getPlayerList();
    assertNotNull(playerList);
    assertFalse(playerList.isEmpty());
    // Checking if the player list string contains details for the first player as a basic verification
    assertTrue(playerList.contains(players.get(0).getFirstName()) && playerList.contains(players.get(0).getLastName()));
  }

  @Test
  public void testGetStartingLineup() {
    team.selectStartingLineup();
    String startingLineup = team.getStartingLineup();
    assertNotNull(startingLineup);
    assertFalse(startingLineup.isEmpty());
    // Since selectStartingLineup is based on skill level, this verifies that a lineup is chosen but cannot directly assess skill-based selection
    assertEquals(7, startingLineup.split("\n").length);
  }
}