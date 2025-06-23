package com.comCast.crm.orgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
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
import org.testng.annotations.Test;

import com.comCast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comCast.crm.ObjectRepositoryUtility.HomePage;
import com.comCast.crm.ObjectRepositoryUtility.LoginPage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comCast.crm.basetest.BaseClass;
import com.comCast.crm.generic.fileUtility.excelUtility;
import com.comCast.crm.generic.fileUtility.fileUtility;
import com.comCast.crm.generic.webDriverUtilitys.JavaUtility;
import com.comCast.crm.generic.webDriverUtilitys.WebDriverUtility;

public class createOrganizationTest extends BaseClass {
	
	@Test
	public void createOrganizationTest() throws EncryptedDocumentException, IOException{
	/*	// without hardcoded data
		fileUtility flib = new fileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		excelUtility eLib = new excelUtility();
		// System.out.println(pObj.getProperty("browser"));//pObj.getProperty("browser");
		String BROWSER = flib.getDataFromPropertyFile("browser");
		String URL = flib.getDataFromPropertyFile("url");
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");

		// generate the random no
		int randomInt = jlib.getRandomNumber();
		// Random random=new Random();
		// int randomInt=random.nextInt(1000);
		// read the the data from excel file
		String OrgName = eLib.getDataFromExcel("org1", 1, 2) + randomInt;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		// step:1 login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginTOApp(URL, USERNAME, PASSWORD);
		*/
		// generate the random no
				int randomInt = jLib.getRandomNumber();
				String OrgName = eLib.getDataFromExcel("org1", 1, 2) + randomInt;
		// step:2 navigate to organization module
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		// step:3 click on "createorganization"button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		// step:4 enter all the details and create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(OrgName);
		cnop.getSaveBtn().click();
		// verify Header message expected result
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headerInfo=oip.getHeaderMsg().getText();
		if (headerInfo.contains(OrgName)) {
			System.out.println(OrgName + "is created==Pass");
		} else {
			System.out.println(OrgName + "is not created==Fail");
		}
		// verify header OrgName info expected result
		String actOrgName=oip.getOrgNameVerification().getText();
		if (actOrgName.equals(OrgName)) {
			System.out.println(OrgName + " is created==Pass");
		} else {
			System.out.println(OrgName + "is not created==Fail");
		}
		// Step:5 logout
		//hp.logout();
		/*
		 * Actions act= new Actions(driver);
		 * act.moveToElement(driver.findElement(By.xpath(
		 * "//img[@src='themes/softed/images/user.PNG']"))).perform();
		 * driver.findElement(By.linkText("Sign Out")).click(); driver.quit();
		 */
	}
	@Test
	public void createOrganizationWithIndustriesTest() throws EncryptedDocumentException, IOException, InterruptedException {
		/*
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
			//Random random=new Random();
			//int randomInt=random.nextInt(1000);
			//read the the data from excel file
		  String OrgName =eLib.getDataFromExcel("org1", 4, 2)+randomInt;
		  String Industry =eLib.getDataFromExcel("org1", 4, 3);
		  String Type =eLib.getDataFromExcel("org1", 4, 4);
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
			LoginPage lp=new LoginPage(driver);
			lp.loginTOApp(URL, USERNAME, PASSWORD);
			*/
		Thread.sleep(2000);
		int randomInt=jLib.getRandomNumber();
		 String OrgName =eLib.getDataFromExcel("org1", 4, 2)+randomInt;
		  String Industry =eLib.getDataFromExcel("org1", 4, 3);
		  String Type =eLib.getDataFromExcel("org1", 4, 4);
	//step:2 navigate to organization module
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();
	//step:3 click on "createorganization"button
			OrganizationPage op=new OrganizationPage(driver);
			op.getCreateNewOrgBtn().click();
	//step:4 enter all the details and create new organization
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createOrg(OrgName, Industry);
	//sell1.selectByValue(Type)
				cnop.createOrgwitIndType(Type);	
	//verify Header message expected result
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String headerInfo =	oip.getHeaderMsg().getText();
	if(headerInfo.contains(OrgName)) {
		System.out.println(OrgName+"is created==Pass");
	}
	else {
		System.out.println(OrgName+"is not created==Fail");
	}
	//verify  header OrgName info expected result
	String actOrgName=oip.getOrgNameVerification().getText();
	if(actOrgName.equals(OrgName)) {
		System.out.println(OrgName+" is created==Pass");
	}
	else {
		System.out.println(OrgName+"is not created==Fail");
	}
	//Verify the industries and type information
	String actIndustries= oip.getIndustryVerification().getText();
	if(actIndustries.trim().equals(Industry)) {
		System.out.println(Industry+" Information is verified==Pass");
	}
	else {
		System.out.println(Industry+" Information is not verified==Fail");
	}
	String actType= oip.getIndustryTypeVerification().getText();
	if(actType.trim().equals(Type)) {
		System.out.println(Type+" Information is verified==Pass");
	}
	else {
		System.out.println(Type+" Information is not verified==Fail");
	}
	//Step:5 logout
	//hp.logout();
	}
	@Test
	public void createOrganizationWithPhoneNumberTest() throws EncryptedDocumentException, IOException, InterruptedException {
		/*fileUtility flib=new fileUtility();
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
					//read testscript data from excel file
				 String OrgName =eLib.getDataFromExcel("org1", 7, 2)+randomInt;
				 String PhoneNumber =eLib.getDataFromExcel("org1", 7, 3)+randomInt;
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
				LoginPage lp=new LoginPage(driver);
				lp.loginTOApp(URL, USERNAME, PASSWORD);
				*/
		Thread.sleep(2000);
		int randomInt=jLib.getRandomNumber();	
		//read testscript data from excel file
	 String OrgName =eLib.getDataFromExcel("org1", 7, 2)+randomInt;
	 String PhoneNumber =eLib.getDataFromExcel("org1", 7, 3)+randomInt;
				// step:2 navigate to organization module
				HomePage hp=new HomePage(driver);
				hp.getOrgLink().click();
				// step:3 click on "createorganization"button
				OrganizationPage op=new OrganizationPage(driver);
				op.getCreateNewOrgBtn().click();
				// step:4 enter all the details and create new Organization
				CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
				cnop.getOrgNameEdt().sendKeys(OrgName);
				cnop.getOrgPhoneNo().sendKeys(PhoneNumber);
                cnop.getSaveBtn().click();
			//verify Header message expected result
         OrganizationInfoPage oip= new OrganizationInfoPage(driver);
         String headerInfo =oip.getHeaderMsg().getText();
			if(headerInfo.contains(OrgName)) {
				System.out.println(OrgName+"is created==Pass");
			}
			else {
				System.out.println(OrgName+"is not created==Fail");
			}
			//verify  header OrgName info expected result
			String actOrgName=oip.getOrgNameVerification().getText();
			if(actOrgName.equals(OrgName)) {
				System.out.println(OrgName+" is created==Pass");
			}
			else {
				System.out.println(OrgName+"is not created==Fail");
			}
		//verify header phone Number into expected result
			String actPhoneNumber=oip.getPhoneNoVerification().getText();
if(actPhoneNumber.equals(PhoneNumber)) {
	System.out.println(PhoneNumber+" information is created==Pass");
}
	else {
		System.out.println(PhoneNumber+" Information is not created ==Fail");
	}
//step:5 logout
//hp.logout();
	}
}
