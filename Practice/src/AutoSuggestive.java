import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.id("fromCity")).click();;
		
		WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));
		source.sendKeys("MUM");
		Thread.sleep(2000);
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
				
		WebElement dest = driver.findElement(By.xpath("//input[@placeholder='To']"));
		dest.sendKeys("DEL");
		Thread.sleep(2000);
		for(int i=0; i<3; i++ ) {
			dest.sendKeys(Keys.ARROW_DOWN);
		}
		dest.sendKeys(Keys.ENTER);
		
	}

}
