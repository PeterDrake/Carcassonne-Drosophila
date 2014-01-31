public class Player {
	
	private String name;

	public Player() {
		name = "";
	}

	public boolean setName(String newName) {
		// TODO "isEmpty()" should be changed to check whether it's whitespace instead of empty
		if(newName.isEmpty()) {
			return false;
		}
		name = newName;
		return true;
	}

	public String getName() {
		return name;
	}
}
