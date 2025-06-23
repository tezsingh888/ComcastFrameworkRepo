package com.comCast.crm.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comCast.crm.ObjectRepositoryUtility.ContactPage;
import com.comCast.crm.ObjectRepositoryUtility.ContactsInfoPage;
import com.comCast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.comCast.crm.ObjectRepositoryUtility.HomePage;
import com.comCast.crm.ObjectRepositoryUtility.LoginPage;
import com.comCast.crm.generic.fileUtility.excelUtility;
import com.comCast.crm.generic.fileUtility.fileUtility;
import com.comCast.crm.generic.webDriverUtilitys.JavaUtility;
import com.comCast.crm.generic.webDriverUtilitys.WebDriverUtility;

public class createContactWithSupportDateTest {
public static WebDriver driver=null;
	public static void main(String[] args) throws IOException {
		///without hardcoded data
		// common data i am fetching through property file and test script data fetching through excel file
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
	//step:2 navigate to Contact Module module
			HomePage hp= new HomePage(driver);
			hp.getContactLink().click();
	//step:3 click on "create contact"button
			ContactPage cp= new ContactPage(driver);
			cp.getCreateNewContactBtn().click();
		/*	Date dateObj= new Date();
			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate=sim.format(dateObj);
		Calendar cal= sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String endDate=sim.format(cal.getTime());
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			*/
	//step:4 enter all the details and create new contact
	String startDate=jlib.getSystemDatayyyyDDmm();
	String endDate=jlib.getRequiredDateyyyyDDmm(30); 
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
hp.logout();
	}

	}

