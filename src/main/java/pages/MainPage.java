package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

		if (objWrapper.Wait(driver, locatorOpenMenu))
		{
			objWrapper.click(driver, driver.findElement(locatorOpenMenu));
		}
		if (objWrapper.Wait(driver, locatorLogOut))
		{
			objWrapper.click(driver, driver.findElement(locatorLogOut));
		}
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.verifyLoginPage();
	}

	public boolean verifyLoginSuccessful()
	{
		boolean eleFound = objWrapper.Wait(driver, locatorMainPageHeaderEle);
		if(eleFound)
		{
			return eleFound;
		}
		return false;
	}

}
