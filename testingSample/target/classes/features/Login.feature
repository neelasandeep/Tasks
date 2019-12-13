@LoginPage
Feature: Movie Booking Login Feature
Background:
Given user should be in Login page

Scenario Outline: Checking Login with correct details
#When user enter credential and clicks  "<username>" and "<password>"
#Then user should redirect to Home page
And shutDown browser
Examples:
|username| password|
|shubhi|1234|
Scenario Outline: checking Login with incorrect details
When user enters wrong credential and clicks "<username>" and "<password>"
Then it should diplay a wrong password
And shutDown browser
Examples:
|username| password|
|xhy|789|
Scenario Outline: checking Login with only UserName details
When user enters wrong credential and clicks "<username>" and "<password>"
Then it should be in Login Page
And shutDown browser
Examples:
|username| password|
|xhy| |
| |12345 |
|||


