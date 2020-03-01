package ashotapi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImages {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		BufferedImage expectedImage=ImageIO.read(new File("C:\\Users\\pavan\\ProjectFrameworkS26\\Logos\\OrangeHRMlogo.png"));
		
		WebElement logoImageElement = driver.findElement(By.xpath("//div[@id='divLogo']//img"));		
		Screenshot logoImageScreenshot=new AShot().takeScreenshot(driver, logoImageElement);
		
		BufferedImage actualImage=logoImageScreenshot.getImage();
		
		ImageDiffer imgDiff=new ImageDiffer();
		ImageDiff diff=imgDiff.makeDiff(expectedImage, actualImage);
		
		if(diff.hasDiff()==true)
		{
			System.out.println("Images are not the same");
		} else {
			System.out.println("Images are the same");
		}
		
		driver.quit();

	}

}
