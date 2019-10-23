package booking_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import book_ticket.DataAccess;
import db_connector.DbOperations;

public class TicketBooking {
	private TicketBooking() {
	}

	public static TicketBooking object;
	private static final int PREMIUM = 250;
	private static final int LUXARY = 150;

	public static TicketBooking getInstance() {
		if (object == null) {
			synchronized (TicketBooking.class) {
				if (object == null)
					object = new TicketBooking();
			}
		}
		return object;
	}

	static DbOperations locationDB;
	static Logger logger = Logger.getLogger(TicketBooking.class.getName());

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static DataAccess ticket = new DataAccess();
	static List<String> movieList;
	static List<String> theaterList;

	public void bookYourTicket() throws IOException {
		locationDB = new DbOperations();

		ticket.setLocation(getLocationName());

		ticket.setMovieName(selctMovie());

		ticket.setTheater(selectTheater());
	     ticket.setDate(selectDate());

		ticket.setTime(selectShowTime());
		selectSeats();
		ticket.setTotalseats(ticket.getTotalseats() - ticket.getNoOfTickets());
		ticket.setTotalCost(totalAmount());

	}

	public DataAccess getTicket() {
		return ticket;
	}

	public String getLocationName() throws IOException {
		logger.info("Select Your prefered Location:");
		locationDB.getLocations();
		return input.readLine().toLowerCase();

	}

	public String selctMovie() throws IOException {
		logger.info("which movie you want to watch:");
		locationDB.getMovies(ticket);
		return input.readLine().toLowerCase();

	}

	private String selectTheater() throws IOException {
		logger.info("Select your preferable theater:");
		locationDB.getTheaters(ticket);

		return input.readLine().toLowerCase();

	}
	private String selectDate() throws IOException {
		Calendar calendar = Calendar.getInstance();
		for(int date=0;date<5;date++) {
			 calendar.add(Calendar.DAY_OF_YEAR, 1);
			 logger.info(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()).toString());
			 
		}
		
		return input.readLine();
	}

	private static String selectShowTime() throws IOException {
		logger.info("Select show timing:");
		ticket.setScreen(locationDB.showTimings(ticket));
		return input.readLine();

	}

	private static synchronized void selectSeats() throws IOException {
		int noOfSeats;
		logger.info("select no of tickets you want to book ( at most 10 )");
		noOfSeats = Integer.parseInt(input.readLine());
		if (noOfSeats > 10 || noOfSeats < 1) {
			logger.info("Enter Valid no of tickets to book");
			selectSeats();
		} else {
			ticket.setNoOfTickets(noOfSeats);
			selectNoOfSeats(noOfSeats);

		}

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

	private static synchronized int totalAmount() {

		return (ticket.getPremiumTicket() * PREMIUM) + (ticket.getLuxaryTickts() * LUXARY);

	}

}
