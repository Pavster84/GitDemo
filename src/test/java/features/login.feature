Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initalize the browser with chrome
And Navigate to "http://QAClickAcademy.com" site
And Click on login link in home page to land on Secure sign in
When User enters <username> and <password> and logs in
Then Verify user is successfully logged in
And Close browsers

Examples:
|username	|password1	|
|test99@gmail.com |123456	|
|test100@gmail.com |12345	|
