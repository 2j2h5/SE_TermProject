package domain;

public class Account {
	
	// constructor
	public Account() {
		
	}
	
	public Account(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	// variables
	private String id;
	private String password;
	
	// methods
	public String getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
}
