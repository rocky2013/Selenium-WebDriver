import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assign6Sec12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");	
		//1. Select any checkbox
		driver.findElement(By.id("checkBoxOption2")).click();		
		
		//2. Variable for the selected checkbox		
		String strOption = driver.findElement(By.cssSelector("label[for='benz']")).getText().trim();
		
		//3. Select an option in dropdown using the value from checkbox		
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(strOption);
		
		//4. Enter the label name of the checkbox in the Alert textbox
		driver.findElement(By.id("name")).sendKeys(strOption);
		
		//5.Clicked alert buttonalertbtn
		driver.findElement(By.id("alertbtn")).click();
		
		//5. Verify if step 2 is present in message alert
		//System.out.println(driver.switchTo().alert().getText().contains(strOption));
		String text = driver.switchTo().alert().getText();
		 if(text.contains(strOption)){
	    System.out.println("Alert message success");
	     }
	     else
	    System.out.println("Something wrong with execution");
		driver.switchTo().alert().accept();
		
		

	}

}
