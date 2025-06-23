package com.comCast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comCast.crm.ObjectRepositoryUtility.HomePage;
import com.comCast.crm.ObjectRepositoryUtility.LoginPage;
import com.comCast.crm.generic.databaseUtility.DataBaseUtility;
import com.comCast.crm.generic.fileUtility.excelUtility;
import com.comCast.crm.generic.fileUtility.fileUtility;
import com.comCast.crm.generic.webDriverUtilitys.JavaUtility;
import com.comCast.crm.generic.webDriverUtilitys.WebDriverUtility;

public class BaseClass {
	// create object
	public DataBaseUtility dLib = new DataBaseUtility();
	public fileUtility fLib = new fileUtility();
	public JavaUtility jLib = new JavaUtility();// generate the random no
	public excelUtility eLib = new excelUtility();// read the the data from excel file
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;

	@BeforeSuite
	public void configBS() {
		System.out.println("==connect to DB, Report Config===");
		dLib.getDBCOnnection2();
	}

	@BeforeClass
	public void configBC() throws IOException {
		System.out.println("===Launch the Browser===");
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("===login===");
		String URL = fLib.getDataFromPropertyFile("url");
		String USERNAME = fLib.getDataFromPropertyFile("username");
		String PASSWORD = fLib.getDataFromPropertyFile("password");
		LoginPage Lp = new LoginPage(driver);
		Lp.loginTOApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		System.out.println("===logout===");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void configAC() {
		System.out.println("===close the browser===");
		driver.quit();
		//driver.close();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("===close DB,Report backUP===");
		dLib.closeDBConnection();
	}
}
