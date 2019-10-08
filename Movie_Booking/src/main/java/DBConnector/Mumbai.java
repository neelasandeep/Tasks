package DBConnector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import location.Location;

public class Mumbai implements Location {
    
	static Map<String,List<String>> theatersList=new HashMap<>();
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	String selectedMovie;
	  
	static {
		theatersList.put("lootcase" ,Arrays.asList("inox malad", "pvr andheri east", "bollywood cinema", "film city","maratha mandir"));
		theatersList.put("war",Arrays.asList("pvr priston", "pvr central",  "inox inorbit","miraj cinemas"));
		theatersList.put("avengers",Arrays.asList("pvr priston", "pvr mall rajmore", "pvr city mall"));
		theatersList.put("saira",Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit","sushma theater"));
		theatersList.put("student of the year 2",Arrays.asList("pvr inorbit mall",  "inox inorbit","carnival cinemas"));
	}
	static Logger logger = Logger.getLogger(Mumbai.class.getName());
    List<String> movies=Arrays.asList("lootcase","war","avengers","saira","student of the year 2");
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
