package soccerteam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
  }
}
