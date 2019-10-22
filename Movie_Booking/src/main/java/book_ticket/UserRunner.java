package book_ticket;

import java.io.IOException;
import java.util.logging.Logger;

import booking_process.TicketBooking;

public class UserRunner {

	static Logger logger = Logger.getLogger(UserRunner.class.getName());

	public static void main(String[] args) throws IOException {

		logger.info("\t\t\t--------------Welcome to Ticket Booking application------------ \n");

		TicketBooking ticketBooking = TicketBooking.getInstance();
		
		ticketBooking.bookYourTicket();
		BookedTicket finalTicket = new BookedTicket();
		DataAccess ticket = ticketBooking.getTicket();
		finalTicket.saveTicketData(ticket);

	}

}
