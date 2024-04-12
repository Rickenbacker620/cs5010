package soccerteam;

public class Driver {
  SoccerTeamView view = new SoccerTeamView();
  TeamController tc = new TeamController(view);
  PlayerController pc = new PlayerController(view);

}
