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
	private Tile tileInHand;
	private int playerNum;
	private boolean meeplePlaced;
	
	public Tile getTileInHand()
	{
		return tileInHand;
	}
	
	private Scanner sc = new Scanner(System.in);

	private static Board board;

	public Carcassonne() {
		tiles = setUpTiles();

		// Part of game that deals with players
		boolean validName;
		players = new Player[5];
		players[0] = new Player(0); // TODO it will be trivial to let people
									// input a
		// variable number of player names
		playerNum = 0;
		do {
			System.out.println("Please enter the name of player 1:");
			validName = players[0].setName(sc.nextLine());
		} while (!validName);
		System.out
				.println("Only one player right now? Remember, games are better with friends!");
		System.out.println("Oh well, have fun " + players[0].getName());

		// Creates the initial Board Tile and places it on the board.
		Tile initialTile = new Tile(Tile.FIELD, Tile.CASTLE, Tile.FIELD,
				Tile.ROAD, Tile.FIELD, Tile.FIELD, Tile.FIELD, Tile.ROAD,
				Tile.ROAD, "city1rwe.png");
		board = new Board(players);
		board.placeTile(initialTile, 72, 72);

		System.out.println("you have placed the tile with characteristics: "
				+ board.getTile(72, 72));
		
		tilesLeft = TILES_IN_GAME; 
	}
	
	public boolean setPlayerName(int playerIndex, String playerName)
	{
		return players[playerIndex].setName(playerName);
	}
	
	public void drawTile()
	{
		int tileNumber = (int) (Math.random() * tilesLeft);
		tileInHand = tiles[tileNumber];
		tilesLeft--;
		tiles[tileNumber] = tiles[tilesLeft];
		
		System.out.println("you have tile " + tileInHand + " in your hand.");
	}
	
	public void drawAndPlaceTile() {
		int tileNumber = (int) (Math.random() * tilesLeft);
		Tile tileInHand = tiles[tileNumber];
		tilesLeft--;
		tiles[tileNumber] = tiles[tilesLeft];

		System.out.println("you have tile " + tileInHand + " in your hand.");
		int tempX = 0;
		int tempY = 0;
		do {
			System.out
					.println("Do you want to rotate the tile? Return r to rotate, or n to not rotate");
			if (sc.nextLine().equals("r")) {
				tempX = 0;
				tempY = 0;
				tileInHand.rotate();
				System.out.println("you have tile " + tileInHand
						+ " in your hand.");
				continue;
			}
			System.out.println("Please place the tile.");
			tempX = Integer.parseInt(sc.nextLine());
			tempY = Integer.parseInt(sc.nextLine());
		} while (!board.isValidMove(tempX, tempY, tileInHand));

		board.placeTile(tileInHand, tempX, tempY);

		System.out
				.println("Do you want to place a follower on this tile? Return y to place one.");
		meeplePlaced = false;
		if (sc.nextLine().equals("y")) {
			System.out
					.println("Enter the quadrant you want to place the Follower on; ie NW, N, SW, C, etc. This is case sensitive.");
			while (meeplePlaced == false) {
				switch (sc.nextLine()) {
				case "NW":
					board.placeMeeple(tempX, tempY, playerNum, 0);
					meeplePlaced = true;
					break;
				case "N":
					board.placeMeeple(tempX, tempY, playerNum, 1);
					meeplePlaced = true;
					break;
				case "NE":
					board.placeMeeple(tempX, tempY, playerNum, 2);
					meeplePlaced = true;
					break;
				case "E":
					board.placeMeeple(tempX, tempY, playerNum, 3);
					meeplePlaced = true;
					break;
				case "SE":
					board.placeMeeple(tempX, tempY, playerNum, 4);
					meeplePlaced = true;
					break;
				case "S":
					board.placeMeeple(tempX, tempY, playerNum, 5);
					meeplePlaced = true;
					break;
				case "SW":
					board.placeMeeple(tempX, tempY, playerNum, 6);
					meeplePlaced = true;
					break;
				case "W":
					board.placeMeeple(tempX, tempY, playerNum, 7);
					meeplePlaced = true;
					break;
				case "C":
					board.placeMeeple(tempX, tempY, playerNum, 8);
					meeplePlaced = true;
					break;
				}
			}

			System.out.println(board.getTile(tempX, tempY));
		}

		System.out.println("Your tile was placed at: " + tempX + ", " + tempY);

	}
	

	public boolean placeTile(int i, int j) {
//		while(true) {			
//			System.out.println("Do you want to rotate the tile? Return r to rotate, or n to not rotate");
//			if(sc.nextLine().equals("r")){
//				tileInHand.rotate();
//				System.out.println("You have tile " + tileInHand + " in your hand.");
//			} else break;
//		}
		if(board.isValidMove(i, j, tileInHand) && !isGameOver())
		{
			System.out.println("Legal Move At: " + i + "|" + j);
			board.placeTile(tileInHand, i, j);
			drawTile();
			return true;
		} else if (!isGameOver()) {
			System.out.println("Not Legal Move");			
		} else System.out.println("Game is over!");
		return false;
	}
	
	public void rotateTile(){
		tileInHand.rotate();
	}

	// passes along player to GUI
	public Player[] getPlayers() {
		return players;
	}

	// Sets up the initial tile distribution and returns it as an array of
	// tiles.
	/**
	 * Sets up the initial array of tiles from a text file tileDist.txt that
	 * contains the initial tileset that is written in a line with integers
	 * representing in order; North-West, North, North-East, East, South-East,
	 * South, South-West, West, Center and finally the source of the image file
	 * for this tile.
	 * 
	 * @return
	 */
	private Tile[] setUpTiles() {
		try {
			myScanner = new Scanner(new File("tileDist.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("The filepath of the initial tiles is invalid");
			e.printStackTrace();
		}
		tempTiles = new Tile[TILES_IN_GAME];
		int i = 0;
		while (myScanner.hasNextInt()) {
			int north_west = myScanner.nextInt();
			int north = myScanner.nextInt();
			int north_east = myScanner.nextInt();
			int east = myScanner.nextInt();
			int south_east = myScanner.nextInt();
			int south = myScanner.nextInt();
			int south_west = myScanner.nextInt();
			int west = myScanner.nextInt();
			int center = myScanner.nextInt();
			String fileName = myScanner.next();
			tempTiles[i] = new Tile(north_west, north, north_east, east,
					south_east, south, south_west, west, center, fileName);
			i++;
		}
		return tempTiles;
	}

	public Board getBoard() {
		return board;
	}

	protected Tile[] getTiles() {
		return tiles;
	}

	public static void main(String[] args) {
		new Carcassonne();
	}

	public int getTilesLeft() {
		return tilesLeft;
	}

	public boolean isGameOver() {
		return tilesLeft == 0;
	}

}
