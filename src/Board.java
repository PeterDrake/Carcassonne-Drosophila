public class Board {
	Tile[][] table;
	//these hold the location of the most recent tile placed, for road completion
	private int lastX;
	private int lastY;

	// constructor for Board, just sets up the grid array
	public Board() {
		table = new Tile[143][143];
	}

	// places the given tile at the given coordinates
	public void placeTile(Tile tile, int x, int y) {
		table[x][y] = tile;
		lastX = x;
		lastY = y;
	}

	// gets tile from the given coordinates
	public Tile getTile(int x, int y) {
		return table[x][y];
	}
	
	//this method returns true if there is at least one completed road
	public boolean roadCompleted(){
		return false;
	}
}
