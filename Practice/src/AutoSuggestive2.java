import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//REQUIREMENTS:
		//enter the letters BENG
		//Verify if airport option is displayed in the suggestive box;
		//text is only displayed when using keydown
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);		
		Thread.sleep(2000);
		
		//This will not get the text because "class="ui-helper-hidden-accessible" because is hidden text/element
		//System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());
		//System.out.println(driver.findElements(By.xpath("//input[@id='fromPlaceName']")).size());
	
		//Javascript DOM can extract hidden elements because selenium cannot identify hidden elements - (Ajax Implementation)
		//investigate the properties of object if it have any hidden text
				
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// use "\" to eliminate error in double quote inside double quote; put semicolon; in the end its a must
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		System.out.println(text);
				
		int i=0;
		while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
			i++; 
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			 script = "return document.getElementById(\"fromPlaceName\").value;";
			 text = (String) js.executeScript(script);		
			 if(i>10) {
				 break;
			 }			 
		}
				
		if(i>10) {
			System.out.println("Element not found");
		}
		else {
			System.out.println("Element found");
		}	
		
		System.out.println(text);	
			
	
		
	}

}
