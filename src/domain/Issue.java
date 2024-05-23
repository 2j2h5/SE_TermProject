package domain;

public class Issue {
	
	// constructor
	public Issue() {
		
	}
	
	public Issue(String title, String description, String priority, Project involvedProject) {
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.involvedProject = involvedProject;
	}
	
	// variables
	private String title;
	private String description;
	private String priority;
	private Project involvedProject;
	private Account reporter;
	private String reportedDate;
	private String state;
	private Account fixer;
	private Account assignee;
	
	// methods
	public String getTitle() {
		return title;
	}
	
	public String getDesc() {
		return description;
	}
	
	public String getPriority() {
		return priority;
	}
	
	public Project getProject() {
		return involvedProject;
	}
	
	public Account getReporter() {
		return reporter;
	}
	
	public String getReportedDate() {
		return reportedDate;
	}
	
	public String getState() {
		return state;
	}
	
	public Account getFixer() {
		return fixer;
	}
	
	public Account getAssignee() {
		return assignee;
	}
	
	public void setReporter(Account reporter) {
		this.reporter = reporter;
	}
	
	public void setReportedDate(String reportedDate) {
		this.reportedDate = reportedDate;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setFixer(Account fixer) {
		this.fixer = fixer;
	}
	
	public void setAssignee(Account assignee) {
		this.assignee = assignee;
	}
}
