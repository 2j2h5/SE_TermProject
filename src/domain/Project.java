package domain;

public class Project {
	
	// constructor
	public Project() {
		this.id = ++count;
	}
	
	public Project(String name, String description, int responsiblePL) {
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
	private int responsiblePL;
	
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
	
	public int getResponsiblePL() {
		return responsiblePL;
	}

}
