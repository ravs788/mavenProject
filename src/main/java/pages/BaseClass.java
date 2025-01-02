package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	private WebDriver driver=null;

	public BaseClass(){
	}

	public WebDriver setUpFunction(String sBrowser){
		
		switch (sBrowser){
		case "Chrome":
			this.driver = new ChromeDriver();
		}
		this.driver.manage().window().maximize();
		return this.driver;
	}
	
	public void tearDown(WebDriver driver){
		driver.close();
	}
}
