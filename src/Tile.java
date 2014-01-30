
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

	public int Orientation() {
		return orientation;
	}

	public boolean hasMeeple() {
		return hasMeeple;
	}
	
	
}
