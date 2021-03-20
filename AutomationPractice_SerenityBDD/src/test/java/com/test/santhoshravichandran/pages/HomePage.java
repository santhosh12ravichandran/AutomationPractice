package com.test.santhoshravichandran.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("http://automationpractice.com")
public class HomePage extends PageObject {

    @FindBy(className = "login")
    WebElementFacade tabsignin;

    @FindBy(id="email")
    WebElementFacade txtusername;

    @FindBy(id="passwd")
    WebElementFacade txtpassword;

    @FindBy(id="SubmitLogin")
    WebElementFacade btnsignin;
    
    @FindBy(className="account")
    WebElementFacade acctname;
 
    @FindBy(xpath = "//*[@title='Orders']")
    WebElementFacade orderhistory;

    @FindBy(xpath = "//*[@class='icon-user']")
    WebElementFacade personalinfo;
    
    @FindBy(id="firstname")
    WebElementFacade txtfirstname;
    
    @FindBy(id="old_passwd")
    WebElementFacade txtcurpassword;
    
    @FindBy(name="submitIdentity")
    WebElementFacade btnsubmitidentity;
    
    @FindBy(className="alert alert-success")
    WebElementFacade successmessage;
    
    
    
    public void selectsignin() {
        getDriver().manage().window().maximize();
    	tabsignin.click();
    }
    
    
    public void enterusername(String username) {
        txtusername.sendKeys(username);
    }
    
    public void enterpassword(String password) {
        txtpassword.sendKeys(password);
    }
    
    public void signin() {
        btnsignin.click();
    }    

	public void navigatemyaccount() {
		acctname.click();		
	}

	public void navigateorderhistory() {
		orderhistory.click();		
	}


	public void navigatepersonalinfo() {
		personalinfo.click();
	}


	public void editfirstname() {
		txtfirstname.clear();
		txtfirstname.sendKeys("S"+RandomStringUtils.random(8,true,false));
	}


	public void providecurpwd(String password) {
		txtcurpassword.sendKeys(password);	
		btnsubmitidentity.click();
	}


	public boolean validatesuccesmessage() {
		
		String confirmtxt=null;
		boolean success = false;
		List<WebElement> confirmcontent = getDriver().findElements(By.xpath("(//*[@id='center_column']/div/p)"));
		for(WebElement a : confirmcontent) {
			confirmtxt = a.getText();
			if(confirmtxt.contains("Your personal information has been successfully updated")) {
				success = true;
				break;				
			}
		}
		
		return success;						
	}

}
