import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
		System.out.println("*****Before switching*****");
		System.out.println(driver.getTitle());
		
		//returns a set of all Window handle of all browsers opened
		Set<String>ids = driver.getWindowHandles();  
		Iterator<String> it = ids.iterator();
		String parentId = it.next();  //moves to parent window
		String childId = it.next();  //moves to next child window		
		driver.switchTo().window(childId);	
		System.out.println("****After switching****");
		 //gets the title of the next child	
		System.out.println(driver.getTitle()); 	
		//switch back to parent window	
		driver.switchTo().window(parentId);		
		System.out.println("*****switching back to Parent****");
		System.out.println(driver.getTitle());
		
	}

}
