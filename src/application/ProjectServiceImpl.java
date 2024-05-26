package application;

import domain.DBService;
import domain.Project;
import domain.ProjectService;
import exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService {
	
	// constructor
	public ProjectServiceImpl(Application app) {
		this.app = app;
		this.loadDataFromDB();
    }

	// variables
	private Application app;
	
	
	// methods
	@Override
	public boolean checkValidation() {
		String name = (String) attributeDict.get("name");
        //String description = (String) attributeDict.get("description");
        String responsiblePL = (String) attributeDict.get("responsiblePL");
        
        if (name == null || name.isEmpty()) return false;
        if (responsiblePL == null || responsiblePL.isEmpty()) return false;

        return true;
	}
	
	@Override
	public void requestMake() throws ValidationException {
		if (this.checkValidation()) {
			String name = (String) attributeDict.get("name");
	        String description = (String) attributeDict.get("description");
	        String responsiblePL = (String) attributeDict.get("responsiblePL");
	        
			dataList.add(new Project(name, description, responsiblePL));
		} else {
			throw new ValidationException("Validation failed");
		}
	}
	
	
	@Override
	public void notifyToPL() {
		//JavaMail API 사용해서 해당 PL에게 메일 보내기
	}

	@Override
	protected List<Project> loadDataFromDB() {
		List<Project> projects = new ArrayList<>();
		
    	DBService dbService = new DBService();
    	Connection conn = dbService.getConnection();

    	try {
    		String sql = "SELECT * FROM projects";

    		PreparedStatement statement = conn.prepareStatement(sql);
    		ResultSet resultSet = statement.executeQuery();

    		while (resultSet.next()) {
        		String name = resultSet.getString("name");
        		String description = resultSet.getString("description");
        		String responsiblePL = resultSet.getString("responsiblePL");
        		
        		Project project = new Project(name, description, responsiblePL);
        		
        		projects.add(project);
    		}

    		resultSet.close();
    		statement.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		dbService.closeConnection();
    	}
		
		return projects;
	}

	@Override
	protected void saveDataToDB() {

		DBService dbService = new DBService();
    	Connection conn = dbService.getConnection();

    	try {
    		String checkSql = "SELECT COUNT(*) FROM projects WHERE id = ?";
    		String insertSql = "INSERT INTO projects (id, name, description, responsiblePL) VALUES (?, ?, ?, ?)";

    		PreparedStatement checkStatement = conn.prepareStatement(checkSql);
    		PreparedStatement insertStatement = conn.prepareStatement(insertSql);
    		for (Project project : dataList) {
    			checkStatement.setInt(1, project.getId());
    			ResultSet rs = checkStatement.executeQuery();
    			rs.next();
    			int count = rs.getInt(1);
    			rs.close();
    			
    			if (count == 0) {
	    			insertStatement.setInt(1, project.getId());
	        		insertStatement.setString(2, project.getName());
	        		insertStatement.setString(3, project.getDescription());
	        		insertStatement.setString(4, project.getResponsiblePL());
	        		
	        		insertStatement.executeUpdate();
    			}
       	 	}
    		
			checkStatement.close();
			insertStatement.close();
			
    	} catch (SQLException e) {
            e.printStackTrace();
    	} finally {
    		dbService.closeConnection();
    	}
	}
	
	public Project getProjectById(int id) {
		for (Project project : dataList) {
        	if (project.getId() == id) {
        		return project;
        	}
        }
		
		return null;
	}

}
