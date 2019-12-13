@TimePage
Feature: Movie Booking Time selection Feature


Background:
Given user should be in Time page
Scenario: selecting Time Directly Clicking on displayed Time
When user Selct Time 
Then user should redirect to seats page




Scenario: Checking Time feature without selecting Time
When user clicks on  next button  directly on TimePage
Then it should be in Time page