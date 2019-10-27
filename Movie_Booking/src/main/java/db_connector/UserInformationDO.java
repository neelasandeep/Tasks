package db_connector;

import java.sql.Connection;

import java.sql.Statement;

import org.apache.log4j.Logger;

import book_ticket.DataAccess;

public class UserInformationDO {
	 Connection con;
	 String query;
	private static Logger logger = Logger.getLogger(UserInformationDO.class.getName());
	public UserInformationDO() {
		con = new DbConnection().getConnection();
	}
	public  void storeUserInfo(DataAccess ticket) {
		query = "INSERT INTO `movie_booking`.`userdata`"
				+ " VALUES ('"+ticket.getBookingId()+"', '"+ticket.getLocation()+"',"
				+ " '"+ticket.getMovieName()+"', '"+ticket.getTheater()+"', '"+ticket.getScreen()+"', "
				+ "'"+ticket.getType()+"', '"+ticket.getNoOfTickets()+"', '"+ticket.getSeatNo()+"', "
				+ "'"+ticket.getTime()+"', '"+ticket.getDate()+"', '"+ticket.getTotalCost()+"')";

		try (Statement stmt = con.createStatement();  ) {
			
			stmt.execute(query);
		} catch (Exception e) {
			logger.error("something went wrong in getlocation method query",e);
		}
	}

}
