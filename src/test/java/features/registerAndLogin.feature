Feature: Register and Login

  @register_login
  Scenario: Register to system and login
    Given Get Login page URL
    When Open Register Page by click here linktext
    And Input to Email textbox
    And Click to Submit button
    Then Get Username and Password info
    When Back to Login Page
    And Submit valid info UserId and Password to Login Page
    Then Home Page is displayed
