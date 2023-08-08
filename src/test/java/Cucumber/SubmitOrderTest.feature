Feature: Purchase the order from Ecommerce Website

  Background:
    Given I landed on Ecommerce Page

  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <email> and password <password>
    When I add product <productName> in cart
    And checkout <productName> and Submit the order
    Then "THANKYOU FOR THE ORDER." message is shown on confirmationPage

    Examples:
      | email            | password      | productName     |
      | aun@gmail.com    | Asad19671999@ | ADIDAS ORIGINAL     |
      | shetty@gmail.com | Iamking@000   | ADIDAS ORIGINAL |
