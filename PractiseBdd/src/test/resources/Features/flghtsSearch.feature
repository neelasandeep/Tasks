@FlightsSearch
Feature: Searching for flighjts
Scenario Outline: Searching for flights
Given user Should be in Home Page "<Options>"
When User enters trip details "<Options>"
Then clicks On Search Button "<Options>"


Examples:
|Options|
|Home|