public class Board {
	private Tile[][] table;
	public final int MAX_BOARD_SIZE = 143;
	public final int TABLE_MID = 72;

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
	
	public boolean isValidMove(int x, int y, Tile toPlace)
	{		
		boolean bordering = false;
		// if the input is outside of the board				
		if(x < 0 || y < 0 || x > MAX_BOARD_SIZE - 1 || y > MAX_BOARD_SIZE - 1) return false;
		// a tile is already there
		if(getTile(x, y) != null) return false;
		// a bordering tile has a conflicting side
		if(y < MAX_BOARD_SIZE - 1 && getTile(x, y + 1) != null)
		{
			bordering = true;
			if(getTile(x, y + 1).getSouth() != toPlace.getNorth()) return false;
		}
		if(x < MAX_BOARD_SIZE - 1 &&  getTile(x + 1, y) != null)
		{
			bordering = true;
			if(getTile(x + 1, y).getWest() != toPlace.getEast()) return false;
		}
		if(y > 0 && getTile(x, y - 1) != null)
		{
			bordering = true;
			if(getTile(x, y - 1).getNorth() != toPlace.getSouth()) return false;
		}
		if(x > 0 && getTile(x - 1, y) != null)
		{
			bordering = true;
			if(getTile(x - 1, y).getEast() != toPlace.getWest()) return false;
		}
		// it's not bordering anything!
		return bordering;

	}
	
	public Tile[][] getTable() {
		return table;
	}
}
