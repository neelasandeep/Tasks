@FlightsFilter
Feature: Applying filters
Scenario Outline: Applying Price Range Filter
Given user should be in Flights page "<Options>"
When User adjust the price Range He wants
Then User clicks On Specific Flight based on His price Range

Examples:
|Options|
|Deals|
