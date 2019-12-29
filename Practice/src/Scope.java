import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		// from INTERVIEW Question:
		// 1. give me the count of the links in the page
		System.out.println("count of all links: " + driver.findElements(By.tagName("a")).size());

		// 2. give me the count of the links in the footer section
		// Limiting the webdriver scope
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("footer count: " + footerDriver.findElements(By.tagName("a")).size());

		// 3. Count the links in the first column only
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("1st column count: " + columnDriver.findElements(By.tagName("a")).size());

		// 4. click on each of the column and check if the pages are opening; open as
		// another tab for every link; switch on every window and get the title
		int colSize = columnDriver.findElements(By.tagName("a")).size();

		for (int i = 1; i < colSize; i++) {

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);

		} 

		// Iterate on each and every tab and gives you the title
		Set<String> abc = driver.getWindowHandles(); // all the windows present
		Iterator<String> it = abc.iterator(); //move from one window to another
		
		while (it.hasNext()) // tells us whether next index is present or not
		{
			driver.switchTo().window(it.next()); 
			System.out.println(driver.getTitle());

		}

	}

}
