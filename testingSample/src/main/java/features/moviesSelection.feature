@MoviePage
Feature: Movie selection Feature


Background:
Given user should be in Location page
Scenario Outline: Checking Movies Directly Clicking on movie Name
When user login with credentials "<username>" and password "<password>" in HomePage
And user Selct Location "<option1>"
Then user should redirect to Movies page
When user Selct movie "<option>"
Then user should redirect to Theaterpage page
And close the Browser



Examples:
|option||option1|username|password|
|89564-antman||111-hyderabad|shubhi|1234|
#|23456-baahubali|
#|13456-saira|
#|24567-notebook|
 
Scenario Outline: Checking movies feature without selecting movie
When user login with credentials "<username>" and password "<password>" in HomePage
And user Selct Location "<option1>"
Then user should redirect to Movies page
When user clicks on  next button  directly on moviepage
Then it should be in movie page
And close the Browser
Examples:
|option||option1|username|password|
|89564-antman||111-hyderabad|shubhi|1234|