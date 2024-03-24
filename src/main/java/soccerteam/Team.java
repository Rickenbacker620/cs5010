package soccerteam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Team {
  private List<Player> activePlayers = new ArrayList<>();
  private List<Player> benchPlayers = new ArrayList<>();
  private List<Player> players = new ArrayList<>();

  public Team(int size, List<Player> players) {
    if (players.size() < 10) {
      throw new IllegalArgumentException("A team must have at least 10 players");
    }
    if (players.size() > 20) {
      players.sort(Comparator.comparingInt(Player::getSkillLevel));
      this.players = players.subList(0, 20);
    } else {
      this.players = players;
    }
  }

  public void addPlayer(Player player) {
    if (activePlayers.size() < 7) {
      activePlayers.add(player);
    } else {
      benchPlayers.add(player);
    }
  }
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
  public void selectStartingLineup(){
    activePlayers.clear();
    benchPlayers.clear();
    players.sort(Comparator.comparingInt(Player::getSkillLevel).reversed());
    for (int i=0;i<players.size();i++){
      if(i<7&&activePlayers.size()<7){
        activePlayers.add(players.get(i));
      }else {
        benchPlayers.add(players.get(i));
      }
    }
  }
  public String getPlayerList(){
    StringBuilder playerList = new StringBuilder();
    for (Player player : players) {
      playerList.append(player.getFirstName()).append(" ").append(player.getLastName()).append(" ").append(player.getJerseyNumber()).append("\n");
    }
    return playerList.toString();
  }
  public String getStartingLineup(){

  }
}
