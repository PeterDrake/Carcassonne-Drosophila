public class Board {

	// these class constants are for road completion testing
	private final int NORTH = 1;
	private final int EAST = 3;
	private final int SOUTH = 5;
	private final int WEST = 7;

	// these hold the location of the most recent tile placed, for road
	// completion
	private int lastX;
	private int lastY;
	
	//the board needs to be able to access players to give them scores for completing roads
	private Player[] players;
	

	private Tile[][] table;
	public final int MAX_BOARD_SIZE = 143;
	public final int TABLE_MID = 72;

	// constructor for Board, just sets up the grid array
	public Board(Player[] players) {
		table = new Tile[MAX_BOARD_SIZE][MAX_BOARD_SIZE];
		this.players = players;
	}
	
	public Player getPlayer(int player){
		return players[player];
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
	public boolean hasMeeple(int x, int y) {
		return table[x][y].hasMeeple();
	}

	// Returns the player number of the owner of the meeple on a specific tile.
	public int meeplePlayer(int x, int y) {
		return table[x][y].getPlayer();
	}
	
	public int getMeeplePosition(int x, int y){
		return table[x][y].getMeeplePosition();
	}

	// this method returns true if there is at least one completed road
	public boolean roadCompleted() {
		Tile t = getTile(lastX, lastY); // the last placed tile
		int endsFound = 0;
		if (t.getNorth() == Tile.ROAD && getTile(lastX, lastY - 1) != null) {
			if (searchRoad(getTile(lastX, lastY - 1), t, SOUTH, lastX,
					lastY - 1) > 0) {
				endsFound++;
			}
		}
		if (t.getEast() == Tile.ROAD && getTile(lastX + 1, lastY) != null) {
			if (searchRoad(getTile(lastX + 1, lastY), t, WEST, lastX + 1, lastY) > 0) {
				endsFound++;
			}
		}
		if (t.getSouth() == Tile.ROAD && getTile(lastX, lastY + 1) != null) {
			if (searchRoad(getTile(lastX, lastY + 1), t, NORTH, lastX,
					lastY + 1) > 0) {
				endsFound++;
			}
		}
		if (t.getWest() == Tile.ROAD && getTile(lastX - 1, lastY) != null) {
			if (searchRoad(getTile(lastX - 1, lastY), t, EAST, lastX - 1, lastY) > 0) {
				endsFound++;
			}
		}
		if (t.getCenter() == Tile.CASTLE || t.getCenter() == Tile.CLOISTER
				|| t.getCenter() == Tile.XROAD
				|| t.getCenter() == Tile.SHIELD_CASTLE) {
			if (endsFound > 0) {
				return true;
			}

		} else {
			if (endsFound == 2) {
				return true;
			}
		}
		return false;
	}

	// recursive helper method for searching for road completion
	// from is which direction this tile was entered from - north 0, east 1,
	// south 2, west 3
	protected int searchRoad(Tile current, Tile original, int from, int x, int y) {
		if ((current.getCenter() == Tile.CASTLE)
				|| (current.getCenter() == Tile.SHIELD_CASTLE)
				|| (current.getCenter() == Tile.CLOISTER)
				|| (current.getCenter() == Tile.XROAD)) {
			return 1;
		} else if (current == original) {
			return 1;
		}
		if (current.getNorth() == Tile.ROAD && from != NORTH
				&& getTile(x, y - 1) != null) {
			return 1 + searchRoad(getTile(x, y - 1), original, SOUTH, x, y - 1);
		} else if (current.getEast() == Tile.ROAD && from != EAST
				&& getTile(x + 1, y) != null) {
			return 1 + searchRoad(getTile(x + 1, y), original, WEST, x + 1, y);
		} else if (current.getSouth() == Tile.ROAD && from != SOUTH
				&& getTile(x, y + 1) != null) {
			return 1 + searchRoad(getTile(x, y + 1), original, NORTH, x, y + 1);
		} else if (current.getWest() == Tile.ROAD && from != WEST
				&& getTile(x - 1, y) != null) {
			return 1 + searchRoad(getTile(x - 1, y), original, EAST, x - 1, y);
		}
		return 0;
	}
	
	//this method adds the score it calculates to the player who gets the points
	public void scoreRoad() {
		Tile t = getTile(lastX, lastY);
		//Case for crossroads
		if (t.getCenter() == Tile.XROAD) {
			if (t.getNorth() == Tile.ROAD) {
				int score = searchRoad(t, t, SOUTH, lastX, lastY + 1);
				int[] meepleTally = new int[5];
				meepleOnCompletedRoad(meepleTally, t, t, SOUTH, lastX, lastY+1);
				assignScore(score, meepleTally);
				
			}
			if (t.getEast() == Tile.ROAD) {
				int score = searchRoad(t, t, WEST, lastX + 1, lastY);
				int[] meepleTally = new int[5];
				meepleOnCompletedRoad(meepleTally, t, t, WEST, lastX + 1, lastY);
				assignScore(score, meepleTally);
			}
			if (t.getSouth() == Tile.ROAD) {
				int score = searchRoad(t, t, NORTH, lastX, lastY - 1);
				int[] meepleTally = new int[5];
				meepleOnCompletedRoad(meepleTally, t, t, NORTH, lastX, lastY-1);
				assignScore(score, meepleTally);
			}
			if (t.getWest() == Tile.ROAD) {
				int score = searchRoad(t, t, EAST, lastX - 1, lastY);
				int[] meepleTally = new int[5];
				meepleOnCompletedRoad(meepleTally, t, t, EAST, lastX - 1, lastY);
				assignScore(score, meepleTally);
			}
		} else { // case for single completed roads 
			int score = 1;
			int[] meepleTally = new int[5];
			if (roadCompleted()) {
				if (t.getNorth() == Tile.ROAD && getTile(lastX, lastY - 1) != null) {
					meepleOnCompletedRoad(meepleTally,t, t, SOUTH, lastX, lastY - 1);
					score += searchRoad(t, t, SOUTH, lastX, lastY - 1);
				}
				if (t.getEast() == Tile.ROAD && getTile(lastX + 1, lastY) != null) {
					meepleOnCompletedRoad(meepleTally, t, t, WEST, lastX + 1, lastY);
					score += searchRoad(t, t, WEST, lastX + 1, lastY);
				}
				if (t.getSouth() == Tile.ROAD && getTile(lastX, lastY + 1) != null) {
					meepleOnCompletedRoad(meepleTally, t, t, NORTH, lastX, lastY + 1);
					score += searchRoad(t, t, NORTH, lastX, lastY + 1);
				}
				if (t.getWest() == Tile.ROAD && getTile( lastX - 1, lastY) != null) {
					meepleOnCompletedRoad(meepleTally, t, t, EAST, lastX - 1, lastY);
					score += searchRoad(t, t, EAST, lastX - 1, lastY);
				}
				System.out.println(meepleTally[0]);
				System.out.println(score);
				assignScore(score, meepleTally);
			}

		}
	}
	
	protected void assignScore(int score, int[] meepleTally){
		int winningPlayer = 0;
		int maxMeeple = meepleTally[0];
		for(int i = 1; i < 5; i++){
			if(meepleTally[i] > maxMeeple){
				winningPlayer = i;
				maxMeeple = meepleTally[i];
			}
		}
		getPlayer(winningPlayer).addPointsToScore(score);
	}

	protected void meepleOnCompletedRoad(int[] players, Tile current, Tile original, int from, int x, int y) {
		if(hasMeeple(x, y)){
			if(current.getCenter() == Tile.XROAD){
				if(current.getMeeplePosition() == from){
					players[meeplePlayer(x, y)] ++;
				}
			}else{
				if(current.getTerrainAt(current.getMeeplePosition()) == Tile.ROAD){
					players[meeplePlayer(x, y)] ++;
				}
			}
		}
		if ((current.getCenter() == Tile.CASTLE)
				|| (current.getCenter() == Tile.SHIELD_CASTLE)
				|| (current.getCenter() == Tile.CLOISTER)
				|| (current.getCenter() == Tile.XROAD)) {
		} else if (current == original) {
		} else if (current.getNorth() == Tile.ROAD && from != NORTH
				&& getTile(x, y - 1) != null) {
			meepleOnCompletedRoad(players, getTile(x, y - 1), original, SOUTH, x, y - 1);
		} else if (current.getEast() == Tile.ROAD && from != EAST
				&& getTile(x + 1, y) != null) {
			meepleOnCompletedRoad(players, getTile(x + 1, y), original, WEST, x + 1, y);
		} else if (current.getSouth() == Tile.ROAD && from != SOUTH
				&& getTile(x, y + 1) != null) {
			meepleOnCompletedRoad(players, getTile(x, y + 1), original, NORTH, x, y + 1);
		} else if (current.getWest() == Tile.ROAD && from != WEST
				&& getTile(x - 1, y) != null) {
			meepleOnCompletedRoad(players, getTile(x - 1, y), original, EAST, x - 1, y);
		}
	}

	public boolean isValidMove(int x, int y, Tile toPlace) {
		boolean bordering = false;
		// if the input is outside of the board
		if (x < 0 || y < 0 || x > MAX_BOARD_SIZE - 1 || y > MAX_BOARD_SIZE - 1)
			return false;
		// a tile is already there
		if (getTile(x, y) != null)
			return false;
		// a bordering tile has a conflicting side
		if (y < MAX_BOARD_SIZE - 1 && getTile(x, y + 1) != null) {
			bordering = true;
			if (getTile(x, y + 1).getSouth() != toPlace.getNorth())
				return false;
		}
		if (x < MAX_BOARD_SIZE - 1 && getTile(x + 1, y) != null) {
			bordering = true;
			if (getTile(x + 1, y).getWest() != toPlace.getEast())
				return false;
		}
		if (y > 0 && getTile(x, y - 1) != null) {
			bordering = true;
			if (getTile(x, y - 1).getNorth() != toPlace.getSouth())
				return false;
		}
		if (x > 0 && getTile(x - 1, y) != null) {
			bordering = true;
			if (getTile(x - 1, y).getEast() != toPlace.getWest())
				return false;
		}
		// it's not bordering anything!
		return bordering;

	}

	public Tile[][] getTable() {
		return table;
	}

}
