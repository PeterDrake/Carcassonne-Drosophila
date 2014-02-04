import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carcassonne {

	private Tile[] tiles;
	private Tile[] tempTiles;
	public static final int TILES_IN_GAME = 71;
	private Scanner myScanner;

	public static void main(String[] args) {
		System.out.println("Time flies like an arrow, fruit flies like a banana.");
		new Carcassonne();
	}
	
	
	public Carcassonne(){
		tiles=setUpTiles();
		
	}
	
	/*
	 * Sets up the initial tile distribution and returns it as an array of tiles.
	 */
	private Tile[] setUpTiles(){
		try {
			myScanner = new Scanner(new File("tileDist.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("The filepath of the initial tiles is invalid");
			e.printStackTrace();
		}
		tempTiles = new Tile[TILES_IN_GAME];
		int i = 0;
		while (myScanner.hasNextInt()) {
	          int north = myScanner.nextInt();
	          int east = myScanner.nextInt();
	          int south = myScanner.nextInt();
	          int west = myScanner.nextInt();
	          int center = myScanner.nextInt();
	          tempTiles[i] = new Tile(north, east, south, west, center);
	          i++;
	      }
		return tempTiles;
	}
	
	protected Tile[] getTiles(){
		return tiles;
	}

}
