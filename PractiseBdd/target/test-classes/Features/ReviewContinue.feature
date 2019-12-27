@Review
Feature: Reviwing and continue For furthur
Scenario Outline: Checking Flights Details
Given user should Be in Review Page "<Options>"
Then user will be in review page Tocheck Flight details 
And user Accepts T&c and Clicks Continue
Examples:
|Options|
|Home|