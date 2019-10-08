package ticket_booking;

public class DataAccess {

	private String location;
	private String movieName;
	private String theater;
	private String time;
	private String type;
	private int noOfTickets;
	private int luxaryTickts;
	private int premiumTicket;
	public int getLuxaryTickts() {
		return luxaryTickts;
	}

	public void setLuxaryTickts(int luxaryTickts) {
		this.luxaryTickts = luxaryTickts;
	}

	public int getPremiumTicket() {
		return premiumTicket;
	}

	public void setPremiumTicket(int premiumTicket) {
		this.premiumTicket = premiumTicket;
	}

	private int totalCost;
	private int totalseats = 100;

	public int getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String f) {
		this.time = f;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

}
