package booking_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.log4j.Logger;
import book_ticket.BookedTicket;
import book_ticket.DataAccess;
import db_connector.DbOperations;
import db_connector.UserInformationDO;

public class BookTicket {
	private BookTicket() {
	}

	static BookTicket object;
	private static final int PREMIUM = 250;
	private static final int LUXARY = 150;

	public static BookTicket getInstance() {
		if (object == null) {
			synchronized (BookTicket.class) {
				if (object == null)
					object = new BookTicket();
			}
		}
		return object;
	}

	static DbOperations locationDB;
	static Logger logger = Logger.getLogger(BookTicket.class.getName());

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static DataAccess ticket = new DataAccess();

	

	public static void main(String[] args) throws IOException {
		locationDB = new DbOperations();

		ticket.setLocation(getLocationName());

		ticket.setMovieName(selctMovie());

		ticket.setTheater(selectTheater());
		ticket.setDate(selectDate());

		ticket.setTime(selectShowTime());
		SelectSeat.selectSeats(ticket,locationDB);

		ticket.setTotalCost(totalAmount());
		BookedTicket finalTicket = new BookedTicket();
		finalTicket.saveTicketData(ticket);
		setSeatDetails();
		new UserInformationDO().storeUserInfo(ticket);

	}

	public DataAccess getTicket() {
		return ticket;
	}

	public static  String getLocationName() throws IOException {
		logger.info("Select Your prefered Location:");
		locationDB.getLocations();
		return input.readLine().toLowerCase();

	}

	public static String selctMovie() throws IOException {
		logger.info("which movie you want to watch:");
		locationDB.getMovies(ticket);
		return input.readLine().toLowerCase();

	}

	private static String selectTheater() throws IOException {
		logger.info("Select your preferable theater:");
		locationDB.getTheaters(ticket);

		return input.readLine().toLowerCase();

	}

	private static String selectDate() throws IOException {
		Calendar calendar = Calendar.getInstance();
		for (int date = 0; date < 5; date++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			logger.info("\n" + new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));

		}

		return input.readLine();
	}

	private static String selectShowTime() throws IOException {
		logger.info("Select show timing:");
		ticket.setScreen(locationDB.showTimings(ticket));
		return input.readLine();

	}

	public static void setSeatDetails() {

		locationDB.storeSeatInfo(ticket);

	}

	private static synchronized int totalAmount() {

		return (ticket.getPremiumTicket() * PREMIUM) + (ticket.getLuxaryTickts() * LUXARY);

	}

}
