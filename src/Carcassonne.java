import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carcassonne {
	private Tile[] tiles;
	private Tile[] tempTiles;
	public static final int TILES_IN_GAME = 71;
	private Scanner myScanner;
	private Player[] players; // Eventually becomes an array of players
	private int tilesLeft; 
	
	private Scanner sc = new Scanner(System.in);


	private static Board board;

	public Carcassonne() {
		tiles=setUpTiles();

		// Part of game that deals with players
		boolean validName;
		players = new Player[5];
		players[0] = new Player(0); // TODO it will be trivial to let people input a
								// variable number of player names
		do {
			System.out.println("Please enter the name of player 1:");
			validName = players[0].setName(sc.nextLine());
		} while (!validName);
		System.out
				.println("Only one player right now? Remember, games are better with friends!");
		System.out.println("Oh well, have fun " + players[0].getName());
	

		//Creates the initial Board Tile and places it on the board.
		Tile initialTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD, "city1rwe.png");
		board = new Board();
		board.placeTile(initialTile, 72, 72);
		
		System.out.println("you have placed the tile with characteristics: "
				+ board.getTile(72, 72));
		
		tilesLeft = TILES_IN_GAME; 
		int tileNumber = (int) (Math.random() * tilesLeft);
		System.out.println(tileNumber);
		Tile tileInHand = tiles[tileNumber];
		tilesLeft--;
		tiles[tileNumber] = tiles[tilesLeft];
		
		System.out.println("you have tile " + tileInHand + " in your hand.");
		int tempX =0;
		int tempY =0;
		do
		{
			System.out.println("Do you want to rotate the tile? Return r to rotate, or n to not rotate");
			if(sc.nextLine().equals("r")){
				tempX=0;
				tempY=0;
				tileInHand.rotate();
				System.out.println("you have tile " + tileInHand + " in your hand.");
				continue;
			} 
			System.out.println("Please place the tile.");			
			tempX = Integer.parseInt(sc.nextLine());
			tempY = Integer.parseInt(sc.nextLine());
		} while (!board.isValidMove(tempX, tempY, tileInHand));
		
		board.placeTile(tileInHand, tempX, tempY);
		
		System.out.println("Do you want to place a follower on this tile? Return y to place one.");
		if(sc.nextLine().equals("y")){
			board.placeMeeple(tempX, tempY, 0);
			System.out.println(board.getTile(tempX, tempY));
		}
		
		
		System.out.println("Your tile was placed at: " + tempX + ", " + tempY);

	}
	

	

	//passes along player to GUI
	public Player[] getPlayers(){
		return players;
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
	
	
	protected Tile[] getTiles(){
		return tiles;
	}
	
	public static void main(String[] args) {
		new Carcassonne();
	}

}
