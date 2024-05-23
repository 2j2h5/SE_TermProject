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
		
		return issues;
	}

	@Override
	protected void saveDataToDB() {

		// dataList의 모든 Issue를 DB에 저장
		
	}

}
