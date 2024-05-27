package application;

import domain.Account;

public class Application {
	
	// constructor
	public Application() {
		this.accountService = new AccountServiceImpl(this);
		this.projectService = new ProjectServiceImpl(this);
		this.issueService = new IssueServiceImpl(this);
		this.commentService = new CommentServiceImpl(this);
	}
	
	// variables
	private AccountServiceImpl accountService;
	private ProjectServiceImpl projectService;
	private IssueServiceImpl issueService;
	private CommentServiceImpl commentService;
	
	private String loggedInUser;
	private boolean loggedIn = false;
	
	// methods
	public void init() {
		accountService.loadDB();
		projectService.loadDB();
		issueService.loadDB();
		commentService.loadDB();
	}
	
	public void shutdown() {
		accountService.saveDB();
		projectService.saveDB();
		issueService.saveDB();
		commentService.saveDB();
	}
	
	public AccountServiceImpl getAccountService() {
		return accountService;
	}
	
	public ProjectServiceImpl getProjectService() {
		return projectService;
	}
	
	public IssueServiceImpl getIssueService() {
		return issueService;
	}
	
	public CommentServiceImpl getCommentService() {
		return commentService;
	}
	
	public boolean login(String id, String password) {
		Account account = accountService.getAccount(id);
		
		if (account != null && account.getPassword().equals(password)) {
			loggedInUser = id;
			loggedIn = true;
			return true;
		}
		return false;
	}
	
	public void logout() {
		loggedIn = false;
		loggedInUser = null;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public String getLoggedInUser() {
		return loggedInUser;
	}
	
}
