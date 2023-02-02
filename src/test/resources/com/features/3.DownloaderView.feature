Feature: Downloader View Feature

Background:
Given user has already logged in to application
|username|password|
|zrajala@ericsson.com|VXNpbGFtcGF0dGlAMTIzNA==|

@DownloaderView
Scenario Outline: Downloader View Scenario
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
And click on the EUFT Target Group which is blocked
Then check the presence of three taps in EUFT Target Groups
|Tickets|
|Ticket Search|
|Delivery Report|
And click on Tickets tap
And expand the ticket from whih box needs to be displayed
And select the box that needs to be downloaded
And click on Download button
Then Alert is displayed with message "<Alert_Message>"

Examples: 
        |Alert_Message|
        |CXP 903 0161/4 R1A could not be delivered to this customer - Please contact SW Gateway Support via https://ericsson.sharepoint.com/sites/SwGateway/SitePages/Rev%20B%205%20Support.aspx|