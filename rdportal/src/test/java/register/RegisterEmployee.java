package register;


import java.sql.PreparedStatement;

import org.apache.log4j.Logger;



public class RegisterEmployee extends BaseClass {
	
public RegisterEmployee() {
	super();
}
	private static final String INSERTQUERY = "INSERT INTO `employee`.`employeedata` VALUES(?,?,?,?,?,?)";

	public void registerEmployee(String[] employeedata) {
		logger = Logger.getLogger(RegisterEmployee.class);
		

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

}
