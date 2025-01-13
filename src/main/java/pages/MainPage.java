package pages;


import java.time.Duration;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import base.BaseClass;
import wrapper.Wrapper;

@Component
public class MainPage extends BaseClass{

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private Wrapper objWrapper;

	private String OpenMenuBtn = "//button[text()='Open Menu']";
	By locatorOpenMenu = By.xpath(OpenMenuBtn);

	private String LogOutBtn = "//a[text()='Logout']";
	By locatorLogOut = By.xpath(LogOutBtn);

	private String MainPageHeaderEle = "//div[@class='app_logo']";
	By locatorMainPageHeaderEle = By.xpath(MainPageHeaderEle);	

	public boolean logOut(WebDriver driver){

		if (objWrapper.waitOperation(driver, locatorOpenMenu))
		{
			objWrapper.click(driver, driver.findElement(locatorOpenMenu));
		}
		if (objWrapper.waitOperation(driver, locatorLogOut))
		{
			objWrapper.click(driver, driver.findElement(locatorLogOut));
		}

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement eleOpenMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOpenMenu));

		// eleOpenMenu.click();
		// driver.findElement(locatorLogOut).click();

		return loginPage.verifyLoginPage(driver);
	}

	public boolean verifyLoginSuccessful(WebDriver driver)
	{
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(locatorMainPageHeaderEle));
		// List<WebElement> lstElements = driver.findElements(locatorMainPageHeaderEle);
		// return lstElements.isEmpty() ? true : false;
		return objWrapper.waitOperation(driver, locatorMainPageHeaderEle);
	}

}
