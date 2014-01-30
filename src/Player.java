public class Player {
	
	private String name;

	public Player() {
		name = "";
	}
	
	public Player(String newName) {
		name = newName;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}
}
