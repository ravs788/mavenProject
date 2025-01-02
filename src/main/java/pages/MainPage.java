package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import wrapper.Wrapper;

public class MainPage {
	private WebDriver driver = null;
	private Wrapper objWrapper = null;

	private String OpenMenuBtn = "//button[text()='Open Menu']";
	By locatorOpenMenu = By.xpath(OpenMenuBtn);

	private String LogOutBtn = "//a[text()='Logout']";
	By locatorLogOut = By.xpath(LogOutBtn);

	private String MainPageHeaderEle = "//div[@class='app_logo']";
	By locatorMainPageHeaderEle = By.xpath(MainPageHeaderEle);	

	public MainPage(WebDriver driver){
		this.driver = driver;
		this.objWrapper = new Wrapper();
	}


	public boolean logOut() throws InterruptedException{

		objWrapper.click(driver, driver.findElement(locatorOpenMenu));
		objWrapper.click(driver, driver.findElement(locatorLogOut));
		
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.VerifyLoginPage();
	}

	public boolean VerifyLoginSuccessful()
	{
		if(objWrapper.elementVisible(driver.findElement(locatorMainPageHeaderEle)))
			return true;
		else
			return false;
	}

}
