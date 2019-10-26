package db_connector;

import book_ticket.DataAccess;

public interface Location {
	public void getLocations();
	public void getMovies(DataAccess ticket);

	public void getTheaters(DataAccess ticket);

	public String showTimings(DataAccess ticket);

}
