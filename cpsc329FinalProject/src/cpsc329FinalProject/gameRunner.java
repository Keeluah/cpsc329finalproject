package cpsc329FinalProject;

import java.util.ArrayList;
import java.util.Scanner;
// Imports gameLogic & gameGUI
// Handles the operations between the two classes
// Contains Variables needed by both classes (Stage #, Attempts, etc)
public class gameRunner {
	public static void main(String[] args) {
		// Declaring gameLogic and levels ArrayList
		gameLogic gameL = new gameLogic();
		ArrayList<pwdStruct> levels = new ArrayList<pwdStruct>();
		
		// Declare Total number of Levels
		int totalLevels = 10;
		// Array storing the time spent on each stage
		double times[] = new double[totalLevels];
		
		// Add the total number of levels to the ArrayList
		for(int i = 0; i < totalLevels; i++) {
			levels.add(gameL.genLvl(i, 10, -4, 4));
		}
		
		// Create the GUI and present it to the user
		gameGUI mGUI = new gameGUI(levels, times, totalLevels);
		
	}
}
