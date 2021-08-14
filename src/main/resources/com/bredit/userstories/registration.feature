@Registration
Feature: Registration

  Background:
  
  Scenario Outline: Register valid user
    Given the browser is "<browser>"
    And device is "<device>"
    And url is "<url>"
    And the mode is "<mode>"
    And  page is loaded
    And firstName is "<firstName>"
    And lastName is "<lastName>"
    And emails is "<email>"
    And phone is "<phone>"
    And dob is "<dob>"
    And gender is "<gender>"
    And cardNumber is "<cardNumber>"
    And expiryMonth is "<expiryMonth>"
    And expiryYear is "<expiryYear>"
    And nameOnCard is "<nameOnCard>"
    And password is "<password>"
    And confirmPassword is "<confirmPassword>"
    And click on submit button
    Then check if user is registered
    And close the browser

    Examples: 
      | browser |device    | mode     | url                             |  firstName |  lastName | email                | phone      |  dob       | gender  | cardNumber       | expiryMonth | expiryYear | nameOnCard     | password      | confirmPassword | 
      | firefox | iPad     | head     | https://bredit.org/registration |   Sailaja  |   Patoju  | sailaja123@gmail.com | 9493255656 | 09/08/2000 | female  | 6725123412341234 |     09      |     23     | Sailaja Patoju | password123#  | password123#    |
      | firefox | Desktop  | head     | https://bredit.org/registration |   Bitan    |   Sarkar  | bitan@gmail.com      | 9999999999 | 10/11/1987 |   male  | 5431111111111111 |     07      |     27     | Bitan Sarkar   | password@123  | password@123    |
      | firefox | Desktop  | headless | https://bredit.org/registration |   Bitan    |   Sarkar  | bitan@gmail.com      | 9999999999 | 10/11/1987 |   male  | 5431111111111111 |     07      |     27     | Bitan Sarkar   | password@123  | password@123    | 
