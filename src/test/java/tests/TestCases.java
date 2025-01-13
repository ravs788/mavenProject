package tests;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import io.qameta.allure.Description;
import pages.LoginPage;
import pages.MainPage;

@SpringBootTest
public class TestCases{

	private WebDriver driver;

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private MainPage mainPage;

	@Autowired
	private BaseClass baseClass;

	@BeforeTest
	public void setUpFunction(){
		driver=baseClass.setUp();
	}
	
	@Test
	@Description("This test attempts to login as a standard user")
	public void TestCase1(){
		
		Assert.assertTrue(loginPage.logIn(driver,"standard_user", "secret_sauce"),"Login successful");
		Assert.assertTrue(mainPage.logOut(driver),"Logout successful");
	}
	
	@Test
	@Description("This test attempts to login as a problem user")
	public void TestCase2(){
		Assert.assertTrue(loginPage.logIn(driver,"problem_user", "secret_sauce"),"Login successful");
		Assert.assertTrue(mainPage.logOut(driver),"Logout successful");
	}
	
	@AfterTest
	public void tearDownFunction(){
		mainPage.tearDown();
	}
}
