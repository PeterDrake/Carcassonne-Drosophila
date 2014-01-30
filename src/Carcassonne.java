import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carcassonne {

	

	public static void main(String[] args) {
		System.out.println("Time flies like an arrow, fruit flies like a banana.");
	}
	private Scanner myScanner;
	
	public void Carcassonne(){
		try {
			myScanner = new Scanner(new File("fileDist.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("The filepath of the initial tiles is invalid");
			e.printStackTrace();
		}
		while (myScanner.hasNextInt()) {
	          int north = myScanner.nextInt();
	      }
	}

}
