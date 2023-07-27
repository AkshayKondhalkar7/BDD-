  Feature: Create User

User is already on a login page

Background:
Given login into application
When v3 order title is shown as expected
Then Navigate user page
Then click on create user 



@smokeTest
Scenario: Create Client Collegiate
And click on client
Then enter all details required for client
Then submit the info
And Navigate to dashboard
Then verify client is created

Scenario Outline:: Create Client

And click on client
Then enter all "<name>" "<phoneNumber>" "<email>" "<password>" "<school>" "<organization>" "<position>" details reqd for client
Then submit the info
And Navigate to dashboard
Then verify client is created

Examples:
|name|phoneNumber|email|password|school|organization|position|
|Rohit Sharma|9874563210|rohit|123|Albion College|2023 Class Council|NA|
|Shubman Pandya|9874563210|Shubman|123|Albion College|2023 Class Council|NA|
|Akshay Kapoor|9874563210|akshay|123|Albion College|2023 Class Council|NA|





