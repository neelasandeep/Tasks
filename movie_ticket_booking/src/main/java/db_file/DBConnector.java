package db_file;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java_files.Movies;
import java_files.Theaters;
import java.util.Arrays;
import java.util.HashMap;

public class DBConnector {
	static final  int PREMIUMTICKETCOST = 250;
	static final  int LUXARYTICKETCOST = 150;

	static Logger logger = Logger.getLogger(DBConnector.class.getName());
	String[] locationName = { "hyderabad", "bangalore", "mumbai", "chandigarh", "chennai" };
	public  List<String> locations = Arrays.asList(locationName);


	String[] MoviesName = { "sahoo", "war", "avengers", "saira", "joker" };
	private List<String> hyderabadMovies = Arrays.asList(MoviesName);
    private List<String> bangaloreMovies = Arrays.asList(MoviesName);
    private List<String> mumbaiMovies = Arrays.asList(MoviesName);
    private List<String> chandigarhMovies = Arrays.asList(MoviesName);
    private List<String> chennaiMovies = Arrays.asList(MoviesName);

	String[] hyderabadTheatersName = { "pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit" };
	private List<String> hyderabadTheaters = Arrays.asList(hyderabadTheatersName);

	String[] bangaloreTheatersName = { "pvr nagawara", "pvr phoenix marketcity", "srinivasa cinemas" };
	private List<String> bangaloreTheaters = Arrays.asList(bangaloreTheatersName);

	String[] mumbaiTheatersName = { "inox malad", "pvr andheri east", "bollywood cinema", "film city" };
	private List<String> mumbaiTheaters = Arrays.asList(mumbaiTheatersName);

	String[] chandigarhTheatersName = { "pvr elante mall", "pvr waves", "inox vr punjab", "pvr picadly",
			"neelam theater" };
	private List<String> chandigarhTheaters = Arrays.asList(chandigarhTheatersName);

	String[] chennaiTheatersName = { "jazz cinemas", "pvr phoenix marketcity", "palazzo ", "inox phoenix marketcity" };
	private List<String> chennaiTheaters = Arrays.asList(chennaiTheatersName);

	Map<String, List<String>> moviesInLocation = new HashMap<>();
	Map<String, List<String>> theaterNames = new HashMap<>();
	List<String> theaterlist;
	List<String> movies;

	public void dbOperations() {

		moviesInLocation.put(locations.get(0), hyderabadMovies);
		moviesInLocation.put(locations.get(1), bangaloreMovies);
		moviesInLocation.put(locations.get(2), mumbaiMovies);
		moviesInLocation.put(locations.get(3), chandigarhMovies);
		moviesInLocation.put(locations.get(4), chennaiMovies);
		theaterNames.put(locations.get(0), hyderabadTheaters);
		theaterNames.put(locations.get(1), bangaloreTheaters);
		theaterNames.put(locations.get(2), mumbaiTheaters);
		theaterNames.put(locations.get(3), chandigarhTheaters);
		theaterNames.put(locations.get(4), chennaiTheaters);

	}

	public List<String> getMoviesList(String location) {
		logger.info(" select movie from the list below");
		Movies m = loc -> {
			movies = moviesInLocation.get(loc);
			movies.forEach(System.out::println);
		};
		m.getMovies(location);

		return movies;
	}

	public List<String> getTheatersList(String location, String moviename) {
		logger.info(" select Theater from the list below");
		Theaters theater = (loc, movie) -> {
			theaterlist = theaterNames.get(loc);
			theaterlist.forEach(System.out::println);
		};
		theater.getTheaters(location, moviename);

		return theaterlist;
	}

	public void showTimings() {
		logger.info("11.00\t14.00\t18.00\t21.00\t");
	}

	public int getAmount(int noOfTickets) {
		return (noOfTickets * PREMIUMTICKETCOST);
	}

	public void getLocationName() {
		logger.info("Select Your prefered Location" + locations.toString());

	}

}
