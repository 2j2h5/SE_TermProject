package application;

import domain.BaseService;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService {
	
	//variables
	protected Map<String, Object> attributeDict = new HashMap<>();
	protected List<T> dataList;
	
	private final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	protected DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
	
	// methods
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
	
	protected abstract List<T> loadDataFromDB();
	
	protected abstract void saveDataToDB();

}
