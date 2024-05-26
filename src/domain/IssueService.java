package domain;

import exceptions.ValidationException;

public interface IssueService extends BaseService {
	
	// interfaces
	void requestMake() throws ValidationException;
	void requestBrowse();
	void requestEdit();
	void requestAssign();
	
	void notifyToPL();
	void notifyToDev();

}
