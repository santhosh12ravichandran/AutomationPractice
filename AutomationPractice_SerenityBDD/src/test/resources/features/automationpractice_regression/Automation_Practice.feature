@automationpractice
Feature: automationpractice-testscenarios
	@regression
  Scenario Outline: order t-shirt
    Given I am on the home page
    And signin to my account using "<username>" and "<password>"
    When I add "<Order>" to the shopping cart
    And proceed to checkout
    And validate the shopping cart and proceed
    And validate the address and proceed
    And validate the shipping details and proceed
    And Select the bank wire payment and proceed
    And Confirm the order
    Then The order should be in the order history

    Examples: 
      | username                     | password | Order   |
      | automationtest2003@gmail.com |    12345 | t-shirt |
  
  @regression    
  Scenario Outline: change first name
    Given I am on the home page
    And signin to my account using "<username>" and "<password>"
    When navigate to personal information
    And edit first name 
    And provide current password "<password>" to save
    Then validate personal information details saved success message

     Examples: 
      | username                     | password |
      | automationtest2003@gmail.com |    12345 |
   