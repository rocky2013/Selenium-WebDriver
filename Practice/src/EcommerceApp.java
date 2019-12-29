import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommerceApp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		// IMPLICIT WAIT applied to every line of this test
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

		WebDriverWait w = new WebDriverWait(driver, 5);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		
		// You can call an object without creating an object of the class by making that method static
		addItems(driver, itemsNeeded); 
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		//Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) {

			// Format it to get the actual vegetable name:
			String[] name = products.get(i).getText().split("-"); 
			String formattedName = name[0].trim();

			// converted to ArrayList to use the method "contains" for easy search
			// note: we declare array above to allocate low memory then you can convert it to ArrayList

			// Check whether extracted name is present in ArrayList not
			List itemNeededList = Arrays.asList(itemsNeeded);

			if (itemNeededList.contains(formattedName)) {
				j++;
				// Commented out the code below because 'ADD TO CART' will change to 'ADDED' after clicking. only use text() when it is static
				// driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				// select a static XPATH that never changes
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				// break; removing break here because this is an array list		
				if (j == itemsNeeded.length) { 
					break;
				}
			}

		}
	}

}
