@flights
Feature: Flights Booking
Scenario Outline: Searching Flights From Home page
Given User in Home page "<Options>"
Then User enter trip details "<Options>"
And User clicks on serach Flights "<Options>"
#Then user can Select The Multiple-Filters and It will Apllies to the Flights
#When User Click on specific Flight To Continue
#Then user will be in review page Tocheck Flight details 
#Then user accepts T&C and proceeds to furthur process and User clicks Continue
#And user fill his/her personal info for ticket

Examples:
|Options|
|Home|





