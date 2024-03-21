package soccerteam;

import java.util.Date;

public class Player {
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private Position preferredPosition;
  private int skillLevel;
  private int jerseyNumber;

  public Player(String firstName, String lastName, Date dateOfBirth, Position preferredPosition, int sillLevel) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.preferredPosition = preferredPosition;
    this.skillLevel = sillLevel;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Position getPreferredPosition() {
    return preferredPosition;
  }

  public void setPreferredPosition(Position preferredPosition) {
    this.preferredPosition = preferredPosition;
  }

  public int getSkillLevel() {
    return skillLevel;
  }

  public void setSkillLevel(int sillLevel) {
    this.skillLevel = sillLevel;
  }

  public int getJerseyNumber() {
    return jerseyNumber;
  }

  public void setJerseyNumber(int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName + ", Date of birth: " + dateOfBirth + ", Position: " + preferredPosition;
  }
}
