package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.asserts.SoftAssert;

import dbconnection.DbConnection;

import utilities.ConfigDataprovider;

public class RegisterEmployee {
	Connection con;
	Logger logger;
	private static final String INSERTQUERY = "INSERT INTO `employee`.`employeedata` VALUES(?,?,?,?,?,?)";
	private static final String SELECTQUERY = "SELECT * FROM employee.employeedata ORDER BY empid DESC LIMIT 1";
	ConfigDataprovider config;
	String[] employeedata;

	public RegisterEmployee() {
		config = new ConfigDataprovider();
		PropertyConfigurator.configure(config.getLogprop());
		logger = Logger.getLogger(RegisterEmployee.class);
	}

	public void registerEmployee(String empdata) {

		con = DbConnection.getDbInstance().getConnection();

		employeedata = empdata.split("%");

		try (PreparedStatement ps = con.prepareStatement(INSERTQUERY);) {
			ps.setString(1, null);
			ps.setString(2, employeedata[0]);
			ps.setString(3, employeedata[1]);
			ps.setString(4, employeedata[2]);
			ps.setString(5, employeedata[3]);
			ps.setString(6, employeedata[4]);
			ps.execute();
			logger.info("Registration of Employee " + employeedata[0].toUpperCase() + " done");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void checkregisteredDetails() {
		SoftAssert softAssert = new SoftAssert();
		try (Statement stmt = con.createStatement();) {
			ResultSet result = stmt.executeQuery(SELECTQUERY);

			while (result.next()) {
				softAssert.assertEquals(result.getString(2), employeedata[0]);

				softAssert.assertEquals(result.getString(3), employeedata[1]);

				softAssert.assertEquals(result.getFloat(4), employeedata[2]);

				softAssert.assertEquals(result.getString(5), employeedata[3]);

				softAssert.assertEquals(result.getString(6), employeedata[4]);

			}

		} catch (Exception e) {
			logger.warn("problem in sql query",e);
			
		}

	}
}
