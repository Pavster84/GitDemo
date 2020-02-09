package resources;

import java.io.File;
import java.io.FileInputStream;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;

public class base {
	
	public static WebDriver driver;
	public Properties prop;
	
	@BeforeTest
	public WebDriver initalizeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\pavan\\ProjectFrameworkS26\\src\\main\\java\\resources\\Data.properties");
		
		// load file
		prop.load(fis);
		
		//chrome
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) //  use this when extracting from property 
		{
			// execute in chrome browser
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();	
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\IE\\IEDriverServer.exe");
			driver = new ChromeDriver();
		}		
		
		//driver.manage().window().maximize();
		// add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	public void getscreenshot(String result) throws IOException

	{

	File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(scr, new File("C:\\test\\"+result+"screenshot.png"));


	}

	}


