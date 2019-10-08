package ticket_booking;

import java.io.IOException;
import java.util.logging.Logger;

public class UserRunner {
	

	static Logger logger = Logger.getLogger(UserRunner.class.getName());
	

	public static void main(String[] args) throws IOException {

		logger.info("\t\t\t--------------Welcome to Booking------------ \n");
		TicketBooking ticketBooking= TicketBooking.INSTANCE;
		
		ticketBooking.bookYourTicket();
		ticketBooking.confiramationMeassge();
		
		
		
		
   
	}

}

