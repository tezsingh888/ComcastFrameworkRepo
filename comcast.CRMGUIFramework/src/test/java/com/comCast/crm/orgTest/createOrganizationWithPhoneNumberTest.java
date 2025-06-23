package com.comCast.crm.orgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

import com.comCast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comCast.crm.ObjectRepositoryUtility.HomePage;
import com.comCast.crm.ObjectRepositoryUtility.LoginPage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationInfoPage;
import com.comCast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.comCast.crm.generic.fileUtility.excelUtility;
import com.comCast.crm.generic.fileUtility.fileUtility;
import com.comCast.crm.generic.webDriverUtilitys.JavaUtility;
import com.comCast.crm.generic.webDriverUtilitys.WebDriverUtility;

public class createOrganizationWithPhoneNumberTest {
	public static WebDriver driver=null;
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
hp.logout();
}
}
