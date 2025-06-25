Feature: Login to saucedemo website

  Scenario Outline: Validate the login is successfull for saucedemo website
    Given the user launch the saucedemo URL
    When the User enter "<username>" and "<password>"
    And click on login button
    Then The user should be on home page
    And user need to add items to the cart
    And select the check out option
    And user enter the information asked "<Name>","<lastname>","<pincode>"
    And click on finish button
    And verify the "<thank you>" message

    Examples: 
      | username      | password     | thank you                 | Name    | lastname | pincode |
      | standard_user | secret_sauce | Thank you for your order! | Shalini | J        |  560033 |
