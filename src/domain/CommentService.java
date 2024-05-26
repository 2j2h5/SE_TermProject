package domain;

import exceptions.ValidationException;

public interface CommentService extends BaseService {
	
	// interfaces
	void requestMake() throws ValidationException;

}
