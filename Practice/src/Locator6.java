import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
					
		driver.get("http://www.qaclickacademy.com/interview.php");
		
		
		//How to traverse to sibling element using "following-sibling"  
		 driver.findElement(By.xpath("//li[@id='tablist1-tab1']")).click();
		 System.out.println("Clicked on appium");
  	     driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[1]")).click();
  	     System.out.println("clicked on selenium");
  	     driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[2]")).click();
  	     System.out.println("clicked on soapUI");
  	     driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[3]")).click();
 	     System.out.println("Clicked on testing");
 	           
		
		/*
		//Using preceding-sibling	     
 	     driver.findElement(By.xpath("//li[@id='tablist1-tab3']")).click();
		 System.out.println("clicked on soapUI");
		 driver.findElement(By.xpath("//li[@id='tablist1-tab3']/preceding-sibling::li[1]")).click();
		 System.out.println("clicked on selenium");
		 driver.findElement(By.xpath("//li[@id='tablist1-tab3']/preceding-sibling::li[2]")).click();
		 System.out.println("clicked on Appium");
		*/
		 
		  //Section 7_41  Sample code for explaining text/sibling, parent
		  //driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();		 
		  //click Appium->Soap UI	
		  //driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();		  
		  //click Appium->Testing
		  //driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[3]")).click();
		  //System.out.println(driver.findElement(By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
 	     
 	    		
	}

}
