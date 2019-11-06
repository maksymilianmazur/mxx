Feature: CodersGuru registration
  Scenario: user can register a private account

    Given an open browser with CodersGuru website
    When user press the button „załóż konto”
    And user fills registration data
    And user selects a checkbox
    And user press a button „zarejestruj”
    Then  user has a private account