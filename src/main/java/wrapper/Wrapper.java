package wrapper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Wrapper {
	//	private FluentWait<WebDriver> fluentWait;

	public Wrapper(){
	}

	public void click(WebDriver driver,WebElement element) throws InterruptedException{
		//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		if(element.isDisplayed() && element.isEnabled())
		{
			element.click();
			Thread.sleep(5000);
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
		if(element.isDisplayed())
			return true;
		else
			return false;
	}
}
