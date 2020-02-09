package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By login = By.xpath("//input[@name='commit']");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);		
	}
	
	public WebElement clickLogin()
	{
		return driver.findElement(login);
	}

}
