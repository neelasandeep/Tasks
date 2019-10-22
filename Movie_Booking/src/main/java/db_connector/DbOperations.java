package db_connector;

import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.logging.Logger;

import book_ticket.DataAccess;

public class DbOperations {
	private static Logger logger = Logger.getLogger(DbConnection.class.getName());
	String query;
	
	static Connection con;

	public DbOperations() {
		con = DbConnection.getConnection();
	}

	public void getLocations() {
		query = "select location_name from locations";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				logger.info(rs.getString(1));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getMovies(DataAccess ticket) {
		query = "select  m.movie_name from movies m,movies_in_location min,locations l\r\n"
				+ "where m.movie_id=min.movie_id\r\n" + "and  min.location_id=l.location_id and l.location_name='"
				+ ticket.getLocation() + "'";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				logger.info(rs.getString(1));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getTheaters(DataAccess ticket ) {
		query = "select th.theater_name from "
				+ "theaters th,theaters_for_movie tfm,movies m "
				+ "where th.theater_id=tfm.theater_id and\r\n" + 
				"tfm.movie_id=m.movie_id  and m.movie_name='"+ticket.getMovieName()+"' and "
				+ "tfm.location_id=(select location_id from locations where location_name='"+ticket.getLocation()+"')";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				logger.info(rs.getString(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String showTimings(DataAccess ticket) {
		String screen = null;
		String time=null;
		query = "select th.screen_no ,th.timings"
				+ " from theaters_for_movie th "
				+ "where th.location_id=(select location_id from locations where location_name='"+ticket.getLocation()+"') "
				+ "and th.movie_id=(select movie_id from movies where movie_name='"+ticket.getMovieName()+"') "
				+ "and th.theater_id=(select theater_id from theaters where theater_name='"+ticket.getTheater()+"')";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			
			while (rs.next()) {
				screen=rs.getString(1);
				time=rs.getString(2);
			}
           logger.info(screen+"   "+time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screen;
	}

}
