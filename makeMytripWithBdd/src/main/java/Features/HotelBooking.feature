@HotelBooking
Feature: HotelBooking
Scenario: Booking hotel from HomePage
Given User Should be in Hotels page
Then User enters Place and date to book hotel
And clicks on search Button
Then user provided with Multiple Filters to apply for hotel
When User clicks on specific hotel
Then  it will shows Book hotel option to click
Then it will moves to userdetails page
 
