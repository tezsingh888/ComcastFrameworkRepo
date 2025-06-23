package com.comCast.crm.ObjectRepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtilitys.WebDriverUtility;
/**
 * @author Tej Singh
 * contains Login page elements and business lib like login()
 */
  public class LoginPage extends WebDriverUtility {
	  public WebDriver driver;// global variable
	  
	  public LoginPage (WebDriver driver){// driver is a local variable
		  	this.driver=driver;
		  	PageFactory.initElements(driver, this);
	  }
@FindBy(name="user_name")
private WebElement usernameEdt;
@FindBy(name="user_password")
private WebElement passwordEdt;
@FindBy(id="submitButton")
private WebElement loginButton;
//reule4:Object Encapsulation
public WebElement getUsernameEdt() {
	return usernameEdt;
}
public WebElement getPasswordEdt() {
	return passwordEdt;
}
public WebElement getLoginButton() {
	return loginButton;
}
// Rule:5 Provide Action // Business Library -provide business library if required
/**
 * login
 * @param url
 * @param username
 * @param password
 */
public void loginTOApp(String url ,String username,String password) {
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	waitForPageToLoad(driver);
	driver.get(url);
	driver.manage().window().maximize();
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginButton.click();
}
}

 