Feature: Search Action
 
Scenario: Successful search of Hotel
 Given User is on Home Page
 When User enters destination and dates
 Then User is redirected to results page for that destination and dates
 
Scenario: Search resturns at least one result
 Given User is on Home Page
 When User enters destination and dates
 Then User can see at least one result in the list of Hotels
 
Scenario: Test set to fail to display Screenshot in Report
 Given User is on Home Page
 When User enters destination and dates
 Then User cannot see any result