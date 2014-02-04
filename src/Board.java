public class Board {
	Tile[][] table;

	// constructor for Board, just sets up the grid array
	public Board() {
		table = new Tile[143][143];
	}

	// places the given tile at the given coordinates
	public void placeTile(Tile tile, int x, int y) {
		table[x][y] = tile;
	}

	// gets tile from the given coordinates
	public Tile getTile(int x, int y) {
		return table[x][y];
	}
}
