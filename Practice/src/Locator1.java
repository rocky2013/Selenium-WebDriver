import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://facebook.com");

		// LOCATOR TECHNIQUES - using id, name, linkText
		/*
		  driver.findElement(By.id("email")).sendKeys("This is my first code");
		  driver.findElement(By.name("pass")).sendKeys("12345");
		  driver.findElement(By.linkText("Forgotten account?")).click();
		 */

		// Using cssSelector
		/*
		  driver.findElement(By.cssSelector("#email")).sendKeys("myemail");
		  driver.findElement(By.cssSelector("[id=email]")).sendKeys("myemail");
		  driver.findElement(By.cssSelector(".inputtext.login_form_input_box")).
		  sendKeys("myemail");
		 */

		driver.findElement(By.cssSelector("input.inputtext.login_form_input_box[name='email'")).sendKeys("myemail");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
		// Using Absolute xpath
		driver.findElement(By.xpath("//*[@id='login_form']/table/tbody/tr[3]/td[2]/div/a")).click();

	}

}
