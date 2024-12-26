Feature: User registration
  As a new user I want to open an account with the Planetarium so I can save my celestial findings

  Background:
    Given The user is on the login page
    And  The user clicks the register link

  Scenario: User can register a new account with valid credentials
    When  The user provides a valid username
    And   The user provides a valid password
    And   The user submits credentials
    Then  The user should get a browser alert saying "Account created successfully"
    And   The user should be redirected to the login page

  Scenario Outline: User can not register a new account with invalid credentials
    When  The user provides username "<username>"
    And   The user provides password "<password>"
    And   The user submits credentials
    Then  The user should get a browser alert saying "<alert>"
    And   The user should stay on the registration page

  Examples:
    |username|password|alert|
    |Batman                         |Krypton-was_2000                 |Invalid username|
    |Bane                           |Krypton-was_2000                 |Invalid username|
    |wonder_woman_for_the_DC_theming|Krypton-was_2000                 |Invalid username|
    |2face                          |Krypton-was_2000                 |Invalid username|
    |joker!!!!!?)                   |Krypton-was_2000                 |Invalid username|
    |Super_man-2001                 |b0Ts                             |Invalid password|
    |Super_man-2001                 |AlfredIsTheBestButlerToExist111  |Invalid password|
    |Super_man-2001                 |3atman                           |Invalid password|
    |Super_man-2001                 |A1fredIsTheBestButlerToExist!!   |Invalid password|
    |Super_man-2001                 |batman1                          |Invalid password|
    |Super_man-2001                 |BATMAN1                          |Invalid password|
    |Super_man-2001                 |Robin                            |Invalid password|