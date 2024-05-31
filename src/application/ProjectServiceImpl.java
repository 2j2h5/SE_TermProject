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
    }

	// variables
	private Application app;
	
	
	// methods
	@Override
	public boolean checkValidation() {
		String name = (String) attributeDict.get("name");
        String description = (String) attributeDict.get("description");
        String responsiblePL = (String) attributeDict.get("responsiblePL");
        
        System.out.println("ProjectService :: Valiation checking for"); 
        System.out.println("name: " + name);
        System.out.println("description: " + description);
        System.out.println("responsiblePL: " + responsiblePL);
        
        if (name == null || name.isEmpty()) {
        	System.out.println("ProjectService :: INVALID : Name is empty");
        	return false;
        }
        if (responsiblePL == null || responsiblePL.isEmpty()) {
        	System.out.println("ProjectService :: INVALID : Responsible PL is empty");
        	return false;
        }
        
        System.out.println("ProjectService :: VALID");
        return true;
	}
	
	@Override
	public void requestMake() throws ValidationException {
		System.out.println("ProjectService :: Making new project ...");
		if (this.checkValidation()) {
			String name = (String) attributeDict.get("name");
	        String description = (String) attributeDict.get("description");
	        String responsiblePL = (String) attributeDict.get("responsiblePL");
	        
			dataList.add(new Project(name, description, responsiblePL));
			System.out.println("ProjectService :: Successfully making new project!");
		} else {
			throw new ValidationException("ProejctService :: Validation failed");
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
    		String deleteSql = "DELETE FROM projects";
    		String insertSql = "INSERT INTO projects (id, name, description, responsiblePL) VALUES (?, ?, ?, ?)";

    		PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
    		PreparedStatement insertStatement = conn.prepareStatement(insertSql);
    		
    		deleteStatement.executeUpdate();
    		
    		for (Project project : dataList) {
    			insertStatement.setInt(1, project.getId());
        		insertStatement.setString(2, project.getName());
        		insertStatement.setString(3, project.getDescription());
        		insertStatement.setString(4, project.getResponsiblePL());
        		
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
	
	public Project getProjectById(int id) {
		for (Project project : dataList) {
        	if (project.getId() == id) {
        		return project;
        	}
        }
		
		return null;
	}
	
	public List<Project> getAllProjects() {
		return dataList;
	}

}
