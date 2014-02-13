import java.io.File;

public class Tile {
	public static final int FIELD = 0;
	public static final int ROAD = 1;
	public static final int CASTLE = 2;
	public static final int XROAD = 3;
	public static final int CLOISTER = 4;
	public static final int SHIELD_CASTLE = 5;
	private int[] quadrant;
	private int orientation;
	private boolean hasMeeple;
	private int meeplePlayer;
	private String fileName;
	
	
	/**
	 * Our tile will have an array of 9 values for the things in each of the 9 quadrants.
	 * This will look like:
	 * North-West    North     North-East
	 * West          Center    East
	 * South-West    South     South-East
	 * 
	 * These can be called by methods getNorthWest(), getNorth etc.
	 * 
	 */


	// constructor for the Tile Class, takes in the attribute of each direction
	// and the center.
	public Tile(int north_west,int north, int north_east , int east, int south_east,int south,int south_west,int west, int center, String fileName) {
		quadrant = new int[9];
		quadrant[0] = north_west;
		quadrant[1] = north;
		quadrant[2] = north_east;
		quadrant[3] = east;
		quadrant[4] = south_east;
		quadrant[5] = south;
		quadrant[6] = south_west;
		quadrant[7] = west;
		quadrant[8] = center; 
		this.fileName = fileName;
		File file = new File(fileName);
		if(!file.exists()) {
			System.err.println("Tile Image filename does not exist.");
		}
		orientation = 0;
	}
	// overloaded constructor so we can <<<TEST>>> using the tile class without having a path to an image
	public Tile(int north, int east, int south, int west, int center)
	{
		quadrant = new int[9];
		quadrant[1] = north;
		quadrant[3] = east;
		quadrant[5] = south;
		quadrant[7] = west;
		quadrant[8] = center;
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
		return quadrant[1];
	}
	public int getNorthWest() {
		return quadrant[0];
	}
	public int getNorthEast() {
		return quadrant[2];
	}
	public int getEast() {
		return quadrant[3];
	}
	public int getSouthEast() {
		return quadrant[4];
	}
	public int getSouth() {
		return quadrant[5];
	}
	public int getSouthWest() {
		return quadrant[6];
	}
	public int getWest() {
		return quadrant[7];
	}

	public int getCenter() {
		return quadrant[8];
	}

	// getter for the Orientation field
	public int Orientation() {
		return orientation;
	}

	// returns true if there is a meeple on this tile
	public boolean hasMeeple() {
		return hasMeeple;
	}
	
	public String getFileName() {
		return fileName;
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
	

	//rotates the tile by one
	protected void rotate(){
		int temp1=quadrant[6];
		int temp2= quadrant[7];
for(int i=7; i>0; i--){
	int j =i+6;
	quadrant[i]=quadrant[j%8]; 
}
		quadrant[0]=temp1; 
		quadrant[1]=temp2;
	}

	// returns each side of the tile in order of N,E,S,W and C;
	public String toString() {
		String str = "NW: " + sideToString(quadrant[0]) + " ";
        str += "N: " + sideToString(quadrant[1]) + " ";
		str += "NE: " + sideToString(quadrant[2]) + " ";
		str += "E: " + sideToString(quadrant[3]) + " ";
		str += "SE: " + sideToString(quadrant[4]) + " ";
		str += "S: " + sideToString(quadrant[5]) + " ";
		str += "SW: " + sideToString(quadrant[6]) + " ";
		str += "W: " + sideToString(quadrant[7]) + " ";
		str += "C: " + sideToString(quadrant[8]) + " ";
		if(hasMeeple){
			str += "Has meeple: " + hasMeeple + " ";
			str += "belonging to " + meeplePlayer + " ";
		}
		return str;
	}
}
