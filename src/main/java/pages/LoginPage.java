package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import wrapper.Wrapper;

public class LoginPage {
	private WebDriver driver = null;
	private Wrapper objWrapper = null;

	private String userNameTxtBx = "//input[@id='user-name']";
	By locatorUserName = By.xpath(userNameTxtBx);

	private String passWordTxtBx = "//input[@id='password']";
	By locatorPassWordTxtBx = By.xpath(passWordTxtBx);

	private String loginBtn = "//input[@value='Login']";
	By locatorLoginBtn = By.xpath(loginBtn);
	
	private String loginPageLogo = "//div[@class='login_logo']";
	By locatorLoginLogo = By.xpath(loginPageLogo);

	public LoginPage(WebDriver driver){
		this.driver = driver;
		this.objWrapper = new Wrapper();
	}


	public boolean logIn(String sUserName, String sPassword) throws InterruptedException{

		
		objWrapper.setTextValue(driver, driver.findElement(locatorUserName), sUserName);		
		objWrapper.setTextValue(driver, driver.findElement(locatorPassWordTxtBx), sPassword);
		if (objWrapper.waitOperation(driver, locatorLoginBtn))
		{
			objWrapper.click(driver, driver.findElement(locatorLoginBtn));
		}	
		
		MainPage mainPage = new MainPage(driver);
		return mainPage.verifyLoginSuccessful();
	
	}

	public boolean verifyLoginPage()
	{
		boolean eleFound = objWrapper.waitOperation(driver, locatorLoginLogo);
		if (eleFound)
		{
			return eleFound;
		}
		return false;
	}
	

}