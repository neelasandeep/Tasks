@TheaterPage
Feature: Movie Booking Theater selection Feature


Background:
Given user should be in Theater page
Scenario Outline: selecting theater Directly Clicking on theater Name
When user Selct Theater "<option>"
Then user should redirect to DateSelection page

Examples:
|option|
|2233-mukta cinemas|

Scenario: Checking theater feature without selecting theater
When user clicks on  next button  directly on theaterPage
Then it should be in theater page