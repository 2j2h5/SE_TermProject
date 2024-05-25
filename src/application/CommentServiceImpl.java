package application;

import domain.Comment;
import domain.CommentService;

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
	public void requestMake() {
		
	}

	@Override
	protected List<Comment> loadDataFromDB() {
		List<Comment> comments = new ArrayList<>();
		
		//DB의 모든 Comment를 불러옴
		DBService dbService = new DBService();
        	Connection conn = dbService.getConnection();

        	try {
            		// SQL 쿼리
           		String sql = "SELECT * FROM comments";

            		//SQL 실행
            		PreparedStatement statement = conn.prepareStatement(sql);
            		ResultSet resultSet = statement.executeQuery();

            		// 결과
            		while (resultSet.next()) {
               	 		String content = resultSet.getString("content");
                		String writer = resultSet.getString("writer");
                		String writedDate = resultSet.getString("writedDate");
                		int issue = resultSet.getInt("issue");

                		// Comment 객체 생성 후 리스트에 추가
                		Comment comment = new Comment(content, writer, writedDate, issue);
                		comments.add(comment);
           		}

            		resultSet.close();
            		statement.close();
        	} catch (SQLException e) {
           		 e.printStackTrace();
        	} finally {
           		 // 연결 종료
		        dbService.closeConnection();
        	}

		return comments;
	}

	@Override
	protected void saveDataToDB() {

		// dataList의 모든 Comment를 DB에 저장
		DBService dbService = new DBService();
        	Connection conn = dbService.getConnection();

        	try {
            		// SQL 문
            		String sql = "INSERT INTO comments (content, write_id, writedDate, issue) VALUES (?, ?, ?, ?)";

            		// SQL쿼리 실행
            		PreparedStatement statement = conn.prepareStatement(sql);
            		for (Comment comment : dataList) {
                		statement.setString(1, comment.getContent());
                		statement.setString(2, comment.getWriterId());
                		statement.setString(3, comment.getWritedDate());
                		statement.setInt(4, comment.getIssue());
                		statement.executeUpdate();
            		}

            		statement.close();
        	} catch (SQLException e) {
            		e.printStackTrace();
        	} finally {
            		// 연결 종료
            		dbService.closeConnection();
       		}
		
	}

}
