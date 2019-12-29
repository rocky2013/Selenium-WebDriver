import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Kaye\\eclipse-workspace\\chromedriver76\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");

		// validate if your page title is correct
		System.out.println(driver.getTitle());

		// validate if you have landed in the correct URL
		System.out.println(driver.getCurrentUrl());

		// System.out.println(driver.getPageSource()); //Print page source

		driver.get("http://yahoo.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.close(); // it closes current browser
		// driver.quit(); //it closes all browser opened by selenium script

	}

}
