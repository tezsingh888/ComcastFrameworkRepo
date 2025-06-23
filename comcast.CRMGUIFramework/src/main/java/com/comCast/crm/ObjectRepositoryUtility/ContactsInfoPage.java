package com.comCast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
WebDriver driver;
public ContactsInfoPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="dtlview_Last Name")
private WebElement lastNameVerification;
@FindBy(id="dtlview_Support Start Date")
private WebElement suppStartDateVerification;
@FindBy(id="dtlview_Support End Date")
private WebElement suppEndDateVerification;
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement headerMsg;
@FindBy(id="mouseArea_Organization Name")
private WebElement organizationNameVerification;
public WebElement getLastNameVerification() {
	return lastNameVerification;
}
public WebElement getSuppStartDateVerification() {
	return suppStartDateVerification;
}
public WebElement getSuppEndDateVerification() {
	return suppEndDateVerification;
}
public WebElement getHeaderMsg() {
	return headerMsg;
}
public WebElement getOrganizationNameVerification() {
	return organizationNameVerification;
}

}
