package DBConnector;


import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;



import location.Location;


public class Hyderabad implements Location{
	
	
	static Map<String,List<String>> theatersList=new HashMap<String,List<String>>();
	static BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	
	  
	static {
		theatersList.put("saaho" ,Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit"));
		theatersList.put("war",Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit","miraj cinemas"));
		theatersList.put("avengers",Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas"));
		theatersList.put("saira",Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit","sushma theater"));
		theatersList.put("joker",Arrays.asList("pvr priston", "pvr inorbit mall",  "inox inorbit"));
	}
	static Logger logger = Logger.getLogger(Hyderabad.class.getName());
    List<String> movies=Arrays.asList("saaho","war","avengers","saira","joker");
	public  List<String> getMovies(){
		return movies;
	}
	

	public List<String> getTheaters(String moviename) {
		
		
		return theatersList.get(moviename);
		
	}
	public void showTimings() {
		logger.info("11.00\t14.00\t18.00\t21.00\t");
	}
	

}
