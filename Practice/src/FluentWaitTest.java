import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		//Using xpath parent child use "/"
		//driver.findElement(By.xpath("//div[@id='start']/button")).click();
		//Using cssselector parent child use space
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		//Class FluentWait implementing Wait interface
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		//This is key method (wait.until) which executes complete function
		  WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {			       
			    		    	 
			    	 if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
			    	 {
			    		 return driver.findElement(By.cssSelector("[id='finish'] h4"));
			    	 }
			    	 else
			    		 return null;
			     }
			   });
			 
		  //System.out.println(foo.getText());
		  //or 
		  System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
		  
	}

}
