@LocationPage
Feature: Movie Booking Location Feature


Background:
Given user should be in Location page

Scenario Outline: Checking location Directly Clicking on location Name
When user login with credentials "<username>" and password "<password>" in HomePage
And user Selct Location "<option>"
Then user should redirect to Movies page
And close the Browser

Examples:
|option|username|password|
|111-hyderabad|shubhi|1234|
|222-mumbai|shubhi|1234|
|333-bhopal|shubhi|1234|
|444-bangalore|shubhi|1234|
 
Scenario Outline: Checking Location feature without selectinglocation
When user login with credentials "<username>" and password "<password>" in HomePage
When user clicks on next button directly
Then it should be in same page
And close the Browser
Examples:
|username|password|
|shubhi|1234|