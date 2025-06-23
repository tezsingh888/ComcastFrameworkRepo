package com.comCast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;// global variable
	public HomePage(WebDriver driver) {// driver is a local variable
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	@FindBy(linkText="More")
	private WebElement moreLink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	//Rule:4 Object Encapsulation
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getAdminImg() {
		return adminImg;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	//Rule-5 Business Library
	public void navigateToCampaginPage() {
		Actions act= new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();		
	}
	public void logout() {
		Actions act= new Actions(driver);
		act.moveToElement(adminImg).perform();
		signoutLink.click();	
		//driver.quit();
	
	}


}
