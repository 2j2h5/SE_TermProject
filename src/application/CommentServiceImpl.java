package application;

import domain.Comment;
import domain.CommentService;
import domain.DBService;
import exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
	
	// constructor
	public CommentServiceImpl() {
		this.loadDataFromDB();
	}
	
	// variables

	// methods
	@Override
	public boolean checkValidation() {
		String content = (String) attributeDict.get("content");
        //String writer = (String) attributeDict.get("writer");
        //String writedDate = (String) attributeDict.get("writedDate");
        //int involvedIssue = (int) attributeDict.get("involvedIssue");
        
        if (content == null || content.isEmpty()) return false;

        return true;
	}
	
	@Override
	public void requestMake() throws ValidationException {
		if (this.checkValidation()) {
			String content = (String) attributeDict.get("content");
	        String writer = currentId;
	        String writedDate = LocalDateTime.now().format(dateFormatter);
	        int involvedIssue = (int) attributeDict.get("involvedIssue");
	        
			dataList.add(new Comment(content, writer, writedDate, involvedIssue));
		} else {
			throw new ValidationException("Validation failed");
		}
	}

	@Override
	protected List<Comment> loadDataFromDB() {
		List<Comment> comments = new ArrayList<>();
		
		DBService dbService = new DBService();
    	Connection conn = dbService.getConnection();

    	try {
       		String sql = "SELECT * FROM comments";

    		PreparedStatement statement = conn.prepareStatement(sql);
    		ResultSet resultSet = statement.executeQuery();

    		while (resultSet.next()) {
       	 		String content = resultSet.getString("content");
        		String writer = resultSet.getString("writer");
        		String writedDate = resultSet.getString("writedDate");
        		int issue = resultSet.getInt("involvedIssue");

        		Comment comment = new Comment(content, writer, writedDate, issue);
        		comments.add(comment);
       		}

    		resultSet.close();
    		statement.close();
    	} catch (SQLException e) {
       		 e.printStackTrace();
    	} finally {
	        dbService.closeConnection();
    	}

		return comments;
	}

	@Override
	protected void saveDataToDB() {

		DBService dbService = new DBService();
    	Connection conn = dbService.getConnection();

    	try {
    		String sql = "INSERT INTO comments (id, content, writer, writedDate, involvedIssue) VALUES (?, ?, ?, ?)";

    		PreparedStatement statement = conn.prepareStatement(sql);
    		for (Comment comment : dataList) {
    			statement.setInt(1, comment.getId());
        		statement.setString(2, comment.getContent());
        		statement.setString(3, comment.getWriter());
        		statement.setString(4, comment.getWritedDate());
        		statement.setInt(5, comment.getIssue());
        		
        		statement.executeUpdate();
    		}

    		statement.close();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		dbService.closeConnection();
   		}
		
	}

}
