package com.epam.movie_ticket_booking;

import java.util.Date;
import java.util.logging.Logger;

import db_file.DBConnector;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

public class TicketBooking {

	static Logger logger = Logger.getLogger(TicketBooking.class.getName());
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static DBConnector caller = new DBConnector();
	static DataAccess ticket = new DataAccess();
	static int totalNoOfSeats = 0;
	static int premium;
    static int luxary;
	static List<String> theaterList;
	static List<String> movieList;
	static String selectedLocationName; 
	static String selectedTheater;
	static String selectedMovie;
	private TicketBooking() {}
	 public static synchronized void bookYourTicket() throws IOException {

		ticket.setLocation(selectLocation());

		caller.dbOperations();
		ticket.setMovieName(selctMovie());
		ticket.setTheater(selectTheater());
		ticket.setTime(selectShowTime());
		ticket.setNoOfTickets(selectSeats());
		ticket.setTotalseats(ticket.getTotalseats() - ticket.getNoOfTickets());
		ticket.setTotalCost(totalAmount());

	}

	private static String selectLocation() throws IOException {
		caller.getLocationName();

		selectedLocationName = input.readLine().toLowerCase();

		if (caller.locations.contains(selectedLocationName)) {
			return selectedLocationName;
		} else {

			TicketBooking.selectLocation();
		}
		return selectedLocationName;

	}

	private static String selctMovie() throws IOException {

		movieList = caller.getMoviesList(ticket.getLocation().toLowerCase());

		selectedMovie = input.readLine().toLowerCase();
		if (movieListNotContains(selectedMovie)) {
			TicketBooking.selctMovie();
		}

		return selectedMovie;

	}

	private static boolean movieListNotContains(String movie) {
		return !movieList.contains(movie);
	}

	private static String selectTheater() throws IOException {

		theaterList = caller.getTheatersList(ticket.getLocation(), ticket.getMovieName());
		selectedTheater = input.readLine().toLowerCase();
		if (theaterListNotContains(selectedTheater)) {
			TicketBooking.selectTheater();
		}

		return selectedTheater;

	}

	private static boolean theaterListNotContains(String theater) {
		return !theaterList.contains(theater);
	}

	private static String selectShowTime() throws IOException {
		caller.showTimings();
		String selectedShowTime = input.readLine();
		if (Float.parseFloat(selectedShowTime) > 12.0)
			return selectedShowTime + " PM";
		else
			return selectedShowTime + " AM";

	}

	private static int selectSeats() throws IOException {

		logger.info("Selct which type of Ticket\nPremium\nLuxary");
		String seatType = input.readLine();
		if (seatType.equalsIgnoreCase("Premium")) {
			ticket.setType("PREMIUM");
			 ticket.setNoOfTickets(selectNoOfSeats());
			totalNoOfSeats += ticket.getNoOfTickets();
		} else if (seatType.equalsIgnoreCase("Luxary")) {
			ticket.setType("LUXARY");
			ticket.setNoOfTickets(selectNoOfSeats());
			totalNoOfSeats += ticket.getNoOfTickets();
		} else {
			logger.info("Plese select a valid option");
			TicketBooking.selectSeats();
		}
		return totalNoOfSeats;
	}

	private static int selectNoOfSeats() throws IOException {
		int noOfSeats;
		logger.info("select no of tickets you want to book at most 10");
		noOfSeats = Integer.parseInt(input.readLine());
		if (noOfSeats > 10 ||noOfSeats < 1) {
			logger.info("Enter Valid no of tickets to book");
			return selectNoOfSeats();
		}
	  
		return noOfSeats;
	}

	private static int totalAmount() {
		return caller.getAmount(ticket.getNoOfTickets());
	}

	static void confiramationMeassge() {

		String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		logger.info("-------Summury of Booking Details----------\n"
				+ "No of Tickets Booked\t " + ticket.getNoOfTickets()
				+ "\ntype\t\t\t" + ticket.getType() + "\n"
				+ " Movie Name\t\t" + ticket.getMovieName() + " \n"
				+ "Theater Name \t\t"+ ticket.getTheater() + " \n"
				+ "Time\t\t\t" + ticket.getTime() + " \n"
				+ "Date\t\t\t" + date
				+ "\nYour total cost is\t " + ticket.getTotalCost() + "\n"
				+ "\n\t-----Thanks For Booking------");
	}

}
