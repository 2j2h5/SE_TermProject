package application;

import domain.AccountService;
import domain.CommentService;
import domain.IssueService;
import domain.ProjectService;

public class Application {
	
	// constructor
	public Application() {
		accountService = new AccountServiceImpl();
		projectService = new ProjectServiceImpl();
		issueService = new IssueServiceImpl();
		commentService = new CommentServiceImpl();
	}
	
	// variables
	private AccountService accountService;
	private ProjectService projectService;
	private IssueService issueService;
	private CommentService commentService;
	
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
	
}
