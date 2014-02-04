public class Board {
	Tile[][] table;
	
	public final int TABLE_WIDTH = 143;
	public final int TABLE_MID = 72;

	// constructor for Board, just sets up the grid array
	public Board() {
		table = new Tile[TABLE_WIDTH][TABLE_WIDTH];
	}

	// places the given tile at the given coordinates
	public void placeTile(Tile tile, int x, int y) {
		table[x][y] = tile;
	}

	// gets tile from the given coordinates
	public Tile getTile(int x, int y) {
		return table[x][y];
	}
	
	public Tile[][] getTable() {
		return table;
	}
}
