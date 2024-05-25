package application;

import domain.Issue;
import domain.IssueService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IssueServiceImpl extends BaseServiceImpl<Issue> implements IssueService {
	
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
	public void requestBrowse() {
		
	}
	
	@Override
	public void requestEdit() {
		
	}
	
	@Override
	public void requestAssign() {
		
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
		
		//DB의 모든 Issue를 불러옴
		// 데이터베이스 연결
        	DBService dbService = new DBService();
        	Connection conn = dbService.getConnection();

       		try {
            		// SQL 쿼리
            		String sql = "SELECT * FROM issues";

            		// SQL 문 실행
            		PreparedStatement statement = conn.prepareStatement(sql);
            		ResultSet resultSet = statement.executeQuery();

            		// 결과
            		while (resultSet.next()) {
                		String name = resultSet.getString("name");
                		String description = resultSet.getString("description");
               	 		String responsiblePL = resultSet.getString("responsiblePL");

                		// Issue 객체 생성 후 리스트에 추가
                		Issue issue = new Issue(name, description, responsiblePL);
                		issues.add(issue);
            		}

            		resultSet.close();
            		statement.close();
        		} catch (SQLException e) {
            			e.printStackTrace();
        		} finally {
           			// 연결 종료
            			dbService.closeConnection();
        		}
		
		return issues;
	}

	@Override
	protected void saveDataToDB() {

		// dataList의 모든 Issue를 DB에 저장
		// DB 연결
		DBService dbService = new DBService();
        	Connection conn = dbService.getConnection();

        	try {
           	 	// SQL문
            		String sql = "INSERT INTO issues (name, description, responsiblePL) VALUES (?, ?, ?)";

            		// SQL 문 실행 후 저장
            		PreparedStatement statement = conn.prepareStatement(sql);
            		for (Issue issue : dataList) {
                		statement.setString(1, issue.getName());
                		statement.setString(2, issue.getDescription());
                		statement.setString(3, issue.getResponsiblePL());
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
