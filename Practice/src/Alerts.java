import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");

		driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();	
		System.out.println(driver.switchTo().alert().getText());
		// use accept for OK DONE and YES button
		driver.switchTo().alert().accept(); 
		//used if you have NO or CANCEL button (any negative)
		// driver.switchTo().alert().dismiss(); 

	}

}
