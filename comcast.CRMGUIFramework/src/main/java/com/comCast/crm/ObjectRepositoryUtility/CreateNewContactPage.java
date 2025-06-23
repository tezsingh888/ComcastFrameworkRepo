package com.comCast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	WebDriver driver;// global variable
	public CreateNewContactPage(WebDriver driver) {// driver is a local variable
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	@FindBy(name="support_start_date")
	private WebElement supportStartDateTextField;
	@FindBy(name="support_end_date")
	private WebElement supportEndDateTextField;
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement organizationNamePlusIcon;
	@FindBy(name="search_text")
	private WebElement organizationSearch;
	@FindBy(name="search_field")
	private WebElement organizationNameDropdown;
	@FindBy(name="search")
	private WebElement organizationSearchNowButton;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getOrganizationSearch() {
		return organizationSearch;
	}
	public WebElement getOrganizationNameDropdown() {
		return organizationNameDropdown;
	}
	public WebElement getOrganizationSearchNowButton() {
		return organizationSearchNowButton;
	}
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	public WebElement getSupportStartDateTextField() {
		return supportStartDateTextField;
	}
	public WebElement getSupportEndDateTextField() {
		return supportEndDateTextField;
	}
	public WebElement getOrganizationNamePlusIcon() {
		return organizationNamePlusIcon;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
		
}
/*////input[@name='account_name']/following-sibling::img;
 * driver.findElement(By.name("search_text")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()="+orgName+"]")).click();
 * 
 * 
 * 
 */
