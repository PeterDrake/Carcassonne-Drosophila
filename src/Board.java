public class Board {
	
	//these class constants are for road completion testing
	private final int NORTH = 1;
	private final int EAST = 3;
	private final int SOUTH = 5;
	private final int WEST = 7;
	
	// these hold the location of the most recent tile placed, for road
	// completion
	private int lastX;
	private int lastY;
	
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
		lastX = x;
		lastY = y;
	}
	
	public int getLastX(){
		return lastX;
	}
	
	public int getLastY(){
		return lastY;
	}

	// gets tile from the given coordinates
	public Tile getTile(int x, int y) {
		return table[x][y];
	}

	
	//Places a meeple for player playerNum on a specific tile.
	public void placeMeeple(int x, int y, int playerNum, int quadrant){
		table[x][y].addMeeple(playerNum, quadrant);
	}
	
	// Returns true if there is a meeple on a specific tile.
	public boolean hasMeeple(int x, int y){
		return table[x][y].hasMeeple();
	}
	
	// Returns the player number of the owner of the meeple on a specific tile.
	public int meeplePlayer(int x, int y){
		return table[x][y].getPlayer();
	}
	
	public int getMeeplePosition(int x, int y){
		return table[x][y].getMeeplePosition();
	}


	// this method returns true if there is at least one completed road
	public boolean roadCompleted() {
		Tile t = getTile(lastX, lastY);
		boolean complete = false;
		if (t.getCenter() == Tile.CASTLE || t.getCenter() == Tile.CLOISTER
				|| t.getCenter() == Tile.XROAD
				|| t.getCenter() == Tile.SHIELD_CASTLE) {
			if (t.getNorth() == Tile.ROAD && getTile(lastX, lastY - 1) != null) {
				if (searchRoad(getTile(lastX, lastY - 1), t, SOUTH, lastX,
						lastY - 1)) {
					complete = true;
				}
			} else if (t.getEast() == Tile.ROAD
					&& getTile(lastX + 1, lastY) != null) {
				if (searchRoad(getTile(lastX + 1, lastY), t, WEST, lastX + 1,
						lastY)) {
					complete = true;
				}
			} else if (t.getSouth() == Tile.ROAD
					&& getTile(lastX, lastY + 1) != null) {
				if (searchRoad(getTile(lastX, lastY + 1), t, NORTH, lastX,
						lastY + 1)) {
					complete = true;
				}
			} else if (t.getWest() == Tile.ROAD
					&& getTile(lastX - 1, lastY) != null) {
				if (searchRoad(getTile(lastX - 1, lastY), t, EAST, lastX - 1,
						lastY)) {
					complete = true;
				}
			}
		} else {
			int endsFound = 0;
			if (t.getNorth() == Tile.ROAD && getTile(lastX, lastY - 1) != null) {
				if (searchRoad(getTile(lastX, lastY - 1), t, SOUTH, lastX,
						lastY - 1)) {
					endsFound++;
				}
			}
			if (t.getEast() == Tile.ROAD && getTile(lastX + 1, lastY) != null) {
				if (searchRoad(getTile(lastX + 1, lastY), t, WEST, lastX + 1,
						lastY)) {
					endsFound++;
				}
			}
			if (t.getSouth() == Tile.ROAD && getTile(lastX, lastY + 1) != null) {
				if (searchRoad(getTile(lastX, lastY + 1), t, NORTH, lastX,
						lastY + 1)) {
					endsFound++;
				}
			}
			if (t.getWest() == Tile.ROAD && getTile(lastX - 1, lastY) != null) {
				if (searchRoad(getTile(lastX - 1, lastY), t, EAST, lastX - 1,
						lastY)) {
					endsFound++;
				}
			}
			if (endsFound == 2) {
				complete = true;
			}
		}
		return complete;
	}

	// recursive helper method for searching for road completion
	// from is which direction this tile was entered from - north 0, east 1,
	// south 2, west 3
	protected boolean searchRoad(Tile current, Tile original, int from, int x,
			int y) {
		if ((current.getCenter() == Tile.CASTLE)
				|| (current.getCenter() == Tile.SHIELD_CASTLE)
				|| (current.getCenter() == Tile.CLOISTER)
				|| (current.getCenter() == Tile.XROAD)) {
			return true;
		} else if (current == original) {
			return true;
		}
		if (current.getNorth() == Tile.ROAD && from != NORTH
				&& getTile(x, y - 1) != null) {
			return searchRoad(getTile(x, y - 1), original, SOUTH, x, y - 1);
		} else if (current.getEast() == Tile.ROAD && from != EAST
				&& getTile(x + 1, y) != null) {
			return searchRoad(getTile(x + 1, y), original, WEST, x + 1, y);
		} else if (current.getSouth() == Tile.ROAD && from != SOUTH
				&& getTile(x, y + 1) != null) {
			return searchRoad(getTile(x, y + 1), original, NORTH, x, y + 1);
		} else if (current.getWest() == Tile.ROAD && from != WEST
				&& getTile(x - 1, y) != null) {
			return searchRoad(getTile(x - 1, y), original, EAST, x - 1, y);
		}
		return false;
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
