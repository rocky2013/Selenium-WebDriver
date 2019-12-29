import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");

		driver.findElement(By.xpath("//input[@value='Milk']")).click();
		// use .findelements and .size to get the no. of radio button
		// System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).size());
	

		// Section8_52 Handling radiobutton dynamically
		// if you don't have @value attribute you can get the desired button using the following:
		int count = driver.findElements(By.xpath("//input[@name='group1']")).size();

		for (int i = 0; i < count; i++) {

			// System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value"));
			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");

			if (text.equals("Cheese")) {
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			}

		}

	}
}
