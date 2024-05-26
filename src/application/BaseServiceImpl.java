package application;

import domain.BaseService;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService {
	
	protected Map<String, Object> attributeDict = new HashMap<>();
	protected List<T> dataList;
	
	@Override
	public void enterInfo(String key, Object value) {
		attributeDict.put(key, value);
	}
	
	@Override
	public Map<String, Object> getAttributes() {
		return attributeDict;
	}
	
	@Override
	public void loadDB() {
		dataList = loadDataFromDB();
	}
	
	@Override
	public void saveDB() {
		saveDataToDB();
	}
	
	// methods
	
	protected abstract List<T> loadDataFromDB();
	
	protected abstract void saveDataToDB();

}
