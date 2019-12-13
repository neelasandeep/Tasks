@registerPage
Feature: Movie Booking Registration Feature
Background:
Given user should be in Home page

Scenario Outline: Checking Regidter with new details
When user clicks on Registert
And user enters username "<Options>"
And user enters Password "<Options2>"
And clicks on Register now
Then it should display successful message

Examples:
| Options | Options2 |
| sand | 12344 |
#|ram|12345|
#Scenario: Checking Regidter with exsisting details
#Then it should display unsuccesful message