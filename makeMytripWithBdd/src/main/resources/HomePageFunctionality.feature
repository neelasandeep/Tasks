@HomepageActions
Feature: checking Homepage Funtions
Background:
Given User should be in HomePage 
@navbar
Scenario Outline: checking navbar Items
When User clicks on any Option "<Options>" 
Then it should redirect to Selected page "<Options>"
Examples:
|Options|
|NavBar|
|more|

#
#@BrokenLinks
#Scenario:
#When user select any footerlinks it should give response