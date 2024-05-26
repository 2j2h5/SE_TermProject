package application;

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
	
}
