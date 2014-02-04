import java.util.Scanner;

public class Carcassonne {

	private Player player1;
	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out
				.println("Time flies like an arrow, fruit flies like a banana.");

		new Carcassonne();
	}

	public Carcassonne() {
		boolean validName;
		player1 = new Player();
		// TODO it will be trivial to let people input a variable number of
		// player names
		do {
			System.out.println("Please enter the name of player 1:");
			validName = player1.setName(sc.nextLine());
		} while (!validName);
		System.out
				.println("Only one player right now? Remember, games are better with friends!");
		System.out.println("Oh well, have fun " + player1.getName());
	}

}
