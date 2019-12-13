@SeatPage
Feature: Movie Booking seating Feature


Background:
Given user should seats page
Scenario Outline: 
And user login with credentials "<username>" and password "<password>"
And user enterss location "<location>"
And user selects movie "<movie>"
And user selects theater "<theater>"
And user selects date "<date>"
And user selects time "<time>"
When user selects seat "<seat>"
Then user moves to payment and validates info in ticket

Examples:
|username|password|location|movie|theater|date|time|seat|
|shubhi|1234|111-hyderabad|23456-baahubali|2233-mukta cinemas|0|0|a1|
 
Scenario Outline: 
And user login with credentials "<username>" and password "<password>"
And user enterss location "<location>"
And user selects movie "<movie>"
And user selects theater "<theater>"
And user selects date "<date>"
And user selects time "<time>"
When user clicks on next button directly in seatspage
Then it should be in seats page

Examples:
|username|password|location|movie|theater|date|time|
|shubhi|1234|111-hyderabad|23456-baahubali|2233-mukta cinemas|0|0|