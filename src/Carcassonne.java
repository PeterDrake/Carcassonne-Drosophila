import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carcassonne {
	private Tile[] tiles;
	private Tile[] tempTiles;
	public static final int TILES_IN_GAME = 71;
	private Scanner myScanner;
	private Player player; // Eventually becomes an array of players
	
	private Scanner sc = new Scanner(System.in);


	private static Board board;

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
	

		//Creates the initial Board Tile and places it on the board.
		Tile initialTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD, "city1rwe.png");
		board = new Board();
		board.placeTile(initialTile, 72, 72);
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
			String fileName = myScanner.next();
			tempTiles[i] = new Tile(north, east, south, west, center, fileName);
			i++;
		}
		return tempTiles;
	}
	
	public Board getBoard() {
		return board;
	}
	
		// method to pass along score to the GUI
	public int getScore() {
		return player.getScore();
	}
	
	
	protected Tile[] getTiles(){
		return tiles;
	}
	
	public static void main(String[] args) {
		new Carcassonne();
	}

}
