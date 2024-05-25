package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/TERM_PROJECT";
    private static final String USER = "root";
    private static final String PASS = "1234";

    private Connection conn;

    public DBService() {
        try {
            // MySQL 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 데이터베이스 연결
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 연결된 데이터베이스 커넥션 반환(다른 클래스에서 데이터베이스 접근하려면 필요한 메서드)
    public Connection getConnection() {
        return conn;
    }

    // 데이터베이스 연결 종료
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
