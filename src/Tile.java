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

	public int getNorth() {
		return side[0];
	}

	public int getEast() {
		return side[1];
	}

	public int getSouth() {
		return side[2];
	}

	public int getWest() {
		return side[3];
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

	// returns each side of the tile in order of N,E,S,W and C;
	public String toString() {
		String str = "N: " + sideToString(side[0]) + " ";
		str += "E: " + sideToString(side[1]) + " ";
		str += "S: " + sideToString(side[2]) + " ";
		str += "W: " + sideToString(side[3]) + " ";
		str += "C: " + sideToString(side[4]) + " ";
		return str;
	}
}
