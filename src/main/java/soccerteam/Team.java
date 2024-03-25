package soccerteam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Class that describe a Team
 */
public class Team {
  private List<Player> activePlayers = new ArrayList<>();
  private List<Player> benchPlayers = new ArrayList<>();
  private List<Player> players = new ArrayList<>();

  /**
   * Constructor of the class. Initialize the size and players. Throw exception when the size is
   * invalid
   * @param size input size of the team
   * @param players input players of the team
   * @throws IllegalArgumentException when size is smaller than 10 and bigger than 20
   */
  public Team(int size, List<Player> players) throws IllegalArgumentException {
    if (players.size() < 10) {
      throw new IllegalArgumentException("A team must have at least 10 players");
    }
    if (players.size() > 20) {
      players.sort(Comparator.comparingInt(Player::getSkillLevel).reversed());
      this.players = players.subList(0, 20);
    } else {
      this.players = players;
    }
  }

  /**
   * Method to add one player into the team
   * @param player input player to be added
   */
  public void addPlayer(Player player) {
    if (activePlayers.size() < 7) {
      activePlayers.add(player);
    } else {
      benchPlayers.add(player);
    }
  }

  /**
   * Method to randomly generate jersey number for players
   */
  public void generateJerseyNumber() {
    Set<Integer> assignJerseyNumbers=new HashSet<>();
    Random random = new Random();
    for (Player player : players) {
      int jerseyNumber;
      do {
        jerseyNumber = random.nextInt(20) + 1;
      } while (!assignJerseyNumbers.add(jerseyNumber));
      player.setJerseyNumber(jerseyNumber);
    }
  }

  /**
   * Method to generate the starting line players. Compare the players in the team by their skill
   * level. Put the players with better skill level to the line
   */
  public void selectStartingLineup(){
    activePlayers.clear();
    benchPlayers.clear();
    players.sort(Comparator.comparingInt(Player::getSkillLevel).reversed());
    for (int i=0;i<players.size();i++){
      if(i<7&&activePlayers.size()<7){
        activePlayers.add(players.get(i));
      } else {
        benchPlayers.add(players.get(i));
      }
    }
  }

  /**
   * Method to generate the list of players in string. In format of a space in between first name,
   * last name, jersey number and a new line after each player
   * @return string of players in the team
   */
  public String getPlayerList(){
    StringBuilder playerList = new StringBuilder();
    for (Player player : players) {
      playerList.append(player.getFirstName()).append(" ").append(player.getLastName()).append(" ").append(player.getJerseyNumber()).append("\n");
    }
    return playerList.toString();
  }

  /**
   * Method to generate the list of start line players in string. In format of a space in between
   * first name, last name, jersey number and a new line after each player
   * @return string of start line players in the team
   */
  public String getStartingLineup(){
    StringBuilder playerList = new StringBuilder();
    for (Player player : activePlayers) {
      playerList.append(player.getFirstName()).append(" ").append(player.getLastName()).append(" ").append(player.getJerseyNumber()).append("\n");
    }
    return playerList.toString();
  }
}
