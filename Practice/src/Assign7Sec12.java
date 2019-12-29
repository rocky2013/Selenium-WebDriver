
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign7Sec12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
				
		//NOTE: limiting the web driver scope from driver to parent; table to row or Nested Elements
		WebElement table = driver.findElement(By.xpath("//table[@id='product']"));
		System.out.println("Number of columns: "+ table.findElements(By.tagName("tr")).size());
		System.out.println("Number of columns: "+ table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println("Instructor: " + secondrow.get(0).getText());
		System.out.println("Course: " + secondrow.get(1).getText());
		System.out.println("Price: " +secondrow.get(2).getText());
		
	}
	

}
