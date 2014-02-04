public class Carcassonne {
	private static Board board;

	// currently places the initial tile and prints the attributes of that tile.
	public static void main(String[] args) {
		System.out
				.println("Time flies like an arrow, fruit flies like a banana.");
		Tile initialTile = new Tile(Tile.CASTLE, Tile.ROAD, Tile.FIELD,
				Tile.ROAD, Tile.ROAD);
		board = new Board();
		board.placeTile(initialTile, 72, 72);
		System.out.println("you have placed the tile with characteristics:"
				+ board.getTile(72, 72));
	}

}
