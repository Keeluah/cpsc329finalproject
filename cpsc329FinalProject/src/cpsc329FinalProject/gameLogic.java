package cpsc329FinalProject;

import java.util.ArrayList;
import java.util.Random;

// ASCII Table to be Used
// 33, 35-38, 40-43, 45 Special Characters (!, #, $, %, &, (, ), *, +, -) -- Can be modified if needed (10 Char)
// 48-57 Numerical (0-9) -- (10 Char)
// 65-90 Alphabetical (Capitals) -- (26 Char)
// 97-122 Alphabetical (Lowercases) -- (26 Char)
public class gameLogic {
	
	// Constructor for gameLogic
	public gameLogic() {
		
	}
	
	/* Function: generateChar
	 * Parameters: int selection
	 * Generates one random integer between a range (with some values excluded inside that range)
	 * and returns that integer to the user.
	 * Returns: int
	 */
	public int generateChar(int selection) {
		// REF:
		// https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
		// https://stackoverflow.com/questions/6443176/how-can-i-generate-a-random-number-within-a-range-but-exclude-some/6443346
		Random rand = new Random();
		int max = 0;
		int min = 0;
		int randomChar = 0;
		
		// Switch statement for selection, to decide which 'range' to go with
		switch(selection) {
		case 1:
			// Lowercases
			// ASCII Table for lowercases is the range 97-122
			min = 97;
			max = 122;
			// Generate an int within that range
			randomChar = min + rand.nextInt(max - min + 1);
			// Return it to caller
			return(randomChar);
		case 2:
			// Lower+Caps
			// ASCII Table for lowercases and capitals is the range 65 to 122
			min = 65;
			max = 122;
			// Exclude the following values, as they are not required
			int[] excludeAr1 = {91, 92, 93, 94, 95, 96};
			
			// Generate an int within that range, excluding those values above
			randomChar = min + rand.nextInt(max - min + 1 - excludeAr1.length);
			for (int excludeVal : excludeAr1) {
				if (randomChar < excludeVal) {
					break;
				}
				randomChar++;
			}
			// Return it to caller
			return(randomChar);
		case 3:
			// Lower+Caps+Nums
			// ASCII Table for lowercases, capitals, and numbers is the range 48 to 122
			min = 48;
			max = 122;
			// Exclude the following values, as they are not required
			int[] excludeAr2 = {58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96};
			
			// Generate an int within that range, excluding those values above
			randomChar = min + rand.nextInt(max - min + 1 - excludeAr2.length);
			for (int excludeVal : excludeAr2) {
				if (randomChar < excludeVal) {
					break;
				}
				randomChar++;
			}
			// Return it to caller
			return(randomChar);
		case 4:
			// Lower+Caps+Nums+Specs
			// 33, 35-38, 40-43, 45 Special Characters (!, #, $, %, &, (, ), *, +, -) -- Can be modified if needed (10 Char)
			// ASCII Table for lowercases, capitals, numbers, and special characters is the range 33 to 122
			min = 33;
			max = 122;
			// Exclude the following values, as they are not required
			int[] excludeAr3 = {34, 39, 44, 46, 47, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96};
			
			// Generate an int within that range, excluding those values above
			randomChar = min + rand.nextInt(max - min + 1 - excludeAr3.length);
			for (int excludeVal : excludeAr3) {
				if (randomChar < excludeVal) {
					break;
				}
				randomChar++;
			}
			// Return it to caller
			return(randomChar);
		default:
			return(randomChar);
		}
	}
	
	/* Function: calcSelection
	 * Parameters: int rounds
	 * Finds an integer based on the parameter 'rounds' and returns it to caller
	 * Returns: int
	 */
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
	
	/* Function: createPW
	 * Parameters: int round, int pLength
	 * Using round and pLength, create a String of size pLength and with random characters
	 * based on the round (by finding 'selection').
	 * Returns: String
	 */
	// Default 'pLength' is 10, can be modified in future for dynamic, if needed.
	public String createPW(int round, int pLength) {
		// Password declaration
		String pWord = "";
		// calculate the Selection based on which round it is.
		int currentSelection = calcSelection(round);
		// For the password length, add the character generated to the password after converting it from integer.
		for (int i = 0; i < pLength; i++) {
			pWord = pWord + (Character.toString((char) generateChar(currentSelection)));
		}
		// Return the password
		return(pWord);
	}
	
	/* Function: genLvl
	 * Parameters: int round, int pLength, int lr, int hr
	 * Creates an encryption key based on parameters lr and hr, and also
	 * calls createPW() to get the plaintext password. Using these two,
	 * it creates the encrypted password, stores it all in pwdStruct, and returns it to caller
	 * Returns: pwdStruct
	 */
	public pwdStruct genLvl(int round, int pLength, int lr, int hr) {
		// create a Password
		String password = createPW(round, pLength);
		// Random encryption key based on lr and hr
		Random r = new Random();
		int limit = hr - lr + 1;
		int key = 0;
		while(key == 0) key = lr + r.nextInt(limit);
		// Encrypt the password
		String encrypted = encrypt(password, key);
		// Create a pwdStruct with all of the above
		pwdStruct toReturn = new pwdStruct(password, encrypted, key);
		// Return the pwdStruct
		return toReturn;
	}
	
	/* Function: encrypt
	 * Parameters: String pwd, int key
	 * Encrypts the password using the key, translate it back into a String, and returns it to caller
	 * Returns: String
	 */
	public String encrypt(String pwd, int key) {
		// Declare Empty String
		String toReturn = "";
		// For the length of the password (pwd)
		for(int i = 0; i < pwd.length(); i++) {
			// Grab every single character, convert it into ASCII (int)
			// and encrypt it by adding the key to it.
			int c = (int)pwd.charAt(i) + key;
			// Add the value created to the Empty String by converting it
			// back into a char
			toReturn = toReturn + Character.toString((char) c);
		}
		// Return the encrypted password.
		return toReturn;
	}
}
