@Traveller
Feature: Filling traveller Details
Scenario Outline: Filling One Adult Info to Book Flight
Given User should be in Traveller Details page "<Options>"
Then user Fills Name, Mail, phno, Gender
Then Clicks On Continue
Examples: 
|Options|
|Home|