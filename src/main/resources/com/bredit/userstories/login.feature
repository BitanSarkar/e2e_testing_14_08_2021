@Login
Feature: Login

  Background: 

  Scenario Outline: Login valid user
    Given the browser is "<browser>"
    And the device is "<device>"
    And the mode is "<mode>"
    And url is "<url>"
    And page is loaded
    And email is "<email>"
    And password is "<password>"
    And click on login button
    Then check if user is loggedin
    And close the browser

    Examples: 
      | browser | device  | mode   | url                      | email                | password     |
      | chrome  | iPad    |head	   | https://bredit.org/login | sailaja197@gmail.com | password123# |
      | firefox | Desktop |head    | https://bredit.org/login | bitan@gmail.com      | password@123 |
      | firefox | Desktop |headless| https://bredit.org/login | admin12@gmail.com    | password@123 |