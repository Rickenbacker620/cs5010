package soccerteam;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Player class
 */
public class PlayerTest {
  private Player player;
  private LocalDate dateOfBirth = Utils.genBirthDate();

  /**
   * Set up for all tests.
   */
  @Before
  public void setUp() {
    this.player = new Player("John", "Doe", dateOfBirth, Position.FORWARD, 5);
  }

  /**
   * Test the constructor with invalid age
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNewPlayerOverAge() {
    new Player("John", "Doe", LocalDate.now().minusYears(20), Position.FORWARD, 1);
  }

  /**
   * Test the constructor with invalid skill level
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNewPlayerWithIllegalSkillLevel() {
    new Player("John", "Doe", LocalDate.now().minusYears(10), Position.FORWARD, 6);
  }

  /**
   * Test the getFirstName method
   */
  @Test
  public void testGetFirstName() {
    Assert.assertEquals("John", player.getFirstName());
  }

  /**
   * Test the getLastName method
   */
  @Test
  public void testGetLastName() {
    Assert.assertEquals("Doe", player.getLastName());
  }

  /**
   * Test the getDateOfBirth method
   */
  @Test
  public void testGetDateOfBirth() {
    Assert.assertEquals(dateOfBirth, player.getDateOfBirth());
  }

  /**
   * Test the getPreferredPosition method
   */
  @Test
  public void testGetPreferredPosition() {
    Assert.assertEquals(Position.FORWARD, player.getPreferredPosition());
  }

  /**
   * Test the getSkillLevel method
   */
  @Test
  public void testGetSkillLevel() {
    Assert.assertEquals(5, player.getSkillLevel());
  }

  /**
   * Test the setFirstName method
   */
  @Test
  public void testSetFirstName() {
    player.setFirstName("FirstName");
    Assert.assertEquals("FirstName", player.getFirstName());
  }

  /**
   * Test the setLastName method
   */
  @Test
  public void testSetLastName() {
    player.setLastName("LastName");
    Assert.assertEquals("LastName", player.getLastName());
  }

  /**
   * Test the setDateOfBirth method
   */
  @Test
  public void testSetDateOfBirth() {
    LocalDate dateOfBirthNew = dateOfBirth.plusYears(1);
    player.setDateOfBirth(dateOfBirthNew);
    Assert.assertEquals(dateOfBirthNew, player.getDateOfBirth());
  }

  /**
   * Test the setPreferredPosition method
   */
  @Test
  public void testSetPreferredPosition() {
    player.setPreferredPosition(Position.DEFENDER);
    Assert.assertEquals(Position.DEFENDER, player.getPreferredPosition());
  }

  /**
   * Test the setSkillLevel method
   */
  @Test
  public void testSetSkillLevel() {
    player.setSkillLevel(4);
    Assert.assertEquals(4, player.getSkillLevel());
  }

  /**
   * Test the setJerseyNumber method
   */
  @Test
  public void testSetJerseyNumber() {
    player.setJerseyNumber(7);
    Assert.assertEquals(7, player.getJerseyNumber());
  }

  /**
   * Test the getJerseyNumber method
   */
  @Test
  public void testGetJerseyNumber() {
    player.setJerseyNumber(7);
    Assert.assertEquals(7, player.getJerseyNumber());
  }

  /**
   * Test the toString method
   */
  @Test
  public void testToString() {
    Assert.assertEquals(player.toString(), "John Doe, Date of birth: " + dateOfBirth + ", Position: FORWARD");
  }
}
