package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.*;

public class BaseClass {

	private WebDriver driver;

	@Value("${browser}")
	private String sBrowser;

	@Value("${URL}")
	private String url;

	@Bean
	public WebDriver setUp(){
		
		if(sBrowser.equals("Chrome"))
			this.driver = new ChromeDriver();
		else if(sBrowser.equals("FireFox"))
			this.driver = new FirefoxDriver();
		else if(sBrowser.equals("Edge"))
			this.driver= new EdgeDriver();
		else
			this.driver = new ChromeDriver();
		
		this.driver.manage().deleteAllCookies();
		this.driver.manage().window().maximize();
		this.driver.get(url);
		
		return this.driver;
	}
	
	public void tearDown(){
		driver.close();
	}
}
