package book_ticket;

import java.util.Random;

import org.apache.log4j.Logger;




public class BookedTicket implements TicketData {

	public void saveTicketData(DataAccess ticket) {
		Logger logger = Logger.getLogger(BookedTicket.class.getName());

		ticket.setBookingId(generateBookingId());
		logger.info(ticket.toString());

	}

	public int generateBookingId() {
		
		return 100000 +  new Random().nextInt(900000);
	}
}
