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
	public ProjectServiceImpl() {
		this.loadDataFromDB();
    }

	// variables
	
	
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
    		String sql = "INSERT INTO projects (id, name, description, responsiblePL) VALUES (?, ?, ?, ?)";

    		PreparedStatement statement = conn.prepareStatement(sql);
    		for (Project project : dataList) {
    			statement.setInt(1, project.getId());
        		statement.setString(2, project.getName());
        		statement.setString(3, project.getDescription());
        		statement.setString(4, project.getResponsiblePL());
        		
        		statement.executeUpdate();
       	 }

        	statement.close();
    	} catch (SQLException e) {
            e.printStackTrace();
    	} finally {
    		dbService.closeConnection();
    	}
	}

}
