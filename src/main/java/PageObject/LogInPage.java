package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
	
	WebDriver driver;
	
	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[id='user_password']");
	By login = By.cssSelector("[type='submit']");
	By forgotPassword = By.cssSelector("[href*='password']");

	
	public LogInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}


	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogIn()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
		
	}

}
