package domain;

public class Issue {
	
	// constructor
	public Issue() {
		this.id = ++count;
	}
	
	public Issue(String title, String description, String priority, int involvedProject, String reporter, String reportedDate, String state) {
		this.id = ++count;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.involvedProject = involvedProject;
		this.reporter = reporter;
		this.reportedDate = reportedDate;
	}
	
	// variables
	private int count = 0;
	private int id;
	private String title;
	private String description;
	private String priority;
	private int involvedProject;
	private String reporter;
	private String reportedDate;
	private String state;
	private String fixer;
	private String assignee;
	
	// methods
	public int getCount() {
		return count;
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public int getProject() {
		return involvedProject;
	}
	
	public String getReporter() {
		return reporter;
	}
	
	public String getReportedDate() {
		return reportedDate;
	}
	
	public String getState() {
		return state;
	}
	
	public String getFixer() {
		return fixer;
	}
	
	public String getAssignee() {
		return assignee;
	}
	
	public void setReporter(String reporterId) {
		this.reporter = reporterId;
	}
	
	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setFixer(String fixerId) {
		this.fixer = fixerId;
	}
	
	public void setAssignee(String assigneeId) {
		this.assignee = assigneeId;
	}
}
