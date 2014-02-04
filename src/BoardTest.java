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
		Tile initialTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD);
		board.placeTile(initialTile, 72, 72);
		assertEquals(initialTile, board.getTile(72, 72));
	}

}
