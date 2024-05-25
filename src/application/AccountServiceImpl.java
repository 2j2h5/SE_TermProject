package application;

import domain.Account;
import domain.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	
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
	protected List<Account> loadDataFromDB() {
		
		List<Account> accounts = new ArrayList<>();
		
		//DB의 모든 Account를 불러옴
		DBService dbService = new DBService();
       		Connection conn = dbService.getConnection();

        	try {
			//데이터베이스 테이블에서 모든 계정 선택
            		String sql = "SELECT * FROM accounts";

            		// SQL 문 실행
            		PreparedStatement statement = conn.prepareStatement(sql);
            		ResultSet resultSet = statement.executeQuery();

            		// 결과
            		while (resultSet.next()) {
               			String ID = resultSet.getString("ID");
              			String password = resultSet.getString("password");
		
                		// Account 객체 생성 후 리스트에 추가
                		Account account = new Account(ID, password);
               	 		accounts.add(account);
           		 }

           		resultSet.close();
           		statement.close();
       		} catch (SQLException e) {
            		e.printStackTrace();
        	} finally {
            		// 연결 종료
            		dbService.closeConnection();
        	}
		
		return accounts;
	}

	@Override
	protected void saveDataToDB() {
		
		// dataList의 모든 Account를 DB에 저장
		DBService dbService = new DBService();
        	Connection conn = dbService.getConnection();

        	try {
            		// 데이터베이스에 저장을 위한 SQL 문
            		String sql = "INSERT INTO accounts (ID, password) VALUES (?, ?)";

            		// 추가
            		PreparedStatement statement = conn.prepareStatement(sql);
            		for (Account account : dataList) {
                		statement.setString(1, account.getID());
                		statement.setString(2, account.getPassword());
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
