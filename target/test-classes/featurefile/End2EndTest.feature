#Author: Rahul.Shah@Indecomm.net
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Automated End to End Test
Description: Test End to End Intergation of Mercury Tours Site

@FlightRoundTrip
  Scenario Outline: Customer is able to book the Round Trip flight
    Given User in on Mercury Tours Home Page
    And Enter "<UserName>" and "<Password>"
    Then Click on SignIn Button
    When User navigate to mercury Reservation Page
    When Click on RoundTrip Radio button
    Then Select Departing From dropdown option
    Then Select Arriving In dropdown option
    Then Select Service ClassType radio button
    Then Click on Continue button
    When User navigate to Airline booking details Page
    When Select Depart Flight details
    When Select Return Flight details
    Then Click Continue button
    When User navigate to Book flight landing Page
    Then Enter "FirstName" and "LastName" of Customer
    Then Enter Credit Card "Number" 
    Then Click on Secure Purchase button
    Then User will navigate to Flight Confirmation Page
    Then Ticket is booked Successfully
    Then User Click on Back to Home button

    Examples: 
      | UserName  | Password | FirstName  | LastName  | Number |
      | rahulshah1092@gmail.com | rahul@1992 | Rahul | Shah | 567643121 |
      
@FlightOneWay
  Scenario Outline: Customer is able to book the Round Trip flight
    Given User in on Mercury Tours Home Page
    And Enter "<UserName>" and "<Password>"
    Then Click on SignIn Button
    When User navigate to mercury Reservation Page
    When Click on OneWay Radio button
    Then Select Departing From dropdown option
    Then Select Arriving In dropdown option
    Then Select Service ClassType radio button
    Then Click on Continue button
    When User navigate to Airline booking details Page
    When Select Depart Flight details
    When Select Return Flight details
    Then Click Continue button
    When User navigate to Book flight landing Page
    Then Enter "FirstName" and "LastName" of Customer
    Then Enter Credit Card "Number" 
    Then Click on Secure Purchase button
    Then User will navigate to Flight Confirmation Page
    Then Ticket is booked Successfully
    Then User Click on Back to Home button
    
  	Examples: 
      | UserName  | Password | FirstName  | LastName  | Number |
      | rahulshah1092@gmail.com | rahul@1992 | Rahul | Shah | 567643121 |