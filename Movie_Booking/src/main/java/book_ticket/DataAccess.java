package book_ticket;



public class DataAccess {

	private String location;
	private String movieName;
	private String theater;
	private String time;
	private String type;
	private int noOfTickets;
	private int luxaryTickts;
	private int premiumTicket;
	private int bookingId;
    private String date;
    private String seat_no;
    
	public String getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	private String screen;
	

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

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

	@Override
	public String toString() {
		return "-------Summury of Booking Details----------\n" + "Booking id\t\t" + getBookingId()
				+ "\nNo of Tickets Booked\t " + getNoOfTickets() + "\nseat_no\t\t\t" + getSeat_no() +"\ntype\t\t\t" + getType() + "\nPremium tickets\t\t"
				+ getPremiumTicket() + "" + "\n Luxary Tickets\t\t" + getLuxaryTickts() + "\n Movie Name\t\t"
				+ getMovieName() + " \n" + "Theater Name \t\t" + getTheater() + " \n" + "Screen\t\t\t" + getScreen()
				+ "\n"+"Time\t\t\t" + getTime() + " \n" + "Date\t\t\t" + date + "\nYour total cost is\t " + getTotalCost()
				+ "\n" + "\n\t-----Thanks For Booking------";
	}

}
