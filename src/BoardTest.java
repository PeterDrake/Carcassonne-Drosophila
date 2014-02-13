import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	private Board board;

	@Before
	public void setUp() throws Exception {
		board = new Board();
	}

	@Test
	public void initialTileTest() {
		Tile initialTile = new Tile(Tile.FIELD, Tile.CASTLE, Tile.FIELD, Tile.ROAD, Tile.FIELD,Tile.FIELD,Tile.FIELD,
				Tile.ROAD, Tile.ROAD, "city1rwe.png");
		board.placeTile(initialTile, 72, 72);
		assertEquals(initialTile, board.getTile(72, 72));
	}
	
	@Test
	public void testPlaceMeeple(){
		Tile initialTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD);
		board.placeTile(initialTile, 72, 72);
		assertFalse(board.hasMeeple(72,72));
		board.placeMeeple(72, 72, 0);
		assertTrue(board.hasMeeple(72, 72));
		assertEquals(0, board.meeplePlayer(72, 72));
	}

}
