package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	WebDriver driver;
	
	By logIn = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center");
	By navBar = By.xpath("//*[@id=\'homepage\']/header/div[2]/div/nav/ul");

	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}


	public LogInPage getLogIn()
	{
		 driver.findElement(logIn).click();
		 LogInPage lp = new LogInPage(driver);
		 return lp;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}


}
