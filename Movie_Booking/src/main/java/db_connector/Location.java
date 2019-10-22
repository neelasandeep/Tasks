package db_connector;



public interface Location {
	public void getLocations();
	public void getMovies(String location);

	public void getTheaters(String moviename);

	public void showTimings();

}
