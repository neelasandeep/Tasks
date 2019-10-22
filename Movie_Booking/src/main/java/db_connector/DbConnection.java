package db_connector;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.logging.Logger;

public class DbConnection {
	private static Connection con = null;
	private static String username = "root";
	private static String pwd = "root";
	private static Logger logger = Logger.getLogger(DbConnection.class.getName());
	

	public static Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie_booking", username, pwd);

		} catch (Exception e) {
			logger.warning(e.getMessage());
		}
		return con;

	}

}
