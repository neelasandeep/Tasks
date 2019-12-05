Feature: Movie Booking Location Feature

Background: 
Given user should be in Home page

Scenario Outline: Checking Locations Directly Clicking on Next Button
When user Selct Location "<option>"
Then user should redirect to Movies page

Examples:
|option|
|hyderabad|
|Chandigarh|
|Delhi|
|Bangalore|
 