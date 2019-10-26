package booking_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import book_ticket.DataAccess;

import db_connector.DbOperations;

public class TicketBooking {
	public TicketBooking() {
	}

	public static TicketBooking object;
	private static final int PREMIUM = 250;
	private static final int LUXARY = 150;
	private static int premium = 0;
	private static int luxary = 0;
	private static List<String> bookedSeats=new ArrayList<>();

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
	static int row;
	static int col;

	public void bookYourTicket() throws IOException {
		locationDB = new DbOperations();

		ticket.setLocation(getLocationName());

		ticket.setMovieName(selctMovie());

		ticket.setTheater(selectTheater());
		ticket.setDate(selectDate());

		ticket.setTime(selectShowTime());
		selectSeats();

		
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
		for (int date = 0; date < 5; date++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			logger.info("\n" + new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()).toString());

		}

		return input.readLine();
	}

	private static String selectShowTime() throws IOException {
		logger.info("Select show timing:");
		ticket.setScreen(locationDB.showTimings(ticket));
		return input.readLine();

	}

	private static synchronized void selectSeats() throws IOException {
		displayScreen(ticket);
		selectseat_no(ticket);

	}

	public static void displayScreen(DataAccess ticket) throws NumberFormatException, IOException {
		locationDB = new DbOperations();
		String capacity = locationDB.getCapacity(ticket);
		String seats = locationDB.getSeatDetails(ticket);
		row = Integer.parseInt(capacity.split("-")[0]);
		col = Integer.parseInt(capacity.split("-")[1]);
		

		if (seats == "") {
			for (int r = 65; r <= row + 65; r++) {
				for (int c = 1; c <= col; c++) {
					logger.info((char) r + "" + c + "[Ava]  ");
				}
				logger.info("\n\n");
			}

		}

		else {
			bookedSeats = Arrays.asList(seats.split("-"));
			for (int r = 65; r <= row + 65; r++) {
				if (r == 65)
					logger.info("-------------------premium tickets-----------------------\n");
				for (int c = 1; c <= col; c++) {
					if ((bookedSeats.contains((char) (r + 32) + "" + c)))
						logger.info((char) r + "" + c + "[B]  ");
					else
						logger.info((char) r + "" + c + "[Ava]  ");
				}
				logger.info("\n\n");
				if (r == row + 61)
					logger.info("------------------Luxary tickets----------------------\n");
			}

		}
	}

	public static void selectseat_no(DataAccess ticket) throws NumberFormatException, IOException {
		String seatno = "";
		int totalTickets = 0;

		String totalSeats = "";
		while (totalTickets < 8) {

			logger.info("select seat numbers that you want or enter e to exit");
			seatno = input.readLine();
			while (bookedSeats.contains(seatno)) {
				logger.info(seatno + " is already booked please choose other one");
				seatno = input.readLine();
			}
			if (seatno.equalsIgnoreCase("e")) {
				totalSeats = totalSeats.substring(0, totalSeats.length() - 1);
				break;
			} else {
				char userRow = seatno.charAt(0);

				if ((userRow >= 'A' || userRow >= 'a')
						&& (userRow <= (char) row + 65 - 4 || userRow <= (char) row + 97 - 4))
					premium++;
				else
					luxary++;
				totalTickets++;
				if (totalTickets == 7)
					totalSeats = totalSeats.concat(seatno);
				else
					totalSeats = totalSeats.concat(seatno + "-");

			}
		}
		ticket.setSeat_no(totalSeats);
		if (premium > 0 && luxary > 0) {
			ticket.setType("combination");
		} else if (premium > 0) {
			ticket.setType("premium");
		} else {
			ticket.setType("luxary");
		}
		ticket.setPremiumTicket(premium);
		ticket.setLuxaryTickts(luxary);

		ticket.setNoOfTickets(totalTickets);

	}


	public static void setSeatDetails() {

		locationDB.storeSeatInfo(ticket);

	}

	private static synchronized int totalAmount() {

		return (ticket.getPremiumTicket() * PREMIUM) + (ticket.getLuxaryTickts() * LUXARY);

	}

}
