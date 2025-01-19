package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import wrapper.Wrapper;

public class MainPage {
	private WebDriver driver = null;
	private Wrapper objWrapper = null;

	private String openMenuBtn = "//button[text()='Open Menu']";
	By locatorOpenMenu = By.xpath(openMenuBtn);

	private String logOutBtn = "//a[text()='Logout']";
	By locatorLogOut = By.xpath(logOutBtn);

	private String mainPageHeaderEle = "//div[@class='app_logo']";
	By locatorMainPageHeaderEle = By.xpath(mainPageHeaderEle);	

	public MainPage(WebDriver driver){
		this.driver = driver;
		this.objWrapper = new Wrapper();
	}


	public boolean logOut() throws InterruptedException{

		if (objWrapper.waitOperation(driver, locatorOpenMenu))
		{
			objWrapper.click(driver, driver.findElement(locatorOpenMenu));
		}
		if (objWrapper.waitOperation(driver, locatorLogOut))
		{
			objWrapper.click(driver, driver.findElement(locatorLogOut));
		}
		LoginPage loginPage = new LoginPage(driver);
		return loginPage.verifyLoginPage();
	}

	public boolean verifyLoginSuccessful()
	{
		boolean eleFound = objWrapper.waitOperation(driver, locatorMainPageHeaderEle);
		if(eleFound)
		{
			return eleFound;
		}
		return false;
	}

}
