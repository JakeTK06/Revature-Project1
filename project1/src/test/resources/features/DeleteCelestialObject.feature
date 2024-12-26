Feature: Delete planet or moon
  As a user I want to remove planets and moons from the Planetarium so I can correct my findings

  Background:
    Given the user is logged in
    And   the user is on the home page

  Scenario: User can delete a planet with valid data
    When  the user inputs valid planet deletion data
    And   the user submits planet deletion data
    Then  the planet should be deleted
    And   all of the planets moons should be deleted
    And   the table should refresh with less celestials

  Scenario: User cannot delete a planet with invalid data
    When  the user inputs planet deletion data
    And   the user submits planet deletion data
    Then the user should get a browser alert saying "Invalid planet name"

  Scenario: User can delete a moon with valid data
    When  the user inputs valid moon deletion data
    And   the user submits moon deletion data
    Then  the moon should be deleted
    And   the table should refresh with less moons

  Scenario: User cannot delete a moon with invalid data
    When  the user inputs moon deletion data
    And   the user submits moon deletion data
    Then  the user should get a browser alert saying "Invalid moon name"
