package com.comCast.crm.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comCast.crm.ObjectRepositoryUtility.ContactPage;
import com.comCast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.comCast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.comCast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comCast.crm.ObjectRepositoryUtility.HomePage;
import com.comCast.crm.ObjectRepositoryUtility.LoginPage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comCast.crm.generic.fileUtility.excelUtility;
import com.comCast.crm.generic.fileUtility.fileUtility;
import com.comCast.crm.generic.webDriverUtilitys.JavaUtility;
import com.comCast.crm.generic.webDriverUtilitys.WebDriverUtility;

public class createContactWithOrgTest {
	  public static WebDriver driver= null;
	public static void main(String[] args) throws IOException {
		fileUtility flib=new fileUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		excelUtility eLib=new excelUtility();
		//System.out.println(pObj.getProperty("browser"));//pObj.getProperty("browser");
		String BROWSER=flib.getDataFromPropertyFile("browser");
		String  URL=flib.getDataFromPropertyFile("url");
		String USERNAME=flib.getDataFromPropertyFile("username");
		String PASSWORD=flib.getDataFromPropertyFile("password");
		//generate the random no
	int randomInt=jlib.getRandomNumber();
			//read the the data from excel file 
			 String orgName =eLib.getDataFromExcel("Contact", 7, 2)+randomInt;
		   String contactLastName =eLib.getDataFromExcel("Contact", 7, 3)+randomInt;
					if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(BROWSER.equals("firefox")) {
				driver= new FirefoxDriver();
			}
			else if(BROWSER.equals("edge")) {
				driver= new EdgeDriver();		
		}
		else {
			driver= new ChromeDriver();
		}
			//step:1 login to app
					LoginPage lp = new LoginPage(driver);
					lp.loginTOApp(URL, USERNAME, PASSWORD);
					// step:2 navigate to organization module
					HomePage hp=new HomePage(driver);
					hp.getOrgLink().click();
					// step:3 click on "createorganization"button
					OrganizationPage op=new OrganizationPage(driver);
					op.getCreateNewOrgBtn().click();
		// step:4 enter all the details and create new Organization
					CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
					cnop.getOrgNameEdt().sendKeys(orgName);
					cnop.getSaveBtn().click();
	//verify Header message expected result
					OrganizationInfoPage oip=new OrganizationInfoPage(driver);
					String headerInfo=oip.getHeaderMsg().getText();
	if(headerInfo.contains(orgName)) {
		System.out.println(orgName+"header is created==Pass");
	}
	else {
		System.out.println(orgName+"header is not created==Fail");
	}
	//verify  header OrgName info expected result
	String actOrgName=oip.getOrgNameVerification().getText();
	if(actOrgName.trim().equals(orgName)) {
		System.out.println(orgName+" is created==Pass");
	}
	else {
		System.out.println(orgName+"is not created==Fail");
	}
//step:5 navigate to contact module
	//step:2 navigate to Contact Module module
	hp.getContactLink().click();
//step:3 click on "create contact"button
	ContactPage cp= new ContactPage(driver);
	cp.getCreateNewContactBtn().click();
//step:4 enter all the details and create new contact
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.getLastNameTextField().sendKeys(contactLastName);
	cncp.getOrganizationNamePlusIcon().click();
	// switch to child window
	wlib.switchToTabOnUrl(driver, "module=Accounts");
	cncp.getOrganizationSearch().sendKeys(orgName);
	cncp.getOrganizationSearchNowButton().click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	//switch to parent window
	wlib.switchToTabOnTitle(driver,"contact&action");
	cncp.getSaveBtn().click();
	//	verify header info info expected result
	ContactsInfoPage cip=new ContactsInfoPage(driver);
	headerInfo=cip.getHeaderMsg().getText();
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName+"header verified==Pass");
		}
		else {
			System.out.println(orgName+"header is verified");
		}
	//verify header orgName info expected result
		String actOrgName1=cip.getOrganizationNameVerification().getText();
		System.out.println(actOrgName1);
		if(actOrgName1.trim().equals(orgName)) {
			System.out.println(orgName+" is created==Pass");
		}
		else {
			System.out.println(orgName+"is not created==Fail");
		}
		//Step:5 logout
		hp.logout();
		driver.quit();
		
	}
}

