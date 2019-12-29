import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	
		driver.get("https://login.salesforce.com/?locale=au");
		
		//Ways to get the locator of "Username"
		driver.findElement(By.cssSelector("input[id='username'")).sendKeys("test123"); 
		//driver.findElement(By.cssSelector("[class='input r4 wide mb16 mt8 username']")).sendKeys("test123");   
		//driver.findElement(By.cssSelector("input.r4.wide.mb16.mt8.username")).sendKeys("test123"); 
		
		//The code below will not work
		//driver.findElement(By.className("input.r4.wide.mb16.mt8.username")).sendKeys("test123"); 
		 
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("pass");
		//Using xpath 
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		//Using cssselector
		//driver.findElement(By.cssSelector("#Login")).click(); 
		
	}

}
