import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign4Sec11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Window Handling assignment
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.cssSelector("a[href*='windows']")).click();
		
		Set<String>ids = driver.getWindowHandles();
		Iterator<String>it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);	
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());  	
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());

		
		
		
	}

}
