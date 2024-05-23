package application;

import domain.Project;
import domain.ProjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		return projects;
	}

	@Override
	protected void saveDataToDB() {

		// dataList의 모든 Project를 DB에 저장
		
	}

}
