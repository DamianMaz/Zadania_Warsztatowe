Feature: Buying product process

  Scenario Outline: Buying product in online shop
    Given user was registered on the: "https://mystore-testlab.coderslab.pl" page
    When clicks in Sign in button
    And user is logging on with "<email>" and "<password>"
    When user clicks on Hummingbird Printed Sweater button
    When user select M size
    And user selects five pieces
    And user add product to cart
    When user clicks on Proceed To Checkout button
    And clicks on Proceed To Checkout button again
    When user confirms address and clicks on Continue button
    When user clicks on PrestaShop field in shipping method
    When user ticks PayByCheck field
    And user ticks on terms of service agreement
    And user clicks on Place Order button
    Then user makes screenshot with order confirmation

    Examples:
    |email              |password   |
    |lucek@mjakmilosc.pl|tajnehaslo3|