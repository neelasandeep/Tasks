package book_ticket;

import java.util.Random;
import java.util.logging.Logger;



public class BookedTicket implements TicketData {

	public void saveTicketData(DataAccess ticket) {
		Logger logger = Logger.getLogger(BookedTicket.class.getName());

		ticket.setBookingId(generateBookingId());
		logger.info(ticket.toString());

	}

	public int generateBookingId() {
		Random randomNumber = new Random();
		return 100000 + randomNumber.nextInt(900000);
	}
}