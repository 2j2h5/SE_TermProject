package application;

import domain.Account;
import domain.AccountService;
import domain.DBService;
import exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {
	
	// constructor
	public AccountServiceImpl() {
		this.loadDataFromDB();
    }

	// variables
	
	// methods
	@Override
	public boolean checkValidation() {
		String id = (String) attributeDict.get("ID");
        String password = (String) attributeDict.get("password");
        
        if (id == null || id.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;
        
        for (Account account : dataList) {
        	if (account.getId().equals(id) ) {
        		return false;
        	}
        }

        return true;
	}
	
	@Override
	public void requestMake() throws ValidationException {
		if (this.checkValidation()) {
			String id = (String) attributeDict.get("ID");
	        String password = (String) attributeDict.get("password");
	        
			dataList.add(new Account(id, password));
		} else {
			throw new ValidationException("Validation failed");
		}
	}

	@Override
	protected List<Account> loadDataFromDB() {
		
		List<Account> accounts = new ArrayList<>();
		
		DBService dbService = new DBService();
   		Connection conn = dbService.getConnection();

    	try {
    		String sql = "SELECT * FROM accounts";

    		PreparedStatement statement = conn.prepareStatement(sql);
    		ResultSet resultSet = statement.executeQuery();

    		while (resultSet.next()) {
       			String id = resultSet.getString("id");
      			String password = resultSet.getString("password");
        		Account account = new Account(id, password);
        		
       	 		accounts.add(account);
   		 }

       		resultSet.close();
       		statement.close();
   		} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		dbService.closeConnection();
    	}
		
		return accounts;
	}

	@Override
	protected void saveDataToDB() {
		
		DBService dbService = new DBService();
    	Connection conn = dbService.getConnection();

    	try {
    		String sql = "INSERT INTO accounts (id, password) VALUES (?, ?)";

    		PreparedStatement statement = conn.prepareStatement(sql);
    		for (Account account : dataList) {
        		statement.setString(1, account.getId());
        		statement.setString(2, account.getPassword());
        		
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
