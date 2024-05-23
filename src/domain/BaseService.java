package domain;

import java.util.Map;

public interface BaseService {
	
	void enterInfo(String key, Object value);
	boolean checkValidation(Map<String, Object> attributeDict);
	Map<String, Object> getAttributes();
	void loadDB();
	void saveDB();

}
