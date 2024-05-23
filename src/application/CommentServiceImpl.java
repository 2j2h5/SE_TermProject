package application;

import domain.Comment;
import domain.CommentService;
import domain.Issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
	
	// constructor
	
	// variables

	// methods
	@Override
	public boolean checkValidation(Map<String, Object> attributeDict) {
		return true;
	}
	
	@Override
	public void requestAdd() {
		
	}

	@Override
	protected List<Comment> loadDataFromDB() {
		List<Comment> comments = new ArrayList<>();
		
		//DB의 모든 Issue를 불러옴
		
		return comments;
	}

	@Override
	protected void saveDataToDB() {

		// dataList의 모든 Account를 DB에 저장
		
	}

}
