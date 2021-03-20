package com.test.santhoshravichandran.gherkinscenariosteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import org.junit.Assert;

import com.test.santhoshravichandran.pages.HomePage;
import com.test.santhoshravichandran.steps.AutomationPracticeSteps;

public class AutomationPracticeScenarioSteps {

    @Steps
    AutomationPracticeSteps buyer;
    HomePage homePage;
    
    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() {
    	homePage.open(); 
    }
   
//    @Given("I am on the home page")
//    public void i_am_on_the_home_page() {
//    	homePage.open();    	
//    }
    
    @When("^signin to my account using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_add_Dress_to_the_shopping_cart(String username, String password) {
    	 buyer.login(username,password);    	
    }

    @When("^I add \"([^\"]*)\" to the shopping cart$")
    public void i_add_Dress_to_the_shopping_cart(String dresstype) {
    	 buyer.selectdress(dresstype);
    	 buyer.addtocart();
    }

    @When("^proceed to checkout$")
    public void proceed_to_checkout() {
    	 buyer.proceedcheckout();
    }

    @When("^validate the shopping cart and proceed$")
    public void check_the_shopping_cart_and_proceed() {
    	  buyer.checkshoppingcartsummary();
    	  buyer.proceedcheckoutsumary();
    }

    @When("^validate the address and proceed$")
    public void check_the_address_and_proceed() {
    	 buyer.checkaddress();
    	 buyer.proceedcheckoutaddress();
     }

    @When("^validate the shipping details and proceed$")
    public void check_the_shipping_details_and_proceed() {
    	buyer.checkshipdetails();
    	buyer.selectcgv();
   	 	buyer.proceedcheckoutprocess();
    }

    @When("^Select the bank wire payment and proceed$")
    public void select_the_bank_wire_payment_and_proceed() {
    	buyer.selectbankwire();
    }

    @When("^Confirm the order$")
    public void confirm_the_order() {
    	buyer.confirmorder();
    	buyer.getreference();
    }

    @Then("^The order should be in the order history$")
    public void the_order_should_be_in_the_order_history() {
    	String orderref = (String) Serenity.getCurrentSession().get("orderref");
    	homePage.navigatemyaccount();
    	homePage.navigateorderhistory();
    	buyer.validateplacedorder(orderref);
    }
        

    @And("^navigate to personal information$")
    public void navigate_to_personal_information() {
 	    homePage.navigatemyaccount();
    	homePage.navigatepersonalinfo();
    }
    
    @When("^edit first name$")
    public void edit_first_name() {
 	    homePage.editfirstname();
    }
    
    @When("^provide current password \"([^\"]*)\" to save$")
    public void provide_pwd_save(String password) {
    	homePage.providecurpwd(password);
     }
   
    @Then("^validate personal information details saved success message$")
    public void validate_success_Message() {
    	Assert.assertTrue(homePage.validatesuccesmessage());	
     }
    
   
  
}
