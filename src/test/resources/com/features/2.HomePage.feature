Feature: Home Page Feature

@HomePage
Scenario: Home Page 
Given user is on SWGW login page
When user enters downloader role username
And user click on next button
When user enters downloader role password
And user clicks on SignIn button
Given user is on Home page
When user gets the title of the page
Then page title should be "SW Gateway 2022"