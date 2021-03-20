package com.test.santhoshravichandran.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.santhoshravichandran.pages.CartPage;
import com.test.santhoshravichandran.pages.HomePage;

public class AutomationPracticeSteps extends ScenarioSteps {

    HomePage homePage;
    CartPage cartPage;

    @Step
    public void opens_home_page() throws InterruptedException {
        homePage.open();
        getDriver().findElement(By.xpath("//button[text()='Accept']")).click(); 
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//button[text()='I understand']")).click();
        Thread.sleep(1000);
    }


    
    @Step
    public void login(String username, String password) {        
        homePage.selectsignin();
        homePage.enterusername(username);
        homePage.enterpassword(password);
        homePage.signin();
    }

    @Step
    public void selectdress(String dresstype) {        
    	cartPage.selectdresstype(dresstype);
        
    }
    
    @Step
	public void addtocart() {
    	Actions action = new Actions(getDriver());
    	List<WebElement> productqty = getDriver().findElements(By.xpath("//*[@class='product-image-container']"));
    	
    	if(productqty.size() > 0) {
    		action.moveToElement(productqty.get(0)).click().perform();
    	}
    	
    	cartPage.clickaddtocart();
	}

	public void proceedcheckout() {
		cartPage.clickproceedcheckout();
	}

	public void checkshoppingcartsummary() {
		getDriver().switchTo().defaultContent();
		Assert.assertTrue(cartPage.checkcartsummary());
	}

	public void proceedcheckoutsumary() {
		cartPage.clickproceedcheckoutsummary();
	}

	public void checkaddress() {
		Assert.assertTrue(cartPage.checkaddress());		
	}

	public void proceedcheckoutaddress() {
		cartPage.clickproceedcheckoutaddress();
	}

	public void checkshipdetails() {
		Assert.assertTrue(cartPage.checkshipdetails());	
	}

	public void proceedcheckoutprocess() {
		cartPage.clickproceedprocess();
	}

	public void selectcgv() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();",getDriver().findElement(By.id("cgv")));
	}

	public void selectbankwire() {
		cartPage.selectbankwireoption();
	}

	public void confirmorder() {
		cartPage.confirmorder();
		Assert.assertTrue(cartPage.checkconfirmation());	
	}

	public void getreference() {
		cartPage.getorderreference();
	}

	public void validateplacedorder(String orderref) {
		cartPage.validateorderplaced(orderref);		
	}



}
