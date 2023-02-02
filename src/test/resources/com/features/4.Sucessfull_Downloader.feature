Feature: Sucessfull Downloader Feature

@SucessfullDownloader
Scenario: Sucessfull Downloader Scenario
Given user is on SWGW login page
When user enters downloader role username
And user click on next button
When user enters downloader role password
And user clicks on Login button
Then click on download view icon at top left corner of the page
Then check whether tabs of download view is displayed
|My Target Groups|
|Pending Requests|
|License Search|
And click on My Target gropus
Then check the presence of four Tabs within My Target Groups
|Request Access|
|Remove Access|
|Finder icon|
|Table Access Icon|
And click on the EUFT Target Group
Then check the presence of three taps in EUFT Target Groups
|Tickets|
|Ticket Search|
|Delivery Report|
And click on Tickets tap
And click on Ticket ID column to sort decending order
And expand the ticket to check and download the product
And Expand the node inside the node
Then check the productname with version and download file names
And select the box that needs to be downloaded
And click on Download button
Then check the downloaded zip file is available under proper folder and unzip that file
When user click on ProductAdminView icon
When click on June2021 release
Then click on finder icon
When user enter product name in the search box and click on search button
Then click on product version
Then get all the file names and validate with downloaded files