package cpsc329FinalProject;

public class pwdStruct {
	private String pwd, encpwd;
	private int enc;
	
	public pwdStruct(String p, String ep, int e) {
		pwd = p;
		encpwd = ep;
		enc = e;
	}
	
	public String getPassword() {
		return new String(pwd);
	}
	
	public String getEncryptedPassword() {
		return new String(encpwd);
	}
	
	public int getKey() {
		return enc;
	}
}
