import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum=0;
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		//https://www.cricbuzz.com/-->live score-->select Matches-->Score card		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/23191/ban-vs-afg-only-test-afghanistan-tour-of-bangladesh-only-test-2019");
		
		//Get the parent section first which is the table
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		//Parent to Child Traverse
		//Go to the 3rd child of tag "div" which shows the scores		
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		System.out.println("Total row is: " + count);
		
		for(int i=0; i<count-2; i++) {			
			//System.out.println(table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());
			//to get the column scores "R"
			String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int sumValue =Integer.parseInt(value);
			sum = sum + sumValue;
		}
		
		//Sibling to Sibling traverse
		//We use //div[text()='Extras' instead of div[class='cb-col cb-col-100 cb-scrd-itms'] to make it unique to that section
		//System.out.println(table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());		
		String extrasVal = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int sumExtras = Integer.parseInt(extrasVal);
		int Total = sum + sumExtras;
		System.out.println("Sum is: " +Total);
								
		//System.out.println(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
		int actualTotal = Integer.parseInt(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
		
		if(Total==actualTotal) {
			System.out.println("Count Matches");
		}
		else {
			System.out.println("Count Fails");
		}
		
		
	}

}
