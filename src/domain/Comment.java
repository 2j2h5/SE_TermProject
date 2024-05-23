package domain;

public class Comment {
	
	// constructor
	public Comment() {
		
	}
	
	public Comment(String content, Account writer, String writedDate, Issue involvedIssue) {
		this.content = content;
		this.writer = writer;
		this.writedDate = writedDate;
		this.involvedIssue = involvedIssue;
	}
	
	// variables
	private String content;
	private Account writer;
	private String writedDate;
	private Issue involvedIssue; 
	
	// methods
	public String getContent() {
		return content;
	}
	
	public Account getWriter() {
		return writer;
	}
	
	public String getWritedDate() {
		return writedDate;
	}
	
	public Issue getIssue() {
		return involvedIssue;
	}

}
