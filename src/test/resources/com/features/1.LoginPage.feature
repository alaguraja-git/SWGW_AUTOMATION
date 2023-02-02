Feature: Login Page Feature

@LoginPage
Scenario: Login Page
Given user is on SWGW login page
When user enters downloader role username
And user click on next button
When user enters downloader role password
And user clicks on Login button
Then user gets the title of the page
And page title should be "SW Gateway 2022.09"