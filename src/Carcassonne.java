import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carcassonne {
	private Tile[] tiles;
	private Tile[] tempTiles;
	public static final int TILES_IN_GAME = 71;
	private Scanner myScanner;
	private Player player; // Eventually becomes an array of players
	private int tilesLeft; 
	
	private Scanner sc = new Scanner(System.in);

	private static Board board;

	public static void main(String[] args) {
		new Carcassonne();
	}

	public Carcassonne() {
		tiles=setUpTiles();
		player = new Player();

		// Part of game that deals with players
		boolean validName;
		player = new Player(); // TODO it will be trivial to let people input a
								// variable number of player names
		do {
			System.out.println("Please enter the name of player 1:");
			validName = player.setName(sc.nextLine());
		} while (!validName);
		System.out
				.println("Only one player right now? Remember, games are better with friends!");
		System.out.println("Oh well, have fun " + player.getName());
	

		// Part of game that deals with tiles
		// currently places the initial tile and prints the attributes of that tile.
		Tile initialTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD);
		board = new Board();
		board.placeTile(initialTile, 72, 72);
		System.out.println("you have placed the tile with characteristics: "
				+ board.getTile(72, 72));
		
		tilesLeft = TILES_IN_GAME; 
		int tileNumber = (int) Math.random() * tilesLeft;
		
		
	}

	// method to pass along score to the GUI
	public int getScore() {
		return player.getScore();
	}
	
	
	//Sets up the initial tile distribution and returns it as an array of tiles.
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
