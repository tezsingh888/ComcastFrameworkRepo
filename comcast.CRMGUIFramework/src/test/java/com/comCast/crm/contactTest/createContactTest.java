package com.comCast.crm.contactTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comCast.crm.ObjectRepositoryUtility.ContactPage;
import com.comCast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.comCast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.comCast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comCast.crm.ObjectRepositoryUtility.HomePage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comCast.crm.basetest.BaseClass;

public class createContactTest extends BaseClass {
	//public static WebDriver driver= null;
	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException{
		//without hardcoded data
		// common data i am fetching through property file and test script data fetching through excel file
		/*	fileUtility flib=new fileUtility();
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
		read the the data from excel file 
		   String LastName =eLib.getDataFromExcel("Contact", 1, 2)+randomInt;
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
			*/
		int randomInt=jLib.getRandomNumber();
	//	read the the data from excel file 
		   String LastName =eLib.getDataFromExcel("Contact", 1, 2)+randomInt;
	//step:2 navigate to Contact Module module
			HomePage hp= new HomePage(driver);
			hp.getContactLink().click();
	//step:3 click on "create contact"button
			ContactPage cp= new ContactPage(driver);
			cp.getCreateNewContactBtn().click();
	//step:4 enter all the details and create new contact
			CreateNewContactPage cncp=new CreateNewContactPage(driver);
			cncp.getLastNameTextField().sendKeys(LastName);
			cncp.getSaveBtn().click();	
	//verify Header message expected result
			ContactsInfoPage cip= new ContactsInfoPage(driver);
			String headerInfo=cip.getHeaderMsg().getText();
	if(headerInfo.contains(LastName)) {
		System.out.println(LastName+"is created==Pass");
	}
	else {
		System.out.println(LastName+"is not created==Fail");
	}
	//verify  header LastName info expected result
	String actLastName=cip.getLastNameVerification().getText();
	if(actLastName.equals(LastName)) {
		System.out.println(LastName+" is created==Pass");
	}
	else {
		System.out.println(LastName+"is not created==Fail");
	}
	//Step:5 logout
	//hp.logout();
	//Actions act= new Actions(driver);
	//act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	//driver.findElement(By.linkText("Sign Out")).click();
	//driver.quit();	
	}
	@Test
	public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {
		///without hardcoded data
	/*			// common data i am fetching through property file and test script data fetching through excel file
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
			 String LastName =eLib.getDataFromExcel("Contact", 1, 2)+randomInt;
				  
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
					*/
					//generate the random no
					int randomInt=jLib.getRandomNumber();
							//read the the data from excel file 
					 String LastName =eLib.getDataFromExcel("Contact", 1, 2)+randomInt;
			//step:2 navigate to Contact Module module
					HomePage hp= new HomePage(driver);
					hp.getContactLink().click();
			//step:3 click on "create contact"button
					ContactPage cp= new ContactPage(driver);
					cp.getCreateNewContactBtn().click();
			//step:4 enter all the details and create new contact
			String startDate=jLib.getSystemDatayyyyDDmm();
			String endDate=jLib.getRequiredDateyyyyDDmm(30); 
			CreateNewContactPage cncp= new CreateNewContactPage(driver);
			cncp.getLastNameTextField().sendKeys(LastName);
			cncp.getSupportStartDateTextField().clear();
			cncp.getSupportStartDateTextField().sendKeys(startDate);
			cncp.getSupportEndDateTextField().clear();
		cncp.getSupportEndDateTextField().sendKeys(endDate);
		cncp.getSaveBtn().click();
			//verify Header message expected result
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String headerInfo=cip.getHeaderMsg().getText();
			if(headerInfo.contains(LastName)) {
				System.out.println(LastName+"is created==Pass");
			}
			else {
				System.out.println(LastName+"is not created==Fail");
			}
			//verify  LastName info expected result
			String actLastName=cip.getLastNameVerification().getText();
			if(actLastName.equals(LastName)) {
				System.out.println(LastName+" is created==Pass");
			}
			else {
				System.out.println(LastName+"is not created==Fail");
			}
			//verify support start date and support end date
			String actStartDate=cip.getSuppStartDateVerification().getText();
			if(actStartDate.equals(startDate)) {
				System.out.println(startDate+"information is verified== Pass");
			}
			else {
				System.out.println(startDate+"information is not verified==Fail");
			}
			String actEndDate=cip.getSuppEndDateVerification().getText();
			if(actEndDate.equals(endDate)) {
				System.out.println(endDate+"information is verified== Pass");
			}
			else {
				System.out.println(endDate+"information is not verified==Fail");
			}
			//Step:5 logout
		//hp.logout();
	}
	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
	/*	fileUtility flib=new fileUtility();
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
					*/
		//generate the random no
		int randomInt=jLib.getRandomNumber();
				//read the the data from excel file 
				 String orgName =eLib.getDataFromExcel("Contact", 7, 2)+randomInt;
			   String contactLastName =eLib.getDataFromExcel("Contact", 7, 3)+randomInt;
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
	wLib.switchToTabOnUrl(driver, "module=Accounts");
	cncp.getOrganizationSearch().sendKeys(orgName);
	cncp.getOrganizationSearchNowButton().click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	//switch to parent window
	wLib.switchToTabOnTitle(driver,"contact&action");
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
	//	hp.logout();
	}
}