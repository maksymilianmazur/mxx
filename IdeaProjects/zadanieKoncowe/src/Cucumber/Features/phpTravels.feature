Feature: PHPTravels reservation

  Scenario: user can book a flight
    Given an open browser with PHPTravels website
    When  user selects the flights tab
    And  user fills flight data
    And user press the button search
    And user selects a flight
    And user fills the login data
    And user fills the Billing Address data
    And user fills the payment types
    And user selects a checkbox with Rules&Restrictions and availability checking



