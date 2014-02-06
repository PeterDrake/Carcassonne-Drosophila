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
	
	@Test
	public void testRotation() {
		Tile tile = new Tile(0,1,2,3,0);
		tile.rotate();
		assertEquals(3, tile.getNorth());
		assertEquals(0, tile.getEast());
		assertEquals(1, tile.getSouth());
		assertEquals(2, tile.getWest());
		tile.rotate();
		assertEquals(2, tile.getNorth());
		assertEquals(3, tile.getEast());
		assertEquals(0, tile.getSouth());
		assertEquals(1, tile.getWest());
		tile.rotate();
		assertEquals(1, tile.getNorth());
		assertEquals(2, tile.getEast());
		assertEquals(3, tile.getSouth());
		assertEquals(0, tile.getWest());
		tile.rotate();
		assertEquals(0, tile.getNorth());
		assertEquals(1, tile.getEast());
		assertEquals(2, tile.getSouth());
		assertEquals(3, tile.getWest());
	}

	
}
