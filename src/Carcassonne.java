public class Carcassonne {

	private Player player;

	public static void main(String[] args) {
		System.out
				.println("Time flies like an arrow, fruit flies like a banana.");
	}

	public Carcassonne() {
		player = new Player();
	}

	// method to pass along score to the GUI
	public int getScore() {
		return player.getScore();
	}

}
