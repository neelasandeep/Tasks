package ticket_booking;

import java.util.HashMap;

import java.util.Map;

import DBConnector.*;
import location.Location;

public class LocationFactory {
 static Map<String,Location>  instance=new HashMap<>();
 static {
	 instance.put("hyderabad", new Hyderabad());
	 instance.put("mumbai", new Mumbai());
	 instance.put("chandigarh",  new Chandigarh());
	 instance.put("chennai", new Chennai());
	 
 }
 public static Location getInstance(String locationName){
	 if(instance.containsKey(locationName)) 
      return  instance.get(locationName);
	 
 
return null;
 }
 
}
