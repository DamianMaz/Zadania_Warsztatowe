Feature: New user address

  Scenario Outline: Create new address
    Given user is registered on the: "https://mystore-testlab.coderslab.pl" page
    And user clicks on Sing in button
    When user logs on with "<email>" and "<password>"
    When user clicks on Addresses button
    When user clicks on Create New Address
    When user fills in New Address "<alias>", "<address>", "<city>", "<zipPostalCode>", "<country>", "<phone>" user clicks save button
    Then new address data is correct and contains "<alias>", "<address>", "<city>", "<zipPostalCode>", "<country>", "<phone>"

  Examples:
    |email                      |password   |alias|address    |city   |zipPostalCode|country       |phone    |
    |lucek@mjakmilosc.pl        |tajnehaslo3|Lucek|Kwiatowa 12|Grabina|00-001       |United Kingdom|505505505|