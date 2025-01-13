package pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import base.BaseClass;
import wrapper.Wrapper;

@Component
public class LoginPage extends BaseClass{


	@Autowired
	private MainPage mainPage;

	@Autowired
	private Wrapper objWrapper;

	private String userNameTxtBx = "//input[@id='user-name']";
	By locatorUserName = By.xpath(userNameTxtBx);

	private String passWordTxtBx = "//input[@id='password']";
	By locatorPassWordTxtBx = By.xpath(passWordTxtBx);

	private String loginBtn = "//input[@value='Login']";
	By locatorLoginBtn = By.xpath(loginBtn);
	
	private String loginPageLogo = "//div[@class='login_logo']";
	By locatorLoginLogo = By.xpath(loginPageLogo);


	public boolean logIn(WebDriver driver, String sUserName, String sPassword){

		objWrapper.setTextValue(driver, driver.findElement(locatorUserName), sUserName);		
		objWrapper.setTextValue(driver, driver.findElement(locatorPassWordTxtBx), sPassword);
		if (objWrapper.waitOperation(driver, locatorLoginBtn))
		{
			objWrapper.click(driver, driver.findElement(locatorLoginBtn));
		}	
		// driver.findElement(locatorUserName).sendKeys(sUserName);
		// driver.findElement(locatorPassWordTxtBx).sendKeys(sPassword);
		// driver.findElement(locatorLoginBtn).click();
		
		return mainPage.verifyLoginSuccessful(driver);
	
	}

	public boolean verifyLoginPage(WebDriver driver)
	{
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(locatorLoginBtn));
		// List<WebElement> lstElements = driver.findElements(locatorLoginBtn);
		// return lstElements.isEmpty() ? true: false;

		return objWrapper.waitOperation(driver, locatorLoginBtn);
			
	}
	

}