package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.ForgotPassword;
import PageObject.LandingPage;
import PageObject.LogInPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName, String Password, String text) throws IOException
	{
	
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		LogInPage lp = l.getLogIn();
		
		
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().sendKeys(Password);
		//System.out.println(text);
		
		log.info(text);
		
		lp.getLogIn().click();
		
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("xyz");
		fp.sendMeInstructions().click();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		// Row stand for how many diff. records to test
		// coloumn stands for how many values record contains
		Object[][] data = new Object[2][3];			// [2][3]while defining indexing start from 1 & in real from 0
		
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "abc@123";
		data[0][2] = "nonrestricteduser";
		
		
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "abc@12345";
		data[1][2] = "restricteduser";
		
		
		return data;

		
	}
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	

}
