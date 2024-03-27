package soccerteam;

import java.util.ArrayList;
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
      players.add(new Player("FirstNameGOALIE" + i, "LastNameGOALIE" + i, Utils.genBirthDate(), Position.GOALIE, i));
      players
          .add(new Player("FirstNameDEFENDER" + i, "LastNameDEFENDER" + i, Utils.genBirthDate(), Position.DEFENDER, i));
      players.add(
          new Player("FirstNameMIDFIELDER" + i, "LastNameMIDFIELDER" + i, Utils.genBirthDate(), Position.DEFENDER, i));
      players.add(new Player("FirstNameFORWARD" + i, "LastNameFORWARD" + i, Utils.genBirthDate(), Position.FORWARD, i));
    }
    team = new Team(20, players);
    StringBuilder playerList = new StringBuilder();
    for (Player player : players) {
      playerList.append(player.getFirstName()).append(" ").append(player.getLastName()).append(" ")
          .append(player.getJerseyNumber()).append("\n");
    }
    res = playerList.toString();
  }

  @Test
  public void testTeamConstructorError() {
    String errorMessage = "";
    try {
      new Team(9, new ArrayList<>());
    } catch (Exception e) {
      errorMessage = e.getMessage();
    }
    assertEquals("A team must have at least 10 players", errorMessage);
  }

  @Test
  public void testTeamConstructor() {
    Team t = new Team(20, players);
    assertEquals(res, t.getPlayerList());
    List<Player> players2 = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      players2.add(new Player("FirstNameGOALIE" + i, "LastNameGOALIE" + i, Utils.genBirthDate(), Position.GOALIE, i));
      players2
          .add(new Player("FirstNameDEFENDER" + i, "LastNameDEFENDER" + i, Utils.genBirthDate(), Position.DEFENDER, i));
      players2.add(
          new Player("FirstNameMIDFIELDER" + i, "LastNameMIDFIELDER" + i, Utils.genBirthDate(), Position.DEFENDER, i));
      players2
          .add(new Player("FirstNameFORWARD" + i, "LastNameFORWARD" + i, Utils.genBirthDate(), Position.FORWARD, i));
    }
    players2.add(new Player("FirstNameGOALIE6", "LastNameGOALIE6", Utils.genBirthDate(), Position.GOALIE, 2));
    players2.add(new Player("FirstNameDEFENDER6", "LastNameDEFENDER6", Utils.genBirthDate(), Position.DEFENDER, 2));
    players2.add(new Player("FirstNameMIDFIELDER6", "LastNameMIDFIELDER6", Utils.genBirthDate(), Position.DEFENDER, 2));
    players2.add(new Player("FirstNameFORWARD6", "LastNameFORWARD6", Utils.genBirthDate(), Position.FORWARD, 2));
    t = new Team(24, players2);
    assertFalse(t.getPlayerList().contains("FirstNameGOALIE1") && t.getPlayerList().contains("LastNameGOALIE1"));
    assertFalse(t.getPlayerList().contains("FirstNameDEFENDER1") && t.getPlayerList().contains("FirstNameDEFENDER1"));
    assertFalse(
        t.getPlayerList().contains("FirstNameMIDFIELDER1") && t.getPlayerList().contains("FirstNameMIDFIELDER1"));
    assertFalse(t.getPlayerList().contains("FirstNameFORWARD1") && t.getPlayerList().contains("FirstNameFORWARD1"));
  }

  @Test
  public void testAddPlayer() {
    Player newPlayer = new Player("New", "Player", Utils.genBirthDate(), Position.FORWARD, 5);
    team.addPlayer(newPlayer);
    assertTrue(team.getPlayerList().contains(newPlayer.getFirstName())
        && team.getPlayerList().contains(newPlayer.getLastName()));
  }

  @Test
  public void testGenerateJerseyNumber() {
    team.generateJerseyNumber();
    String playerList = team.getPlayerList();
    assertTrue(playerList.contains(" 1\n") && playerList.contains(" 2\n") &&
            playerList.contains(" 3\n") && playerList.contains(" 4\n") && playerList.contains(" 5\n") &&
            playerList.contains(" 6\n") && playerList.contains(" 7\n") && playerList.contains(" 8\n") &&
            playerList.contains(" 9\n") && playerList.contains(" 10\n") && playerList.contains(" 11\n") &&
            playerList.contains(" 12\n") && playerList.contains(" 13\n") && playerList.contains(" 14\n") &&
            playerList.contains(" 15\n") && playerList.contains(" 16\n") && playerList.contains(" 17\n") &&
            playerList.contains(" 18\n") && playerList.contains(" 19\n") && playerList.contains(" 20\n"));
  }

  @Test
  public void testSelectAndGetStartingLineup() {
    team.selectStartingLineup();
    String[] startingLineup = team.getStartingLineup().split("\n");
    assertEquals("Starting lineup should contain 7 players", 7, startingLineup.length);
    assertFalse(team.getStartingLineup().contains("1") || team.getStartingLineup().contains("2") || team.getStartingLineup().contains("3"));
  }

  @Test
  public void testGetPlayerList() {
    String playerList = team.getPlayerList();
    assertNotNull(playerList);
    assertFalse(playerList.isEmpty());
    assertEquals(res, playerList);
  }
}