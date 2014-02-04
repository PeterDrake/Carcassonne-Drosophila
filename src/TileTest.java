import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class TileTest {

	@Test
	public void testConstructor() {
		Tile tile = new Tile(0, 0, 0, 0, 0, "name");
		assertEquals(0, tile.getNorth());
		assertEquals(0, tile.getEast());
		assertEquals(0, tile.getSouth());
		assertEquals(0, tile.getWest());
		assertEquals(0, tile.getCenter());
		assertTrue(!tile.hasMeeple());
		assertEquals(0, tile.Orientation());
		assertEquals("name", tile.getFileName());
	}
	
	@Test
	public void testFileName() {
		Tile testTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD, "city1rwe.png");
		File file = new File(testTile.getFileName());
		assertTrue(file.exists());
	}

	
}
