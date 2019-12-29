import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.ebay.com/");
		// Count the link of the Entire Page
		System.out.println("Link in the entire page: " + driver.findElements(By.tagName("a")).size());
		// Count the links in the footer section of the page
		WebElement footer = driver.findElement(By.xpath(".//*[@id='glbfooter']"));
		System.out.println("Links in footer section: " + footer.findElements(By.tagName("a")).size());
		WebElement col = driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		System.out.println("Links in the 2nd coloumn of the section: " + col.findElements(By.tagName("a")).size());
		
		String Beforeclicking = null;
		String Afterclicking;
		// Checks if there is Site map in 2nd column, then click it
		for (int i = 0; i < col.findElements(By.tagName("a")).size(); i++) {
			if (col.findElements(By.tagName("a")).get(i).getText().contains("Site map")) {
				Beforeclicking = driver.getTitle();
				col.findElements(By.tagName("a")).get(i).click();
				break;
			}
		}

		Afterclicking = driver.getTitle();
		if (Beforeclicking != Afterclicking) {
			if (driver.getPageSource().contains("sitemap"))
				System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

	}

}
