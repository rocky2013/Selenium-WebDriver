import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assign2Sec8 {

	//1.Select 2 Adult and 3 Children and click on the current calendar date
	//2.Click "More Option" and enter the preferred airline and click search button
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		 // select 2 Adult
		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("2");

		s = new Select(driver.findElement(By.id("Childrens")));
		s.selectByIndex(3); 

		driver.findElement(By.id("DepartDate")).click(); 
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("MoreOptionsLink")).click(); 
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Quantas"); 
		driver.findElement(By.id("SearchBtn")).click(); 
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}

}
