package com.comCast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;// global variable
	public OrganizationInfoPage(WebDriver driver) {// driver is a local variable
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
@FindBy(id="dtlview_Organization Name")//name="accountname"
private WebElement orgNameVerification;
@FindBy(id="dtlview_Industry")
private WebElement industryVerification;
@FindBy(id="dtlview_Type")
private WebElement industryTypeVerification;
@FindBy(id="dtlview_Phone")
private WebElement phoneNoVerification;
	public WebElement getOrgNameVerification() {
	return orgNameVerification;
}
public WebElement getIndustryVerification() {
	return industryVerification;
}
public WebElement getIndustryTypeVerification() {
	return industryTypeVerification;
}
public WebElement getPhoneNoVerification() {
	return phoneNoVerification;
}
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
}
