package united.orphan.home.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DataBaseConnectionManager {
	private static String JDBC_DRIVER   = "oracle.jdbc.driver.OracleDriver";
	private static String JDBC_URL      = "jdbc:oracle:thin:@localhost:1521:xe"; 
    private static String JDBC_USER     = "orphanage";
    private static String JDBC_PASSWORD = "child_123";
    
    
    /*
	 * create the Connection object
	 * 
	 */
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		
		if(! con.getAutoCommit())			
			con.setAutoCommit(true);	
	return con;
}


	/*
	 * close the Connection 
	 * 
	 */
	public static void close(Connection conn)throws SQLException{	
		
		try {
			if (conn != null){
				conn.close();
			}

		} catch (SQLException e) {
			 throw new SQLException(e);
		}
		
		
	}
	/*
	 * close the PreparedStatement 
	 * 
	 */
	public static void close(PreparedStatement stmt) throws SQLException{
		try {

			if (stmt != null){
				stmt.close();
			}

		} catch (SQLException e) {
			 throw new SQLException(e);
		}
		

	}
	/*
	 * close the ResultSet 
	 * 
	 */
	public static void close(ResultSet rs) throws SQLException{		 
		
		try {

			if (rs != null)
				rs.close();

		} catch (SQLException e) {
			 throw new SQLException(e);
		}		 
	}
	/*
	 * close the Statement 
	 * 
	 */
	public static void close(Statement stmt) throws SQLException{		 
		try {

			if (stmt != null){
				stmt.close();
			}
		} catch (SQLException e) {
			 throw new SQLException(e);
		}

	}
	/*
	 * used for rollback  
	 * 
	 */
	public static void rollBack(Connection conn) throws SQLException  {		  
	
		try {if (conn != null){
			conn.rollback();
		}
		} catch (SQLException e) {
			 throw new SQLException(e);
			
			
		}
	}
	/*
	 *  commit the connection
	 * 
	 */
	public static void commit(Connection conn) throws SQLException {
		
		try {

			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			 throw new SQLException(e);
		}
	}
}
