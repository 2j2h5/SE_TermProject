package domain;

public interface IssueService extends BaseService {
	
	// interfaces
	void requestMake();
	void requestBrowse();
	void requestEdit();
	void requestAssign();
	
	void notifyToPL();
	void notifyToDev();

}
