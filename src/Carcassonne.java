import java.util.Scanner;

public class Carcassonne {
	private Scanner sc = new Scanner(System.in);

	private static Board board;
	private Player player1; // Will eventually become an array of players

	public static void main(String[] args) {
		new Carcassonne();
	}

	public Carcassonne() {
		// Part of game that deals with players
		boolean validName;
		player1 = new Player(); // TODO it will be trivial to let people input a
								// variable number of player names
		do {
			System.out.println("Please enter the name of player 1:");
			validName = player1.setName(sc.nextLine());
		} while (!validName);
		System.out
				.println("Only one player right now? Remember, games are better with friends!");
		System.out.println("Oh well, have fun " + player1.getName());

		// Part of game that deals with tiles
		// currently places the initial tile and prints the attributes of that
		// tile.
		Tile initialTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD);
		board = new Board();
		board.placeTile(initialTile, 72, 72);
		System.out.println("you have placed the tile with characteristics: "
				+ board.getTile(72, 72));
	}

}
