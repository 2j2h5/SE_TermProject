package domain;

import java.util.List;

import exceptions.ValidationException;

public interface IssueService extends BaseService {
	
	// interfaces
	void requestMake() throws ValidationException;
	List<Issue> requestBrowse();
	void requestEdit(int id) throws ValidationException;
	
	void notifyToPL();
	void notifyToDev();

}
