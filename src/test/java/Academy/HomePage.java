package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	private static Logger log =LogManager.getLogger(HomePage.class.getName());


	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String Text) throws Exception
	{
		driver = initalizeDriver();
		log.info("driver is initilzed");
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
		LandingPage l=new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		lp.clickLogin().click();
		log.info("User clicked on the login button");

		
	}
		
	@DataProvider
	public Object[][] getData()
	{
		// rows stand for how many different data types should run
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestricteduser@test.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		
		data[1][0]="restricteduser@test.com";
		data[1][1]="654321";
		data[1][2]="Not Restricted User";
		
		return data;
				
	}
			
	@AfterTest
	public void tearDown()
	{
	driver.close();
	driver=null;
	}
}
