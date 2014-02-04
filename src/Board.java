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
	
	//Places a meeple for player playerNum on a specific tile.
	public void placeMeeple(int x, int y, int playerNum){
		table[x][y].addMeeple(playerNum);
	}
	
	// Returns true if there is a meeple on a specific tile.
	public boolean hasMeeple(int x, int y){
		return table[x][y].hasMeeple();
	}
	
	// Returns the player number of the owner of the meeple on a specific tile.
	public int meeplePlayer(int x, int y){
		return table[x][y].getPlayer();
	}
}
