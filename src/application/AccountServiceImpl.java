package application;

import domain.Account;
import domain.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		return accounts;
	}

	@Override
	protected void saveDataToDB() {
		
		// dataList의 모든 Account를 DB에 저장
		
	}

}
