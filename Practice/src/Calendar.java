import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		//This code will select Feb 27 2020
		// Get the MONTH		
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("February")) {
			// click next arrow in Calendar
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();

		}

		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.cssSelector("td[class='day']")).size();
		// check if date is equal to 27
		// Grab common attribute; put into list and iterate
		//NOTE: driver.findElements(By.className("day")) will not work if there is same day (ex.1) in one calendar so we should use By.cssSelector("td[class='day']")
		for (int i = 0; i < count; i++) {

			String text = driver.findElements(By.cssSelector("td[class='day']")).get(i).getText();
			if (text.equalsIgnoreCase("27")) {
				driver.findElements(By.cssSelector("td[class='day']")).get(i).click();
				break; 
			}

		}

	}

}
