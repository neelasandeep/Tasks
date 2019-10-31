package booking_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import book_ticket.DataAccess;
import db_connector.DbOperations;

public class SelectSeat {
	private SelectSeat() {
	}

	static Logger logger = Logger.getLogger(SelectSeat.class.getName());

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	static int row;
	static int col;
	private static int premium = 0;
	private static int luxary = 0;
	static String seatno = "";
	static String seatNumbers = "";
	static int totalTickets = 0;
	private static List<String> bookedSeats = new ArrayList<>();

	static synchronized void selectSeats(DataAccess ticket, DbOperations locationDB) throws IOException {
		displayScreen(ticket, locationDB);
		selectSeatNo(ticket);

	}

	public static void displayScreen(DataAccess ticket, DbOperations locationDB) {

		String capacity = locationDB.getCapacity(ticket);
		String seats = locationDB.getSeatDetails(ticket);
		row = Integer.parseInt(capacity.split("-")[0]);
		col = Integer.parseInt(capacity.split("-")[1]);

		if (seats.equals("")) {
			showNewScreen();
		}

		else {
			showRemainingSeats(seats);
		}
	}

	private static void showRemainingSeats(String seats) {
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

	private static void showNewScreen() {
		for (int r = 65; r <= row + 65; r++) {
			if (r == 65)
				logger.info("-------------------premium tickets-----------------------\n");
			for (int c = 1; c <= col; c++) {
				logger.info((char) r + "" + c + "[Ava]  ");
			}
			logger.info("\n\n");
			if (r == row + 61)
				logger.info("------------------Luxary tickets----------------------\n");
		}
	}

	public static void selectSeatNo(DataAccess ticket) throws IOException {

		while (totalTickets < 8) {

			logger.info("select seat numbers that you want or enter e to exit");
			seatno = input.readLine();
			seatno = validateSeats(seatno);
			if (seatno.equalsIgnoreCase("e")) {
				seatNumbers = seatNumbers.substring(0, seatNumbers.length() - 1);
				break;
			} else {
				countTickets();

			}
		}
		ticket.setSeatNo(seatNumbers);
		categorizetickets(ticket);
		ticket.setPremiumTicket(premium);
		ticket.setLuxaryTickts(luxary);

		ticket.setNoOfTickets(totalTickets);

	}

	private static void categorizetickets(DataAccess ticket) {
		if (premium > 0 && luxary > 0) {
			ticket.setType("combination");
		} else if (premium > 0) {
			ticket.setType("premium");
		} else {
			ticket.setType("luxary");
		}
	}

	private static void countTickets() {
		char userRow = seatno.charAt(0);

		if ((userRow >= 'A' || userRow >= 'a') && (userRow <= (char) row + 65 - 4 || userRow <= (char) row + 97 - 4))
			premium++;
		else
			luxary++;
		totalTickets++;
		if (totalTickets == 7)
			seatNumbers = seatNumbers.concat(seatno);
		else
			seatNumbers = seatNumbers.concat(seatno + "-");
	}

	private static String validateSeats(String seatno) throws IOException {
		while (bookedSeats.contains(seatno)) {
			logger.info(seatno + " is already booked please choose other one");
			seatno = input.readLine();
		}
		return seatno;
	}

}
