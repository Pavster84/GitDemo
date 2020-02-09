package Academy;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base{
	private static Logger log =LogManager.getLogger(validateNavigationBar.class.getName());
	LandingPage lp;
	

	@Test
	public void validateNavBar() throws Exception
	{
		driver = initalizeDriver();
		log.info("driver is initilzed");
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));

		lp=new LandingPage(driver);
		
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());	
		log.info("Navigation bar is displayed as expected");
	}
	
	/*@Test
	public void validateAllCourses()
	{
		lp=new LandingPage(driver);
		
		Assert.assertTrue(lp.getRegisterBtn().isDisplayed());
	} */
	
	@AfterTest
	public void tearDown()
	{
	driver.close();
	driver=null;
	}
	

}
