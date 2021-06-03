package cpsc329FinalProject;


// Imports gameLogic & gameGUI
// Handles the operations between the two classes
// Contains Variables needed by both classes (Stage #, Attempts, etc)
public class gameRunner {
	public static void main(String[] args) {
		gameLogic gameL = new gameLogic();
		int ASCII = 0;
		do {
		ASCII = gameL.generateChar(4);
		System.out.println(Character.toString((char) ASCII));
		} while (ASCII != 34);
	}
}
