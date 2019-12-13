@TheaterPage
Feature: Movie Booking Theater selection Feature


Background:
Given user should be in Location page

Scenario Outline: selecting theater Directly Clicking on theater Name
When user login with credentials "<username>" and password "<password>" in HomePage
And user Selct Location "<option1>"
Then user should redirect to Movies page
When user Selct movie "<option>"
Then user should redirect to Theaterpage page
When user Selct Theater "<theater>"
Then user should redirect to DateSelection page
And close the Browser

Examples:
|theater||option||option1|username|password|
|1122-gold cinemas||89564-antman||111-hyderabad|shubhi|1234|

Scenario Outline: Checking theater feature without selecting theater
When user login with credentials "<username>" and password "<password>" in HomePage
And user Selct Location "<option1>"
Then user should redirect to Movies page
When user Selct movie "<option>"
Then user should redirect to Theaterpage page
When user clicks on  next button  directly on theaterPage
Then it should be in theater page
And close the Browser
Examples:
|option||option1|username|password|
|89564-antman||111-hyderabad|shubhi|1234|