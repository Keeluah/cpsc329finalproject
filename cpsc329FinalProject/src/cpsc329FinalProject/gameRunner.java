package cpsc329FinalProject;

import java.util.Scanner;
// Imports gameLogic & gameGUI
// Handles the operations between the two classes
// Contains Variables needed by both classes (Stage #, Attempts, etc)
public class gameRunner {
	public static void main(String[] args) {
		gameLogic gameL = new gameLogic();
		//gameGUI mGUI = new gameGUI();
		//int ASCII = 0;
		Scanner in = new Scanner(System.in);
		int passed = 0;
		int totalLevels = 10;
		double times[] = new double[totalLevels];
		for(int i = 0; i < totalLevels; i++) {
			pwdStruct level = gameL.genLvl(i, 10, -4, 4);
			int tries = 3;
			double start = System.currentTimeMillis();
			boolean lvlComplete = false;
			while(tries > 0 && !lvlComplete) {
				System.out.println("Level: " + (i+1) );
				System.out.println("Password: " + level.getEncryptedPassword());
				System.out.println("Key: " + level.getKey());
				System.out.println("Attempts remaining: " + tries);
				System.out.println('\n' + "Enter the plaintext password below");
				String userIn = in.nextLine();
				if(userIn.compareTo(level.getPassword()) == 0) {
					double end = System.currentTimeMillis();
					times[i] = end - start;
					lvlComplete = true;
					System.out.println("Correct!\n");
				} else {
					tries--;
					System.out.println("Incorrect!\n");
				}
			}
			if(!lvlComplete) {
				times[i] = -1;
			}
		}
		
		System.out.println("\nFINAL TIMES");
		for(int i = 0; i < totalLevels; i++) {
			float timeInSeconds;
			if(times[i] >= 0) {
				timeInSeconds = (float)times[i] / 1000;
				System.out.println("Level " + i + ": " + timeInSeconds);
			} else {
				System.out.println("Level " + i + ": Incomplete");
			}
		}
	}
}
