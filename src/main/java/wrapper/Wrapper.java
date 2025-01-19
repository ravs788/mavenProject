package wrapper;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrapper {


	public void click(WebDriver driver,WebElement element) throws InterruptedException{
		if(element.isDisplayed() && element.isEnabled())
		{
			element.click();
		}
	}

	public void setTextValue(WebDriver driver,WebElement element, String txtValue){
		if(element.isDisplayed() && element.isEnabled())
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			element.sendKeys(txtValue);
		}
	}

	public void hoverOverElement(WebDriver driver,WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public boolean elementVisible(WebElement element){
		return element.isDisplayed();
	}

	public boolean waitOperation(WebDriver driver, By locator)
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return elementVisible(driver.findElement(locator));
	}
}
