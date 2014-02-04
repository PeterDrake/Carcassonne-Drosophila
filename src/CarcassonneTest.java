import static org.junit.Assert.*;

import org.junit.Test;


public class CarcassonneTest {

	
	private Tile[] tilesTest;
	private Carcassonne carcassonne;
	@Test
	public void testInitialTileDistribution() {
		carcassonne= new Carcassonne();
		tilesTest=carcassonne.getTiles();
		
		
		assertEquals(0, tilesTest[0].getNorth());
		assertEquals(0, tilesTest[0].getEast());
		assertEquals(0, tilesTest[0].getSouth());
		assertEquals(0, tilesTest[0].getWest());
		assertEquals(4, tilesTest[0].getCenter());
		
		assertEquals(1, tilesTest[70].getNorth());
		assertEquals(1, tilesTest[70].getEast());
		assertEquals(1, tilesTest[70].getSouth());
		assertEquals(1, tilesTest[70].getWest());
		assertEquals(3, tilesTest[70].getCenter());
	}

}
