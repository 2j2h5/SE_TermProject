package application;

import domain.DBService;
import domain.Issue;
import domain.IssueService;
import exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class IssueServiceImpl extends BaseServiceImpl<Issue> implements IssueService {
	
	// constructor
	public IssueServiceImpl(Application app) {
		this.app = app;
    }
	
	// variables
	private Application app;
	
	// methods
	@Override
	public boolean checkValidation() {
		String title = (String) attributeDict.get("title");
        String description = (String) attributeDict.get("description");
        
        if (title == null || title.isEmpty()) return false;
        if (description == null || description.isEmpty()) return false;

        return true;
	}
	
	@Override
	public void requestMake() throws ValidationException {
		if (this.checkValidation()) {
			String title = (String) attributeDict.get("title");
	        String description = (String) attributeDict.get("description");
	        String priority = (String) attributeDict.get("priority");
	        int involvedProject = (int) attributeDict.get("involvedProject");
	        String reporter = app.getLoggedInUser();
	        String reportedDate = LocalDateTime.now().format(dateFormatter);
	        String state = "new";
	        
			dataList.add(new Issue(title, description, priority, involvedProject, reporter, reportedDate, state));
		} else {
			throw new ValidationException("Validation failed");
		}
	}
	
	@Override
	public List<Issue> requestBrowse() {
		try {
			List<Issue> matchingIssues = new ArrayList<>();
			int id = (int) attributeDict.get("id");
			String title = (String) attributeDict.get("title");
	        String priority = (String) attributeDict.get("priority");
	        int involvedProject = (int) attributeDict.get("involvedProject");
	        String state = (String) attributeDict.get("state");
	        String assignee = (String) attributeDict.get("assignee");
	        String reporter = (String) attributeDict.get("reporter");
	        String fixer = (String) attributeDict.get("fixer");
	        
	        for (Issue issue : dataList) {
	        	if (id == 0 || issue.getId() == id) {
	        		if (title == null || (issue.getTitle() != null && issue.getTitle().equals(title))) {
	        			if (priority == null || (issue.getPriority() != null && issue.getPriority().equals(priority))) {
	        				if (involvedProject == 0 || issue.getProject() == involvedProject) {
	                			if (state == null || (issue.getState() != null && issue.getState().equals(state))) {
	                				if (assignee == null || (issue.getAssignee() != null && issue.getAssignee().equals(assignee))) {
	                					if (reporter == null || (issue.getReporter() != null && issue.getReporter().equals(reporter))) {
	                						if (fixer == null || (issue.getFixer() != null && issue.getFixer().equals(fixer))) {
	                            				matchingIssues.add(issue);
	                            			}
	                        			}
	                    			}
	                			}
	                		}
	            		}
	        		}
	        	}
	        }
		
	        return matchingIssues;
		} catch (ClassCastException | NullPointerException | NumberFormatException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	@Override
	public void requestEdit(int id) throws ValidationException {
		if (this.checkValidation()) {
			String title = (String) attributeDict.get("title");
	        String description = (String) attributeDict.get("description");
	        String priority = (String) attributeDict.get("priority");
	        String state = (String) attributeDict.get("state");
	        String assignee = (String) attributeDict.get("assignee");
	        String fixer = null;
	        
	        if (assignee != null && state == "new") {
	        	state = "assigned";
	        }
	        
	        if (state == "fixed") {
	        	fixer = app.getLoggedInUser();
	        }
	        
	        Issue issue = app.getIssueService().getIssueById(id);
	        if (!issue.getTitle().equals(title)) issue.setTitle(title);
	        if (!issue.getDescription().equals(description)) issue.setDescription(description);
	        if (!issue.getPriority().equals(priority)) issue.setPriority(priority);
	        if (!issue.getState().equals(state)) issue.setState(state);
	        if ((issue.getAssignee() == null && assignee != null) || (issue.getAssignee() != null && !issue.getAssignee().equals(assignee))) issue.setAssignee(assignee);
	        if ((issue.getFixer() == null && fixer != null) || (issue.getFixer() != null && !issue.getFixer().equals(fixer))) issue.setFixer(fixer);
	        
		} else {
			throw new ValidationException("Validation failed");
		}
	}
	
	@Override
	public void notifyToPL() {
		
	}
	
	@Override
	public void notifyToDev() {
		
	}

	@Override
	protected List<Issue> loadDataFromDB() {
		List<Issue> issues = new ArrayList<>();
		
    	DBService dbService = new DBService();
    	Connection conn = dbService.getConnection();

   		try {
    		String sql = "SELECT * FROM issues";

    		PreparedStatement statement = conn.prepareStatement(sql);
    		ResultSet resultSet = statement.executeQuery();

    		// 결과
    		while (resultSet.next()) {
        		String title = resultSet.getString("title");
        		String description = resultSet.getString("description");
       	 		String priority = resultSet.getString("priority");
       	 		int involvedProject = resultSet.getInt("involvedProject");
       	 		String reporter = resultSet.getString("reporter");
       	 		String reportedDate = resultSet.getString("reportedDate");
       	 		String state = resultSet.getString("state");
       	 		String fixer = resultSet.getString("fixer");
       	 		String assignee = resultSet.getString("assignee");
       	 		
        		Issue issue = new Issue(title, description, priority, involvedProject, reporter, reportedDate, state);
        		issue.setReporter(reporter);
        		issue.setReportedDate(reportedDate);
        		issue.setState(state);
        		issue.setFixer(fixer);
        		issue.setAssignee(assignee);
        		
        		issues.add(issue);
    		}

    		resultSet.close();
    		statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbService.closeConnection();
		}
		
		return issues;
	}

	@Override
	protected void saveDataToDB() {
		
		DBService dbService = new DBService();
    	Connection conn = dbService.getConnection();

    	try {
    		String deleteSql = "DELETE FROM issues";
    		String insertSql = "INSERT INTO issues (id, title, description, priority, involvedProject, reporter, reportedDate, state, fixer, assignee) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    		PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
    		PreparedStatement insertStatement = conn.prepareStatement(insertSql);
    		
    		deleteStatement.executeUpdate();
    		
    		for (Issue issue : dataList) {
    			insertStatement.setInt(1, issue.getId());
        		insertStatement.setString(2, issue.getTitle());
        		insertStatement.setString(3, issue.getDescription());
        		insertStatement.setString(4, issue.getPriority());
        		insertStatement.setInt(5, issue.getProject());
        		insertStatement.setString(6, issue.getReporter());
        		insertStatement.setString(7, issue.getReportedDate());
        		insertStatement.setString(8, issue.getState());
        		insertStatement.setString(9, issue.getFixer());
        		insertStatement.setString(10, issue.getAssignee());
        		
        		insertStatement.executeUpdate();
    		}

    		deleteStatement.close();
    		insertStatement.close();
    		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
    		dbService.closeConnection();
		}
		
	}
	
	public Issue getIssueById(int id) {
		for (Issue issue : dataList) {
        	if (issue.getId() == id) {
        		return issue;
        	}
        }
		
		return null;
	}

	public List<Issue> getAllIssues() {
		return dataList;
	}

}
