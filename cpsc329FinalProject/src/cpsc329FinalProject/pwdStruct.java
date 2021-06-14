package cpsc329FinalProject;

// Structure that stores both the encrypted and plaintext password, and the key.
public class pwdStruct {
	private String pwd, encpwd;
	private int enc;
	
	// Constructor for pwdStruct
	public pwdStruct(String p, String ep, int e) {
		// Set inputs to the private locals
		pwd = p;
		encpwd = ep;
		enc = e;
	}
	
	/* Function: getPassword
	 * Parameters: none
	 * Retrieves the plaintext password and returns to caller
	 * Returns: String
	 */
	public String getPassword() {
		return new String(pwd);
	}
	
	/* Function: getEncryptedPassword
	 * Parameters: none
	 * Retrieves the encrypted password and returns to caller
	 * Returns: String
	 */
	public String getEncryptedPassword() {
		return new String(encpwd);
	}
	
	/* Function: getKey
	 * Parameters: none
	 * Retrieves the key of the encryption and returns to caller
	 * Returns: int
	 */
	public int getKey() {
		return enc;
	}
}
