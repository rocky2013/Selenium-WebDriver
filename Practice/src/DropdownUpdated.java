import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownUpdated {

	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.id("divpaxinfo")).click(); 		
		Thread.sleep(2000L); //2 seconds			
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Using FOR loop
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); 
		}	
		
		/*
		//If using WHILE Loop
		int i=1;
		while(i<5)  ///to loop until it is false
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		*/
						
		driver.findElement(By.id("btnclosepaxoption")).click();  
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		

	}

}
