package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import pages.BaseClass;
import pages.LoginPage;
import pages.MainPage;

public class TestCases {
	public static WebDriver driver=null; 
	
	@BeforeTest
	public static void setUpFunction(){
		BaseClass b = new BaseClass();
		driver = b.setUpFunction("Chrome");
		driver.get("https://www.saucedemo.com");
	}
	
	@Test
	public static void TestCase1() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		
		Assert.assertTrue(loginPage.logIn("standard_user", "secret_sauce"),"Login successful");
//		l.logIn("problem_user", "secret_sauce");
		Assert.assertTrue(mainPage.logOut(),"Logout successful");
	}
	
	@Test
	public static void TestCase2() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		
		Assert.assertTrue(loginPage.logIn("problem_user", "secret_sauce"),"Login successful");
//		l.logIn("problem_user", "secret_sauce");
		Assert.assertTrue(mainPage.logOut(),"Logout successful");
	}
	
	@AfterTest
	public static void tearDown(){
		BaseClass b = new BaseClass();
		b.tearDown(driver);
	}
}
