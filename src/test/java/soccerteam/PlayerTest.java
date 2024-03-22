package soccerteam;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Player class
 */
public class PlayerTest {
    private Player player;

    /**
     * Set up for all tests.
     */
    @Before
    public void setUp() {
        this.player = new Player("John", "Doe", new Date(), Position.FORWARD, 5);
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
        Assert.assertEquals(new Date(), player.getDateOfBirth());
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
        Date date = new Date();
        player.setDateOfBirth(date);
        Assert.assertEquals(date, player.getDateOfBirth());
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
        Assert.assertEquals(player.toString(), "John Doe, Date of birth: " + new Date() + ", Position: FORWARD");
    }
}
