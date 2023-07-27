Feature: As a admin i should be able to create promocode

User is already on login page

Background:
Given enter username "username" and password "password"
Then click on loginbtn
And validate login is successful
Then click on promocode icon
And validate user is on promocodepage

Scenario: Create Promocode using percentage 
Given click on create promo code
Then enter promocode name
And select type as "type" and enter "value"
Then select limit as "limit" and enter "total usage"
Then check on allgroup orders
Then enter start date "startdate" and "starttime"
Then entar end date "enddate" and "endtime"
Then click on create group order promocode

