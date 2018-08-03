package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LoginPage;

public class TestCases {
	public static WebDriver driver=null; 
	
	@BeforeTest
	public static void setUpFunction(){
		BaseClass b = new BaseClass();
		driver = b.setUpFunction("Chrome");
		driver.get("https://www.amazon.in");
	}
	
	@Test
	public static void TestCase1(){
		LoginPage l = new LoginPage(driver);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.logIn("ravs788@gmail.com", "------");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l.logOut();
	}
	
	@AfterTest
	public static void tearDown(){
		BaseClass b = new BaseClass();
		b.tearDown(driver);
	}
}
