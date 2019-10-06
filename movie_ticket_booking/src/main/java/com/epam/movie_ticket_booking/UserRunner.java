package com.epam.movie_ticket_booking;

import java.util.logging.Logger;

public class UserRunner {

	static Logger logger = Logger.getLogger(UserRunner.class.getName());
	static DataAccess ticket = new DataAccess();

	public static void main(String[] args) throws Exception {

		logger.info("\t\t\t--------------Welcome to Booking------------ \n");
		TicketBooking.bookYourTicket();
		TicketBooking.confiramationMeassge();

	}

}
