package application;

import domain.Project;
import domain.ProjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService {
	
	// constructor

	// variables
	
	// methods
	@Override
	public boolean checkValidation(Map<String, Object> attributeDict) {
		return true;
	}
	
	@Override
	public void requestMake() {
		
	}
	
	
	@Override
	public void notifyToPL() {
		
	}

	@Override
	protected List<Project> loadDataFromDB() {
		List<Project> projects = new ArrayList<>();
		
		//DB의 모든 Project를 불러옴
		// 데이터베이스 연결
        	DBService dbService = new DBService();
        	Connection conn = dbService.getConnection();

        	try {
            		// SQL 쿼리
            		String sql = "SELECT * FROM projects";

            		// SQL 문 실행
            		PreparedStatement statement = conn.prepareStatement(sql);
            		ResultSet resultSet = statement.executeQuery();

            		// 결과
            		while (resultSet.next()) {
                		String name = resultSet.getString("name");
                		String description = resultSet.getString("description");
                		String responsiblePL = resultSet.getString("responsiblePL");

                		// Project 객체 생성 후 리스트에 추가
                		Project project = new Project(name, description, responsiblePL);
                		projects.add(project);
            		}

            		resultSet.close();
            		statement.close();
        	} catch (SQLException e) {
            		e.printStackTrace();
        	} finally {
            		// 연결 종료
            		dbService.closeConnection();
        	}
		
		return projects;
	}

	@Override
	protected void saveDataToDB() {

		// dataList의 모든 Project를 DB에 저장
		// DB 연결
		DBService dbService = new DBService();
        	Connection conn = dbService.getConnection();

        	try {
            		// SQL 문
            		String sql = "INSERT INTO projects (name, description, responsiblePL) VALUES (?, ?, ?)";

            		// SQL 쿼리 실행
            		PreparedStatement statement = conn.prepareStatement(sql);
            		for (Project project : dataList) {
                		statement.setString(1, project.getName());
                		statement.setString(2, project.getDescription());
                		statement.setString(3, project.getResponsiblePL());
                		statement.executeUpdate();
           	 }

            	statement.close();
        	} catch (SQLException e) {
		            e.printStackTrace();
        	} finally {
            		// 연결 종료
            		dbService.closeConnection();
        	}
	}

}
