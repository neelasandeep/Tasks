package db_connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import book_ticket.DataAccess;

public class DbOperations {
	private static Logger logger = Logger.getLogger(DbConnection.class.getName());
	static String query;
	static String theaterId;
	String movieId;
	String locationId;
	String screen;
	String time;
	static Connection con;
   
	public DbOperations() {
		con = DbConnection.getDbInstance().getConnection();
	}

	public void getLocations() {
		query = "select location_name from locations";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				logger.info("\n" + rs.getString(1));

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
				logger.info("\n" + rs.getString(1));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getTheaters(DataAccess ticket) {
		query = "select th.theater_name from " + "theaters th,theaters_for_movie tfm,movies m "
				+ "where th.theater_id=tfm.theater_id and\r\n" + "tfm.movie_id=m.movie_id  and m.movie_name='"
				+ ticket.getMovieName() + "' and " + "tfm.location_id='" + getLocationId(ticket) + "'";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				logger.info("\n" + rs.getString(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String showTimings(DataAccess ticket) {

		query = "select th.screen_no ,th.timings" + " from theaters_for_movie th " + "where th.location_id='"
				+ getLocationId(ticket) + "' " + "and th.movie_id= '" + getMovieId(ticket) + "'and th.theater_id='"
				+ getTheaterId(ticket) + "'";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {

			while (rs.next()) {
				screen = rs.getString(1);
				time = rs.getString(2);
			}
			logger.info(screen + "   " + time);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screen;
	}

	public String getSeatDetails(DataAccess ticket) {
		String seats = "";
		query = "select sd.seat_no from movie_booking.seat_details sd where booking_date='"+ticket.getDate()+"'"
				+ " and sccreen_no='"+ticket.getScreen()+"'"
				+ "and theater_id='"+getTheaterId(ticket)+"' ";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				seats=seats.concat(rs.getString(1)+"-");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return seats;
	}

	public String getCapacity(DataAccess ticket) {
		String capacity = null;
		query = "SELECT tfm.screen_capacity FROM theaters_for_movie tfm where" + " movie_id='" + getMovieId(ticket)
				+ "' and" + " theater_id='" + getTheaterId(ticket) + "' and screen_no='" + ticket.getScreen() + "'";

		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {

			while (rs.next()) {
				capacity = rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return capacity;
	}

	public void storeSeatInfo(DataAccess ticket) {

		query = "INSERT INTO movie_booking.seat_details "
				+ "(booking_date, theater_id, sccreen_no, seat_no, showtime, booking_id) " + "VALUES ('"
				+ ticket.getDate() + "','" + getTheaterId(ticket) + "' ,'" + ticket.getScreen() + "'," + " '"
				+ ticket.getSeat_no() + "', '" + ticket.getTime() + "'," + " '" + ticket.getBookingId() + "')";

		try (Statement stmt = con.createStatement();) {
			stmt.execute(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public  String getTheaterId(DataAccess ticket) {
		query = "select th.theater_id from movie_booking.theaters th where theater_name='" + ticket.getTheater() + "'";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				theaterId = rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return theaterId;
	}

	public String getMovieId(DataAccess ticket) {
		query = "select m.movie_id from movie_booking.movies m where movie_name='" + ticket.getMovieName() + "'";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				movieId = rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return movieId;
	}

	public String getLocationId(DataAccess ticket) {
		query = "select location_id from locations where location_name='" + ticket.getLocation() + "'";
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);) {
			while (rs.next())
				locationId = rs.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationId;
	}

}
