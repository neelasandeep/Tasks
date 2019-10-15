package locations;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hyderabad {
	Map<String,List<String>> theatersList=new HashMap<>();
	
	 
	public void dbOperations() {
		theatersList.put("sahoo" ,Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit"));
		theatersList.put("war",Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit","Miraj cinemas"));
		theatersList.put("avengers",Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas"));
		theatersList.put("saira",Arrays.asList("pvr priston", "pvr inorbit mall", "svc cinemas", "inox inorbit","sushma theater"));
		theatersList.put("joker",Arrays.asList("pvr priston", "pvr inorbit mall",  "inox inorbit"));
	}
	
	public List<String> getTheaterList(String moviename){
		if(theatersList.containsKey(moviename))
			return theatersList.get(moviename);
		 
		return null;
	  }
   
}
