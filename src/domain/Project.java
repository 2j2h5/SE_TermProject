package domain;

public class Project {
	
	// constructor
	public Project() {
		
	}
	
	public Project(String name, String description, Account responsiblePL) {
		this.name = name;
		this.description = description;
		this.responsiblePL = responsiblePL;
	}
	
	// variables
	private String name;
	private String description;
	private Account responsiblePL;
	
	// methods
	public String getName() {
		return name;
	}
	
	public String getDesc() {
		return description;
	}
	
	public Account getPL() {
		return responsiblePL;
	}

}
