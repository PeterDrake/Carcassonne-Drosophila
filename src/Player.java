public class Player {

	private String name;
	private int score;

	public Player() {
		name = "";
	}

	public boolean setName(String newName) {
		// Trims whitespace from inputed name
		name = newName.trim();
		// if string is whitespace, returns false and prompts for a valid name
		if (name.isEmpty()) {
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	// adds the given number of points to the player's score
	public void addPointsToScore(int points) {
		score += points;
	}
}
