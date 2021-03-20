package com.test.santhoshravichandran.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends PageObject {
	
    @FindBy(xpath = "(//*[text()='T-shirts'])[2]")
    WebElementFacade tabtshirt;
    
    @FindBy(name = "Submit")
    WebElementFacade addcart;
    
    @FindBy(className = "page-heading")
    WebElementFacade pageheading;
    
    @FindBy(className = "fancybox-iframe")
    WebElementFacade frmaddcart;    
    
    @FindBy(xpath = "//*[@title='Proceed to checkout']")
    WebElementFacade proceedcheckout;
  
    @FindBy(name = "processAddress")
    WebElementFacade proceedcheckoutaddress;
    
    @FindBy(name = "processCarrier")
    WebElementFacade proceedcheckoutprocess;   
        
    @FindBy(xpath = "//*[@class = 'button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']")
    WebElementFacade proceedcheckoutsummary;
    
    @FindBy(id="cart_title")
    WebElementFacade carttitle;
  
    @FindBy(id="cgv")
    WebElementFacade cgv; 

    @FindBy(className="bankwire")
    WebElementFacade bankwire; 
    
    @FindBy(xpath = "//*[@class = 'button btn btn-default button-medium' and @type='submit']")
    WebElementFacade confirmorder; 
    
  //  @FindBy(xpath = "(//*[@id='center_column']/div/text())[6]")
    @FindBy(xpath = "(//*[@id='center_column']/div)")
    WebElementFacade orderconfirm; 
    
    
      public void selectdresstype(String dresstype) {
    	tabtshirt.click();
    }
  

	public void clickaddtocart() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		getDriver().switchTo().frame(frmaddcart);		
		addcart.click();
	}

	public void clickproceedcheckout() {
		proceedcheckout.click();
	}

	public boolean checkcartsummary() {
		if(carttitle.isDisplayed()) 
			return true;
		else
			return false;
			
		
	}

	public void clickproceedcheckoutsummary() {
		proceedcheckoutsummary.click();
	}

	public boolean checkaddress() {
		String pagetitle = pageheading.getText();
		if(pagetitle.equalsIgnoreCase("Addresses")) 
			return true;
		else
			return false;
	}

	public void clickproceedcheckoutaddress() {
		proceedcheckoutaddress.click();		
	}

	public boolean checkshipdetails() {
		String pagetitle = pageheading.getText();
		if(pagetitle.equalsIgnoreCase("Shipping")) 
			return true;
		else
			return false;
	
	}

	public void clickproceedprocess() {
		proceedcheckoutprocess.click();
	}

	public void clickcgv() {
		cgv.click();
		
	}

	public void selectbankwireoption() {
		bankwire.click();
	}

	public void confirmorder() {
		confirmorder.click();
		
	}

	public boolean checkconfirmation() {
		String pagetitle = pageheading.getText();
		if(pagetitle.equalsIgnoreCase("Order confirmation")) 
			return true;
		else
			return false;
	
	}

	public void getorderreference() {
		String confirmtxt=null;
		List<WebElement> confirmcontent = getDriver().findElements(By.xpath("(//*[@id='center_column']/div)"));
		for(WebElement a : confirmcontent) {
			confirmtxt = a.getText();
		}
						
		String arrref[] = confirmtxt.split("insert your order reference ");
		String arrfinalref[] = arrref[1].split(" in the subject of your bank wire");
		
		System.out.println("order confirmation Reference = " + arrfinalref[0]);
		
		Serenity.getCurrentSession().put("orderref", arrfinalref[0]);
		
	}

	public void validateorderplaced(String Orderref) {
		String Orderreference = null;
		List<WebElement> orderhist = getDriver().findElements(By.xpath("(//*[@class='first_item ']/td/a)"));
		for(WebElement a : orderhist) {
			Orderreference = a.getText();
			if(Orderreference.equalsIgnoreCase(Orderref)) {
				System.out.println("order found in History");
				break;
			}
		}
			
	}
}
