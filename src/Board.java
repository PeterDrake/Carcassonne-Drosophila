public class Board {
	private Tile[][] table;
	public static final int MAX_BOARD_SIZE = 143;

	// constructor for Board, just sets up the grid array
	public Board() {
		table = new Tile[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
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
