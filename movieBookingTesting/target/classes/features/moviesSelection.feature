@MoviePage
Feature: Movie selection Feature


Background:
Given user should be in Movie page
Scenario Outline: Checking Movies Directly Clicking on movie Name
When user Selct movie "<option>"
Then user should redirect to Theaterpage page

Examples:
|option|
|89564-antman|
|23456-baahubali|
|13456-saira|
|24567-notebook|
 
Scenario: Checking movies feature without selecting movie
When user clicks on  next button  directly on moviepage
Then it should be in movie page