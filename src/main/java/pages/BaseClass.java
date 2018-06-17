package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	private WebDriver driver=null;

	public BaseClass(){
	}

	public WebDriver setUpFunction(String sBrowser){
		String path = System.getProperty("user.dir");
		switch (sBrowser){
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", path+"\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
			this.driver = new ChromeDriver();
		}
		this.driver.manage().window().maximize();
		return this.driver;
	}
	
	public void tearDown(WebDriver driver){
		driver.close();
	}
}
