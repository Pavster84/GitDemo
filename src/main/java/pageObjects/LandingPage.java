package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	} 
	
	private By signin = By.xpath("//span[contains(text(),'Login')]");
	private By title = By.cssSelector(".text-center>h2");
	private By navBar = By.cssSelector(".navbar-right");
	private By popup = By.xpath("//button[contains(text(),'NO THANKS')]");
	private By registerBtn = By.xpath("//span[contains(text(),'Register')]");
	
	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public List<WebElement> getPopupSize()
	{
		return driver.findElements(popup);
	}

	public WebElement getPopup()
	{
		return driver.findElement(popup);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}
	
	public WebElement getRegisterBtn()
	{
		return driver.findElement(registerBtn);
	}
	

}
