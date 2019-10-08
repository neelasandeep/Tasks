package DBConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import location.Location;

public class Chandigarh implements Location {


	static Map<String, List<String>> theatersList = new HashMap<>();
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	String selectedMovie;

	static {
		theatersList.put("joker",
				Arrays.asList("jazz cinemas", "pvr phoenix marketcity", "palazzo", "inox phoenix marketcity"));
		theatersList.put("war", Arrays.asList("sathyam cinemas", "pvr central", "luxe", "miraj cinemas"));
		theatersList.put("avengers", Arrays.asList("pvr elante mall", "pvr waves", "inox vr punjab", "pvr picadly",
				"neelam theater"));
		theatersList.put("chichhore",
				Arrays.asList("s2 theyagareja", "pvr inorbit mall", "svc cinemas", "inox inorbit", "sushma theater"));
		theatersList.put("nikka zalidar3",
				Arrays.asList("pvr inorbit mall", "ags cinemas", "inox inorbit", "carnival cinemas"));
	}
	static Logger logger = Logger.getLogger(Chandigarh.class.getName());
	List<String> movies = Arrays.asList("joker", "war", "avengers", "chichhore", "nikka zalidar3");

	public List<String> getMovies() {

		return movies;
	}

	public List<String> getTheaters(String moviename) {

		return theatersList.get(moviename);
	}

	public void showTimings() {
		logger.info("11.00\t14.00\t18.00\t21.00\t");
	}


}
