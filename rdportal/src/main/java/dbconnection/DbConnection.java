package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import utilities.ConfigDataprovider;

public class DbConnection {
	private Connection con = null;

	static Logger logger;

	static ConfigDataprovider config;

	private static class Ref {
		static final DbConnection instance = new DbConnection();
	}

	public static DbConnection getDbInstance() {
		config = new ConfigDataprovider();
		PropertyConfigurator.configure(config.getLogprop());
		
		logger = Logger.getLogger(DbConnection.class);
		
		return Ref.instance;
	}

	public Connection getConnection() {
		
		
		
		try {

			Class.forName(config.getDriver());
			con = DriverManager.getConnection(config.getdriverManager(), config.username(), config.password());

		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		logger.info("connected to DATABASE..");
		return con;

	}

}
