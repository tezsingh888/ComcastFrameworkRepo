package com.comCast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;// global variable
	public OrganizationPage(WebDriver driver) {// driver is a local variable
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="search_text")
	private WebElement searchEdt;
	@FindBy(name="search_field")
	private WebElement searchDD;
	@FindBy(name="submit")
	private WebElement searchBtn;
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createNewOrgBtn;
public WebElement getCreateNewOrgBtn() {
	return createNewOrgBtn;
}
public WebElement getSearchEdt() {
	return searchEdt;
}
public WebElement getSearchDD() {
	return searchDD;
}
public WebElement getSearchBtn() {
	return searchBtn;
}


}
