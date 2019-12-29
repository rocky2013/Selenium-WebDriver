import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndtoEndSec8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		//Selects One Way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		//From Delhi
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2000);
		//To Chennai; //Section8_48 Select the node using Parent child relationship to identify uniquely instead of using index
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//Section8_57 Handling Calendar UI using the crurrent date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		

		//.contains("1")) is enabled
		//.contains("0.5")) is disabled
		//check if calendar return is disabled when you click one way
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("its disabled");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//select senior citizen checkbox
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount'")).click();
		
		//click the passengers
		driver.findElement(By.id("divpaxinfo")).click();
		 Thread.sleep(2000L);
		
		//selects 5 adult  Section8_45
		for(int i=1;i<5;i++)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();		
		//Section8_58 
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		// Different ways of writing the locator for search button
		//driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		//driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		//driver.findElement(By.cssSelector("input[value='Search']")).click();
		//driver.findElement(By.xpath("//input[@value='Search']")).click();
		

	}

}
