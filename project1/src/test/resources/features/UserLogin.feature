Feature: User Login
  As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

  Background:
    Given the user is on the login page


  Scenario: User can login with valid credentials
    #TODO: make sure to provide valid username/password in step implementation
    When  the user provides a valid username
    And   the user provides a valid password
    And   the user submits credentials
    Then  login is successful
    And   the user is redirected to the home page

  Scenario Outline: User cannot login with invalid credentials
    When  the user provides username "<username>"
    And   the user provides password "<password>"
    And   the user submits credentials
    Then  the user should get a browser alert saying "Invalid Credentials"
    And   the user should stay on the login page

  Examples:
    |username|password|
    |Batman  |b0ts    |
    |Robin   |Iamthenight1939|
    |Robin   |bots           |