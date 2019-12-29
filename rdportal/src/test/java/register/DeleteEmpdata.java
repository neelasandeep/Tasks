package register;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DeleteEmpdata extends BaseClass {

	private static final String DELETEQUERY = "DELETE  FROM employee.employeedata WHERE empid=?";

	private static final String SELECTEMPLOYEE = "SELECT * FROM employee.employeedata WHERE empid=";
	PreparedStatement ps;

	public DeleteEmpdata() {
		super();
	}

	public void deleteEmployee(String[] employeedata) {
		logger = Logger.getLogger(DeleteEmpdata.class);

		try (Statement stmt = con.createStatement(); PreparedStatement ps = con.prepareStatement(DELETEQUERY);) {
			result = stmt.executeQuery(SELECTEMPLOYEE + employeedata[0]);
			delete(ps, employeedata[0]);
		} catch (Exception e) {

			logger.warn("error in deletion", e);
		}
	}

	public void delete(PreparedStatement ps, String id) throws SQLException {
		int count = 0;
		if (result.next()) {
			count++;
			if (count == 1) {
				ps.setString(1, id);
				ps.execute();
				logger.info("Deletion of Employee " + id + " done");
			}
		} else {
			System.out.println("entered else");
			logger.info("Employee with id " + id + " not found");
		}
	}
}
