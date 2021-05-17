package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LogInPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		
		LandingPage l = new LandingPage(driver);
		// compare the browser text with actual text
		Assert.assertEquals(l.getTitle().getText(), "FEATUREDdfdfg COURSES");
		log.info("SuccessFully Validated text msg");
		
	}
	
	@AfterTest
	public void browserClose()
	{
		driver.close();
	}

	

}
