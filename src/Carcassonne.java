import java.util.Scanner;

public class Carcassonne {

	private Player player1;
	private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Time flies like an arrow, fruit flies like a banana.");
		
		new Carcassonne();
	}
	
	public Carcassonne() {
		player1 = new Player();
		
		System.out.println("Please enter the name of player 1:");
		player1.setName(sc.nextLine());
		
		System.out.println("Only one player right now? Remember, games are better with friends!");
		System.out.println("Oh well, have fun " + player1.getName());
	}

}
