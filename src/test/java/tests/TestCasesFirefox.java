package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.qameta.allure.Description;
import pages.BaseClass;
import pages.LoginPage;
import pages.MainPage;

public class TestCasesFirefox {
	public static WebDriver driver=null;
	
	@BeforeSuite
	public static void setUpFunction(){
		BaseClass b = new BaseClass();
		driver = b.setUpFunction("Firefox");
		driver.get("https://www.saucedemo.com");
	}
	
	@Test
	@Description("This test attempts to login as a standard user")
	public static void TestCase1() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		
		Assert.assertTrue(loginPage.logIn("standard_user", "secret_sauce"),"Login successful");
		Assert.assertTrue(mainPage.logOut(),"Logout successful");
	}
	
	@Test
	@Description("This test attempts to login as a problem user")
	public static void TestCase2() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		MainPage mainPage = new MainPage(driver);
		
		Assert.assertTrue(loginPage.logIn("problem_user", "secret_sauce"),"Login successful");
		Assert.assertTrue(mainPage.logOut(),"Logout successful");
	}
	
	@AfterSuite
	public static void tearDown(){
		BaseClass b = new BaseClass();
		b.tearDown(driver);
	}
}
