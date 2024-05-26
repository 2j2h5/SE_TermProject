package domain;

public class Project {
	
	// constructor
	public Project() {
		this.id = ++count;
	}
	
	public Project(String name, String description, String responsiblePL) {
		this.id = ++count;
		this.name = name;
		this.description = description;
		this.responsiblePL = responsiblePL;
	}
	
	// variables
	private static int count = 0;
	private int id;
	private String name;
	private String description;
	private String responsiblePL;
	
	// methods
	public int getCount() {
		return count;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getResponsiblePL() {
		return responsiblePL;
	}

}
