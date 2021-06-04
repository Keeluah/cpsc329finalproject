package cpsc329FinalProject;

import java.util.ArrayList;
import java.util.Random;

// ASCII Table to be Used
// 33, 35-38, 40-43, 45 Special Characters (!, #, $, %, &, (, ), *, +, -) -- Can be modified if needed (10 Char)
// 48-57 Numerical (0-9) -- (10 Char)
// 65-90 Alphabetical (Capitals) -- (26 Char)
// 97-122 Alphabetical (Lowercases) -- (26 Char)
public class gameLogic {
	
	public gameLogic() {
		
	}
	
	public int generateChar(int selection) {
		// REF:
		// https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
		// https://stackoverflow.com/questions/6443176/how-can-i-generate-a-random-number-within-a-range-but-exclude-some/6443346
		Random rand = new Random();
		int max = 0;
		int min = 0;
		int randomChar = 0;
		
		switch(selection) {
		case 1:
			// Lowercases
			min = 97;
			max = 122;
			randomChar = min + rand.nextInt(max - min + 1);
			return(randomChar);
		case 2:
			// Lower+Caps
			min = 65;
			max = 122;
			int[] excludeAr1 = {91, 92, 93, 94, 95, 96};
			
			randomChar = min + rand.nextInt(max - min + 1 - excludeAr1.length);
			for (int excludeVal : excludeAr1) {
				if (randomChar < excludeVal) {
					break;
				}
				randomChar++;
			}
			return(randomChar);
		case 3:
			// Lower+Caps+Nums
			// 33, 35-38, 40-43, 45 Special Characters (!, #, $, %, &, (, ), *, +, -) -- Can be modified if needed (10 Char)
			min = 48;
			max = 122;
			int[] excludeAr2 = {58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96};
			
			randomChar = min + rand.nextInt(max - min + 1 - excludeAr2.length);
			for (int excludeVal : excludeAr2) {
				if (randomChar < excludeVal) {
					break;
				}
				randomChar++;
			}
			return(randomChar);
		case 4:
			// Lower+Caps+Nums+Specs
			min = 33;
			max = 122;
			int[] excludeAr3 = {34, 39, 44, 46, 47, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96};
			
			randomChar = min + rand.nextInt(max - min + 1 - excludeAr3.length);
			for (int excludeVal : excludeAr3) {
				if (randomChar < excludeVal) {
					break;
				}
				randomChar++;
			}
			return(randomChar);
		default:
			return(randomChar);
		}
	}
	
	public int calcSelection(int rounds) {
		// Current Round Setup:
		// 1-2 -- Very Easy (Lowers)
		// 3-4 -- Easy (Lower+Caps)
		// 5-7 -- Normal (Lower + Caps + Nums)
		// 8-10 -- Hard (Lower + Caps + Nums)
		int veasy = 1, easy = 2, norm = 3, hard = 4;
		
		switch(rounds) {
		case 1:
			return(veasy);
		case 2:
			return(veasy);
		case 3:
			return(easy);
		case 4:
			return(easy);
		case 5:
			return(norm);
		case 6:
			return(norm);
		case 7:
			return(norm);
		case 8:
			return(hard);
		case 9:
			return(hard);
		case 10:
			return(hard);
		default:
			// If the rounds are messed up.
			return(veasy);
		}
	}
	
	// Default 'pLength' is 10, can be modified in future for dynamic, if needed.
	public ArrayList<Integer> createPW(int round, int pLength) {
		ArrayList pWord = new ArrayList<Integer>();
		int currentSelection = calcSelection(round);
		for (int i = 0; i < pLength; i++) {
			pWord.add(generateChar(currentSelection));
		}
		return(pWord);
	}
}
