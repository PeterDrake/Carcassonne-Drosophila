import static org.junit.Assert.*;

import org.junit.Test;


public class TileTest {

	@Test
	public void testConstructor() {
		Tile tile = new Tile(0, 0, 0, 0, 0);
		assertEquals(0, tile.getNorth());
		assertEquals(0, tile.getEast());
		assertEquals(0, tile.getSouth());
		assertEquals(0, tile.getWest());
		assertEquals(0, tile.getCenter());
		assertTrue(!tile.hasMeeple());
		assertEquals(0, tile.Orientation());
	}

	
}
