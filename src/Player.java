public class Player {

	private String name;

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
}
