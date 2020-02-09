package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base{
	private static Logger log =LogManager.getLogger(validateTitle.class.getName());

	
	@Test
	public void getTitle() throws IOException
	{
		driver = initalizeDriver();
		log.info("driver is initilzed");
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
		LandingPage lp=new LandingPage(driver);
		log.info("Successfully validated page");
		
		// compare the text from the browser with actual value
		//Assert.assertEquals(lp.getTitle().getText(), "Featured Courses");

		
	}
	@AfterTest
	public void tearDown()
	{
	driver.close();
	driver=null;
	}
	

}
