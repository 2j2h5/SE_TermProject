package domain;

import exceptions.ValidationException;

public interface ProjectService extends BaseService {
	
	// interfaces
	void requestMake() throws ValidationException;
	void notifyToPL();

}
