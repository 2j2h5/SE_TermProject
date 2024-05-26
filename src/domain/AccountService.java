package domain;

import exceptions.ValidationException;

public interface AccountService extends BaseService {
	
	// interfaces
	void requestMake() throws ValidationException;

}
