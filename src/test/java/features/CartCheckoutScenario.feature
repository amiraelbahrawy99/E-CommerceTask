Feature: Cart checkout functionality
  I want to check that authenticated user can checkout orders successfully

  Scenario Outline: Order Checkout
    Given user is on Authentication Page
    When user fill required registeration data "<email>","<firstName>" , "<lastName>" , "<password>" ,"<address>" , "<city>" ,"<state>" ,"<postalCode>" ,"<country>" ,"<mobilePhone>" ,"<addressAlias>"
    And user login with his registerd credentials "<email>","<password>"
    And user select "<item>" to buy with specific criteria "<size>" and "<colour>"
    And user proceed to checkout with specific "<paymentMethod>"
    Then order placed successfully and shown in order history Tab

    Examples: 
      | firstName | lastName   | email                    | password | address       | city  | state   | postalCode | country       | mobilePhone | addressAlias  | item   | size | colour | paymentMethod    |
      | Amira     | El-Bahrawy | amiraelbahrawy1@gmail.com |   123456 | SW 8th Street | Miami | Florida |      33129 | United States |  3057248697 | Tamiami Trail | Blouse | M    | white  | Pay by bank wire |
