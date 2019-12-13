@Regression
Feature: Booking seats useCase

Scenario Outline: checking AllCombinations
Given user in the home page
#When User  Selcts location-> Movie-> Theater->->date->time->seat "<Options>"
#Then validates combinations
And close browser
Examples:
|Options|
|111-hyderabad|
#|222-mumbai|
#|333-bhopal|
#|444-bangalore|