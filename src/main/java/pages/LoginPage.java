package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import wrapper.Wrapper;

public class LoginPage {
	private WebDriver driver = null;
	private Wrapper objWrapper = null;

	private String signInFlyMenu = "//div[@id='nav-tools']/a[@id='nav-link-yourAccount']"; 
	By locatorSignInFlyMenu = By.xpath(signInFlyMenu);

	private String signInBtn = "//div[@id='nav-flyout-ya-signin']//span[text()='Sign in']";
	By locatorSignInBtn = By.xpath(signInBtn);

	private String signInBtnAlt = "//div[@id='nav-signin-tooltip']//span[text()='Sign in']";
	By locatorSignInBtnAlt = By.xpath(signInBtnAlt);

	private String emailTxtBx = "//input[@name='email']";
	By locatorEmailTxtBx = By.xpath(emailTxtBx);

	private String emailContinueBtn = "//input[@id='continue']";
	By locatorEmailContBtn = By.xpath(emailContinueBtn);

	private String passWordTxtBx = "//input[@name='password']";
	By locatorPassWordTxtBx = By.xpath(passWordTxtBx);

	private String loginBtn = "//input[@id='signInSubmit']";
	By locatorLoginBtn = By.xpath(loginBtn);

	private String logOutLnk = "//a/span[text()='Sign Out']";
	By locatorLogOutLnk = By.xpath(logOutLnk);

	public LoginPage(WebDriver driver){
		this.driver = driver;
		this.objWrapper = new Wrapper();
	}


	public void logIn(String sUserName, String sPassword){

		if(objWrapper.elementVisible(driver.findElement(locatorSignInBtnAlt))){
			objWrapper.click(driver, driver.findElement(locatorSignInBtnAlt));
		}
		else{
			objWrapper.hoverOverElement(driver, driver.findElement(locatorSignInFlyMenu));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(objWrapper.elementVisible(driver.findElement(locatorSignInBtn))){
				objWrapper.click(driver, driver.findElement(locatorSignInBtn));
			}
			else{
				objWrapper.hoverOverElement(driver, driver.findElement(locatorSignInFlyMenu));
				objWrapper.click(driver, driver.findElement(locatorSignInBtn));
			}
		}

		objWrapper.setTextValue(driver, driver.findElement(locatorEmailTxtBx), sUserName);
		objWrapper.click(driver, driver.findElement(locatorEmailContBtn));

		objWrapper.setTextValue(driver, driver.findElement(locatorPassWordTxtBx), sPassword);
		objWrapper.click(driver, driver.findElement(locatorLoginBtn));
	}

	public void logOut(){
		if(objWrapper.elementVisible(driver.findElement(locatorLogOutLnk))){
			objWrapper.click(driver, driver.findElement(locatorLogOutLnk));
		}
		else{
			objWrapper.hoverOverElement(driver, driver.findElement(locatorSignInFlyMenu));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(objWrapper.elementVisible(driver.findElement(locatorLogOutLnk))){
				objWrapper.click(driver, driver.findElement(locatorLogOutLnk));
			}
			else{
				objWrapper.hoverOverElement(driver, driver.findElement(locatorSignInFlyMenu));
				objWrapper.click(driver, driver.findElement(locatorLogOutLnk));
			}
		}
	}

}
