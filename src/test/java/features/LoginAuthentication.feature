Feature: Login Authentication functionality
  I want to check that user can login successfully with registered credentials

  Scenario Outline: Login Authentication
    Given user is on Authentication Page
    When user fill required registeration data "<email>","<firstName>" , "<lastName>" , "<password>" ,"<address>" , "<city>" ,"<state>" ,"<postalCode>" ,"<country>" ,"<mobilePhone>" ,"<addressAlias>" 
    And user login with his registerd credentials "<email>","<password>" 
    Then My account page is displayed succesfully
    
    
    Examples: 
      | firstName  | lastName   |       email             |  password   |     address      |  city   |  state    | postalCode |   country     |  mobilePhone | addressAlias  |
      |  Amira     |   Amin     |  salma@gmail.com    |   123456    |   SW 8th Street  |  Miami  |  Florida  |    33129   | United States |  3057248697  | Tamiami Trail | 
  
   