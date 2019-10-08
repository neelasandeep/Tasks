package location;


import java.util.List;

public interface Location {
	public List<String> getMovies() ;
	public List<String> getTheaters(String moviename);
	public void  showTimings();

}
