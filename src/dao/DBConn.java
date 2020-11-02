package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private final static String connectionStr = "jdbc:mysql://localhost:3306/sports";
	
	private final static String USER = "root";
	private final static String PASSWORD = "computer";
	private static Connection conn;
	private static DBConn instance;
	
	private DBConn(Connection conn) {
		this.conn = conn;
	}
	
	public static Connection getConnection() throws SQLException {
		if(instance == null) {
			try {
				conn = DriverManager.getConnection(connectionStr, USER, PASSWORD);
				instance = new DBConn(conn);
				System.out.println("Connection successful!");
			}catch(SQLException e){
				System.out.println("Unable to connect to database.");
				e.printStackTrace();
			}finally {
				if(conn != null) {
					System.out.println("Closing database connection.");
					conn.close();
					System.out.println("Database closed");
				}
			}
		}
		return DBConn.conn;
	}

}
