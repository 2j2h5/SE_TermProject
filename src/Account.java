
public class Account {
	
	// constructor
	public Account() {
		
	}
	
	public Account(String ID, String password) {
		this.ID = ID;
		this.password = password;
	}
	
	// variables
	private String ID;
	private String password;
	
	// methods
	public String getID() {
		return ID;
	}
	
	public String getPassword() {
		return password;
	}
}
