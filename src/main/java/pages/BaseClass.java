package pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	private static RemoteWebDriver driver;

	public BaseClass(){
	}

	public WebDriver setUpFunction(String sBrowser){
		
		if(sBrowser.equals("Chrome")){
			// ChromeOptions browserOptions = new ChromeOptions();
			// browserOptions.setPlatformName("Windows 11");
			// browserOptions.setBrowserVersion("latest");
			// Map<String, Object> sauceOptions = new HashMap<>();
			// sauceOptions.put("username", "oauth-ravs788-f89eb");
			// sauceOptions.put("accessKey", "c2419996-b178-4bee-ad6b-95b0d8d55abe");
			// sauceOptions.put("build", "selenium-build-XQ3AT");
			// sauceOptions.put("name", "my-mavenTest");
			// browserOptions.setCapability("sauce:options", sauceOptions);
			// start the session
			// URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
			// driver = new RemoteWebDriver(url, browserOptions);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			// run commands and assertions
		}
		else if(sBrowser.equals("Firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver=new FirefoxDriver(options);
		}
		else if(sBrowser.equals("Edge")){
			EdgeOptions options = new EdgeOptions();
			options.addArguments("headless");
			driver = new EdgeDriver(options);
		}
		this.driver.manage().window().maximize();
		return driver;
	}
	
	public void tearDown(WebDriver driver){
		driver.close();
	}
}
