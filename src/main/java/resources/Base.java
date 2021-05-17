package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		//
	    prop = new Properties();
		//FileInputStream fis = new FileInputStream("C:\\Users\\Nilesh\\Desktop\\Study\\Testing\\Practicle\\E2EProject\\src\\main\\java\\resources\\data.properties");
		//	 If someone else imported project he will get error for path location, we can create generic it as :
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		String driverName = prop.getProperty("browser");
		
		if(driverName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Nilesh\\Downloads\\Java\\Browser Driver\\chromedriver.exe");
			
			// for  headless execution  (2 lines code & one change as parameter in ChromeDriver)
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");   // and also add options in ChromeDriver as parameter

			 driver = new ChromeDriver(options);
		}
		else if(driverName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Nilesh\\Downloads\\Java\\Browser Driver\\geckodriver.exe");

			 driver = new FirefoxDriver();
		}
		else if(driverName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Nilesh\\Downloads\\Java\\Browser Driver\\IEDriverServer.exe");

			 driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = "G:\\Stuff\\reports\\"+testCaseName+".png";
		FileUtils.copyDirectory(src, new File(destination));
		return destination;
	}

}
