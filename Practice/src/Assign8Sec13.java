import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assign8Sec13 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.findElement(By.id("autocomplete")).sendKeys("UNI");
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);		
		//another way to get the text aside from using JavascriptExecutor
		String text = driver.findElement(By.id("autocomplete")).getAttribute("value");
				
		int i=0;
		//United States
		while(!text.equalsIgnoreCase("United States")) {
			i++;
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			text = driver.findElement(By.id("autocomplete")).getAttribute("value");
			if(i>10) {
				break;			
			}			
		}
			
		if(i>10) {
			System.out.println("Element not found");
		}
		else {
			System.out.println(text);
		}
			

	}

}
