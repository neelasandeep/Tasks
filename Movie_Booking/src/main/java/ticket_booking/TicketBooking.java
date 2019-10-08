package ticket_booking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import location.Location;

public enum TicketBooking {
	INSTANCE;
	private static final int PREMIUM = 250;
	private static final int LUXARY = 150;

	static Location locationDB;
	static Logger logger = Logger.getLogger(TicketBooking.class.getName());

	static String[] locationName = { "hyderabad","mumbai", "chandigarh", "chennai" };
	static List<String> locations = Arrays.asList(locationName);

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static DataAccess ticket = new DataAccess();
	static List<String> movieList;
	static List<String> theaterList;

	public void bookYourTicket() throws IOException {

		ticket.setLocation(getLocationName());
		locationDB = LocationFactory.getInstance(ticket.getLocation());

		ticket.setMovieName(selctMovie());
		

		ticket.setTheater(selectTheater());

		ticket.setTime(selectShowTime());
		selectSeats();
		ticket.setTotalseats(ticket.getTotalseats() - ticket.getNoOfTickets());
		ticket.setTotalCost(totalAmount());

	}

	public static synchronized  String getLocationName() throws IOException {
		logger.info("Select Your prefered Location" + locations.toString());
		String selectedLocationName = input.readLine().toLowerCase();

		if (locations.contains(selectedLocationName)) {
			return selectedLocationName;
		} else {
			logger.info("Enter Valid Location");
			return TicketBooking.getLocationName();
		}
	}

	private static synchronized  String selctMovie() throws IOException {

		movieList = locationDB.getMovies();

		logger.info(movieList.toString().toUpperCase());

		String selectedMovie = input.readLine().toLowerCase();
		if (movieListNotContains(selectedMovie)) {
			return TicketBooking.selctMovie();
		}

		return selectedMovie;

	}

	private static boolean movieListNotContains(String movie) {
		return !movieList.contains(movie);
	}

	private  static synchronized  String selectTheater() throws IOException {
		theaterList = locationDB.getTheaters(ticket.getMovieName());
		logger.info(theaterList.toString().toUpperCase());
		String selectedTheater = input.readLine().toLowerCase();
		if (theaterListNotContains(selectedTheater)) {
			return TicketBooking.selectTheater();
		}

		return selectedTheater;

	}

	private static boolean theaterListNotContains(String theater) {
		return !theaterList.contains(theater);
	}

	private static String selectShowTime() throws IOException {
		locationDB.showTimings();
		String selectedShowTime = input.readLine();
		if (Float.parseFloat(selectedShowTime) > 12.0)
			return selectedShowTime + " PM";
		else
			return selectedShowTime + " AM";

	}

	private static synchronized  void selectSeats() throws IOException {
		int noOfSeats;
		logger.info("select no of tickets you want to book at most 10");
		noOfSeats = Integer.parseInt(input.readLine());
		if (noOfSeats > 10 || noOfSeats < 1) {
			logger.info("Enter Valid no of tickets to book");
			selectSeats();
		} else {
			ticket.setNoOfTickets(noOfSeats);
		}

		selectNoOfSeats(noOfSeats);

	}

	private static void selectNoOfSeats(int noOfSeats) throws IOException {
		logger.info("Selct which type of Ticket\nPremium\nLuxary\nCombination");
		String seatType = input.readLine().toLowerCase();
		if (seatType.equalsIgnoreCase("premium")) {
			ticket.setType("PREMIUM");

			ticket.setPremiumTicket(noOfSeats);
		} else if (seatType.equalsIgnoreCase("luxary")) {
			ticket.setType("LUXARY");
			ticket.setLuxaryTickts(noOfSeats);
		} else if (seatType.equalsIgnoreCase("combination")) {
			combinationSeats();
		} else {
			selectNoOfSeats(noOfSeats);
		}
	}

	private static void combinationSeats() throws IOException {
		logger.info("How many tickets you want for premium out of " + ticket.getNoOfTickets());
		ticket.setType("PREMIUM/LUXARY");
		int premiumSeats = Integer.parseInt(input.readLine());
		if (premiumSeats > ticket.getNoOfTickets()) {
			logger.info("Please select valid input");
			combinationSeats();
		} else {
			ticket.setPremiumTicket(premiumSeats);
			ticket.setLuxaryTickts(ticket.getNoOfTickets() - ticket.getPremiumTicket());
		}
	}

	private  static synchronized  int totalAmount() {

		return (ticket.getPremiumTicket() * PREMIUM) + (ticket.getLuxaryTickts() * LUXARY);

	}

	public synchronized void confiramationMeassge() {

		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		logger.info("-------Summury of Booking Details----------\n" + "No of Tickets Booked\t "
				+ ticket.getNoOfTickets() + "\ntype\t\t\t" + ticket.getType() + "\nPremium tickets\t\t"
				+ ticket.getPremiumTicket() + "" + "\n Luxary Tickets\t\t" + ticket.getLuxaryTickts()
				+ "\n Movie Name\t\t" + ticket.getMovieName() + " \n" + "Theater Name \t\t" + ticket.getTheater()
				+ " \n" + "Time\t\t\t" + ticket.getTime() + " \n" + "Date\t\t\t" + date + "\nYour total cost is\t "
				+ ticket.getTotalCost() + "\n" + "\n\t-----Thanks For Booking------");
	}

}
