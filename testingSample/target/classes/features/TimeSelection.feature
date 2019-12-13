@TimePage
Feature: Movie Booking Time selection Feature

Background:
Given user should be in Location page



Scenario Outline: selecting Time Directly Clicking on displayed Time
When user login with credentials "<username>" and password "<password>" in HomePage
And user Selct Location "<option1>"
Then user should redirect to Movies page
When user Selct movie "<option>"
Then user should redirect to Theaterpage page
When user Selct Theater "<theater>"
Then user should redirect to DateSelection page
When user select one date from Options 
Then it should Display Show timings of that Date
When user Selct Time 
Then user should redirect to seats page
And close the Browser
Examples:
|theater||option||option1|username|password|
|1122-gold cinemas||89564-antman||111-hyderabad|shubhi|1234|







Scenario Outline: Checking Time feature without selecting Time
When user login with credentials "<username>" and password "<password>" in HomePage
And user Selct Location "<option1>"
Then user should redirect to Movies page
When user Selct movie "<option>"
Then user should redirect to Theaterpage page
When user Selct Theater "<theater>"
Then user should redirect to DateSelection page
When user select one date from Options 
Then it should Display Show timings of that Date
When user clicks on  next button  directly on TimePage
Then it should be in Time page
And close the Browser
Examples:
|theater||option||option1|username|password|
|1122-gold cinemas||89564-antman||111-hyderabad|shubhi|1234|