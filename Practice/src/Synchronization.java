import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
		
		//Implicit timer
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//search NYC
		driver.findElement(By.id("FH-origin")).sendKeys("nyc");	
		driver.findElement(By.xpath("//a[contains(@data-value, 'NYC-All')]")).click();
		driver.findElement(By.id("FH-origin")).sendKeys(Keys.TAB);		
		//search LOS
		driver.findElement(By.id("FH-destination")).sendKeys("LOS");		
		driver.findElement(By.xpath("//a[contains(@data-value, 'QLA-All')]")).click();
		driver.findElement(By.id("FH-destination")).sendKeys(Keys.TAB);
		//From Date
		driver.findElement(By.id("FH-fromDate")).click();	
		driver.findElement(By.xpath("//button[@data-day='30']")).click();
		//To Date
		driver.findElement(By.id("FH-toDate")).click();	
		driver.findElement(By.xpath("//button[@data-day='13']")).click();
		//click Search
		driver.findElement(By.id("FH-searchButtonExt1")).click();
		
		//Explicit wait
		WebDriverWait d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='resultsContainer']/section/article[1]")));
		//click the first section of the result
		driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();
	

	}

}
