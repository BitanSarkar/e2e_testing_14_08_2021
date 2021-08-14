@Home
Feature: Home

	Scenario Outline: The home page is loaded
    Given the browser is "<browser>"
    And the device is "<device>"
    And the mode is "<mode>"
    And url is "<url>"

    

  Scenario Outline: Home is clickable
  	Given the browser is "<browser>"
    And the device is "<device>"
    And the mode is "<mode>"
    And url is "<url>"
    And The home page is loaded
    When I click the Home button
    Then I will go to Home page
    And The close the browser
    
	  Examples: 
	      | browser | device  | mode   | url                |
	      | chrome  | iPad    |head	   | https://bredit.org |
	      | firefox | Desktop |head    | https://bredit.org |
	      | firefox | Desktop |headless| https://bredit.org |
 
  Scenario Outline: Login is clickable
    Given the browser is "<browser>"
    And the device is "<device>"
    And the mode is "<mode>"
    And url is "<url>"
    And The home page is loaded
    When I click the Login button
    Then I will go to Login page
    And The close the browser
    
	  Examples: 
	      | browser | device  | mode   | url                |
	      | chrome  | iPad    |head	   | https://bredit.org |
	      | firefox | Desktop |head    | https://bredit.org |
	      | firefox | Desktop |headless| https://bredit.org |

  Scenario Outline: Registration is clickable
    Given the browser is "<browser>"
    And the device is "<device>"
    And the mode is "<mode>"
    And url is "<url>"
    And The home page is loaded
    When I click the Registration button
    Then I will go to Registration page
    And The close the browser
    
	  Examples: 
	      | browser | device  | mode   | url                |
	      | chrome  | iPad    |head	   | https://bredit.org |
	      | firefox | Desktop |head    | https://bredit.org |
	      | firefox | Desktop |headless| https://bredit.org |