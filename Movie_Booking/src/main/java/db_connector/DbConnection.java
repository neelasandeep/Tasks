package db_connector;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;





public class DbConnection {
	private  Connection con=null;
	private static String username = "root";
	private static String pwd = "root";
	private static Logger logger = Logger.getLogger(DbConnection.class.getName());
	public static DbConnection object;
	
	public static DbConnection getDbInstance() {
		if (object == null) {
			synchronized (DbConnection.class) {
				if (object == null)
					object = new DbConnection();
			}
		}
		return object;
	}

	public  Connection getConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/movie_booking", username, pwd);

		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return con;

	}

}
