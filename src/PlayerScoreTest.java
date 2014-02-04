import static org.junit.Assert.*;
import org.junit.Test;
public class PlayerScoreTest {
	
	@Test
	public void testGetScore(){
		Player p = new Player();
		assertEquals(0, p.getScore());
	}
	
	@Test
	public void testAddPointsToScore(){
		Player p = new Player();
		assertEquals(0, p.getScore());
		p.addPointsToScore(5);
		assertEquals(5, p.getScore());
	}
	
}
