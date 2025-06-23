package com.comCast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;// global variable
	public CreateNewOrganizationPage(WebDriver driver) {// driver is a local variable
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(name="accountname")
private WebElement orgNameEdt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;
@FindBy(name="industry")
private WebElement industryDD;
@FindBy(xpath="//select[@name='accounttype']")
private WebElement Indstype;
@FindBy(id="phone")
private WebElement orgPhoneNo;
public WebElement getIndstype() {
	return Indstype;
}
public WebElement getOrgPhoneNo() {
	return orgPhoneNo;
}
public WebElement getOrgNameEdt() {
	return orgNameEdt;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
public WebElement getIndustryDD() {
	return industryDD;
}
public void createOrg(String orgName) {
	orgNameEdt.sendKeys(orgName);
	saveBtn.click();	
}
public void createOrg(String orgName,String industry) {
	orgNameEdt.sendKeys(orgName);
	Select sel =new Select(industryDD);
	sel.selectByVisibleText(industry);
}
public void createOrgwitIndType(String type) {
	Select sel =new Select(Indstype);
	sel.selectByVisibleText(type);
	saveBtn.click();
}
}
