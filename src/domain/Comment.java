package domain;

public class Comment {
	
	// constructor
	public Comment() {
		this.id = ++count;
	}
	
	public Comment(String content, String writerId, String writedDate, int involvedIssue) {
		this.id = ++count;
		this.content = content;
		this.writer = writerId;
		this.writedDate = writedDate;
		this.involvedIssue = involvedIssue;
	}
	
	// variables
	private static int count = 0;
	private int id;
	private String content;
	private String writer;
	private String writedDate;
	private int involvedIssue; 
	
	// methods
	public int getCount() {
		return count;
	}
	
	public int getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getWritedDate() {
		return writedDate;
	}
	
	public int getIssue() {
		return involvedIssue;
	}

}
