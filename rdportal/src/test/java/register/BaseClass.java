package register;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.asserts.SoftAssert;

import dbconnection.DbConnection;
import utilities.ConfigDataprovider;

public class BaseClass {
	ConfigDataprovider config;
	Logger logger;
	Connection con;
	ResultSet result;
	public BaseClass() {
		con = DbConnection.getDbInstance().getConnection();
		config = new ConfigDataprovider();
	}

	public void checkDetails(String[] employeedata) {
		SoftAssert softAssert = new SoftAssert();
		
		PropertyConfigurator.configure(config.getLogprop());
		logger = Logger.getLogger(BaseClass.class);
		try (Statement stmt = con.createStatement();) {
			 result = stmt.executeQuery(config.getSelectQuery());

			while (result.next()) {
				softAssert.assertEquals(result.getString(2), employeedata[0]);

				softAssert.assertEquals(result.getString(3), employeedata[1]);

				softAssert.assertEquals(result.getFloat(4), employeedata[2]);

				softAssert.assertEquals(result.getString(5), employeedata[3]);

				softAssert.assertEquals(result.getString(6), employeedata[4]);

			}

		} catch (Exception e) {
			logger.warn("problem in sql query", e);

		}

	}

}
