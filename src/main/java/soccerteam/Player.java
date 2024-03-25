package soccerteam;

import java.util.Date;

/**
 * Class that describe a player
 */
public class Player {
  private String firstName;
  private String lastName;
  private Date dateOfBirth;
  private Position preferredPosition;
  private int skillLevel;
  private int jerseyNumber;

  /**
   * Constructor.
   * @param firstName is the first name of the player.
   * @param lastName is the last name of the player.
   * @param dateOfBirth is the date of birth of the player.
   * @param preferredPosition is the preferred position of the player.
   * @param sillLevel is the skill level of the player.
   */
  public Player(String firstName, String lastName, Date dateOfBirth, Position preferredPosition, int sillLevel) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.preferredPosition = preferredPosition;
    this.skillLevel = sillLevel;
  }

  /**
   * Get the first name of the player.
   * @return the first name of the player.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the player.
   * @param firstName is the first name of the player.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Get the last name of the player.
   * @return the last name of the player.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of the player.
   * @param lastName is the last name of the player.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Get the date of birth of the player.
   * @return the date of birth of the player.
   */
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Set the date of birth of the player.
   * @param dateOfBirth is the date of birth of the player.
   */
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  /**
   * Get the preferred position of the player.
   * @return the preferred position of the player.
   */
  public Position getPreferredPosition() {
    return preferredPosition;
  }

  /**
   * Set the preferred position of the player.
   * @param preferredPosition is the preferred position of the player.
   */
  public void setPreferredPosition(Position preferredPosition) {
    this.preferredPosition = preferredPosition;
  }

  /**
   * Get the skill level of the player.
   * @return the skill level of the player.
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Set the skill level of the player.
   * @param sillLevel is the skill level of the player.
   */
  public void setSkillLevel(int sillLevel) {
    this.skillLevel = sillLevel;
  }

  /**
   * Get the jersey number of the player.
   * @return the jersey number of the player.
   */
  public int getJerseyNumber() {
    return jerseyNumber;
  }

  /**
   * Set the jersey number of the player.
   * @param jerseyNumber is the jersey number of the player.
   */
  public void setJerseyNumber(int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  /**
   * Return the player's information.
   * @return the player's information.
   */
  @Override
  public String toString() {
    return firstName + " " + lastName + ", Date of birth: " + dateOfBirth + ", Position: " + preferredPosition;
  }
}
