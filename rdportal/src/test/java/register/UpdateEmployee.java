package register;

import java.sql.PreparedStatement;

import org.apache.log4j.Logger;



public class UpdateEmployee extends BaseClass {

	private static final String UPDATEQUERY = "update employee.employeedata set emplastname=?,empfirstname=?, yearofpass=?, tenth=? ,inter=? where empid=?;";

	public UpdateEmployee() {
		super();
	}

	public void updateEmployee(String[] employeedata) {

		logger = Logger.getLogger(UpdateEmployee.class);

		try (PreparedStatement ps = con.prepareStatement(UPDATEQUERY);) {

			ps.setString(1, employeedata[0]);
			ps.setString(2, employeedata[1]);
			ps.setString(3, employeedata[2]);
			ps.setString(4, employeedata[3]);
			ps.setString(5, employeedata[4]);
			ps.setString(6, employeedata[5]);
			ps.executeUpdate();
			logger.info("Update of Employee " + employeedata[0].toUpperCase() + " done");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
