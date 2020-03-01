package ashotapi;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class captureLogoImage {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement logoImageElement = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
		Screenshot logoImageScreenshot=new AShot().takeScreenshot(driver, logoImageElement);
		
		ImageIO.write(logoImageScreenshot.getImage(), "png", new File("C:\\Users\\pavan\\ProjectFrameworkS26\\Logos\\OrangeHRMlogo.png"));
		
		File f=new File("C:\\Users\\pavan\\ProjectFrameworkS26\\Logos\\OrangeHRMlogo.png");
		
		if(f.exists())
		{
			System.out.println("Image file captured");
		} else {
			System.out.println("Image not captured");
		}
				
		
		
	}

}
