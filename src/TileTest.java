import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;


public class TileTest {

	@Test
	public void testConstructor() {
		Tile tile = new Tile(0, 0, 0, 0, 0,0,0,0,0, "name");
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
		Tile testTile = new Tile(Tile.FIELD, Tile.CASTLE, Tile.FIELD, Tile.ROAD, Tile.FIELD,Tile.FIELD,Tile.FIELD,
				Tile.ROAD, Tile.ROAD, "city1rwe.png");
		File file = new File(testTile.getFileName());
		assertTrue(file.exists());
	}
	
	@Test
	public void testRotation() {
		Tile tile = new Tile(2,1,0,2,0,1,0,0,1, "city1rwe.png");
		tile.rotate();
		assertEquals(0, tile.getNorth());
		assertEquals(0, tile.getNorthWest());
		assertEquals(2, tile.getNorthEast());
		assertEquals(1, tile.getEast());
		assertEquals(0, tile.getSouthEast());
		assertEquals(2, tile.getSouth());
		assertEquals(0, tile.getSouthWest());
		assertEquals(1, tile.getWest());
		assertEquals(1, tile.getCenter());
		tile.rotate();
		assertEquals(1, tile.getNorth());
		assertEquals(0, tile.getNorthWest());
		assertEquals(0, tile.getNorthEast());
		assertEquals(0, tile.getEast());
		assertEquals(2, tile.getSouthEast());
		assertEquals(1, tile.getSouth());
		assertEquals(0, tile.getSouthWest());
		assertEquals(2, tile.getWest());
		assertEquals(1, tile.getCenter());
		tile.rotate();
		assertEquals(2, tile.getNorth());
		assertEquals(0, tile.getNorthWest());
		assertEquals(0, tile.getNorthEast());
		assertEquals(1, tile.getEast());
		assertEquals(0, tile.getSouthEast());
		assertEquals(0, tile.getSouth());
		assertEquals(2, tile.getSouthWest());
		assertEquals(1, tile.getWest());
		assertEquals(1, tile.getCenter());
		tile.rotate();
		assertEquals(1, tile.getNorth());
		assertEquals(2, tile.getNorthWest());
		assertEquals(0, tile.getNorthEast());
		assertEquals(2, tile.getEast());
		assertEquals(0, tile.getSouthEast());
		assertEquals(1, tile.getSouth());
		assertEquals(0, tile.getSouthWest());
		assertEquals(0, tile.getWest());
		assertEquals(1, tile.getCenter());
	}
	
	@Test
	public void testAddMeeple(){
		Tile tile = new Tile(0,1,2,3,0);
		assertFalse(tile.hasMeeple());
		tile.addMeeple(0);
		assertTrue(tile.hasMeeple());
		assertEquals(0, tile.getPlayer());
	}

	
}
