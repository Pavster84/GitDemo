package stepDefinations;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class stepDefination extends base {

	@Given("^Initalize the browser with chrome$")
	public void initalize_the_browser_with_chrome() throws Throwable {
		driver = initalizeDriver();
		driver.manage().window().maximize();		

	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		driver.get(arg1);

	}

	@Given("^Click on login link in home page to land on Secure sign in$")
	public void click_on_login_link_in_home_page_to_land_on_Secure_sign_in() throws Throwable {
		LandingPage l=new LandingPage(driver);
		if(l.getPopupSize().size()>0)
		{
			l.getPopup().click();
		}
		l.getLogin().click();

	}

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		
		lp.clickLogin().click();

	}

	@Then("^Verify user is successfully logged in$")
	public void verify_user_is_successfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='alert alert-danger']")).getText(), "Invalid email or password.");

	}
	
    @And("^Close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

	
}
