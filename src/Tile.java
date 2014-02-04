public class Tile {
	public static final int FIELD = 0;
	public static final int ROAD = 1;
	public static final int CASTLE = 2;
	public static final int XROAD = 3;
	public static final int CLOISTER = 4;
	public static final int SHIELD_CASTLE = 5;
	private int[] side;
	private int orientation;
	private boolean hasMeeple;
	private int meeplePlayer;

	// constructor for the Tile Class, takes in the attribute of each direction
	// and the center.
	public Tile(int north, int east, int south, int west, int center) {
		side = new int[5];
		side[0] = north;
		side[1] = east;
		side[2] = south;
		side[3] = west;
		side[4] = center;
		orientation = 0;
	}
	
	// Adds a meeple to this tile belonging to a player.
	public void addMeeple(int player){
		hasMeeple=true;
		meeplePlayer=player;
	}
	
	
	// Returns the number of the player who has a meeple on this tile.
	public int getPlayer(){
		return meeplePlayer;
	}

	public int getNorth() {
		return side[orientation + 0];
	}

	public int getEast() {
		return side[(orientation +1 ) % 4];
	}

	public int getSouth() {
		return side[(orientation + 2) %4];
	}

	public int getWest() {
		return side[(orientation + 3) %4];
	}

	public int getCenter() {
		return side[4];
	}

	// getter for the Orientation field
	public int Orientation() {
		return orientation;
	}

	// returns true if there is a meeple on this tile
	public boolean hasMeeple() {
		return hasMeeple;
	}

	// returns string version of the side attribute
	public String sideToString(int side) {
		switch (side) {
		case FIELD:
			return "field";
		case ROAD:
			return "road";
		case CASTLE:
			return "castle";
		case XROAD:
			return "xroad";
		case CLOISTER:
			return "cloister";
		case SHIELD_CASTLE:
			return "castle with shield";
		default:
			System.err.print("incorrect side type");
			return null;
		}
	}
	
	protected void rotate(){
		orientation = (orientation + 3) % 4;
	}

	// returns each side of the tile in order of N,E,S,W and C;
	public String toString() {
		String str = "N: " + sideToString(side[0]) + " ";
		str += "E: " + sideToString(side[1]) + " ";
		str += "S: " + sideToString(side[2]) + " ";
		str += "W: " + sideToString(side[3]) + " ";
		str += "C: " + sideToString(side[4]) + " ";
		str += "Has meeple: " + hasMeeple + " ";
		str += "belonging to " + meeplePlayer + " ";
		return str;
	}
}
