import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
				
		//1.Retrieve all values from the name column and add to the ArrayList
		List<WebElement> firstColList = driver.findElements(By.cssSelector("tr td:nth-child(3)"));
		sortColumn(firstColList, "desc", "integer");
			
	}
	
	public static void sortColumn(List<WebElement> firstColList, String order, String format){
		ArrayList<String> originalList = new ArrayList<String>();		
		for(int i=0; i<firstColList.size(); i++) {			
			//System.out.println(firstColList.get(i).getText());
			originalList.add(firstColList.get(i).getText());		
		}
		
		//2.Create a copy of the Arraylist and .sort
		ArrayList<String> copiedList = new ArrayList<String>();
		for(int i=0; i<originalList.size(); i++) {
			copiedList.add(originalList.get(i));  
		}
		
		if(format.equalsIgnoreCase("integer")) {
			Arrays.sort(copiedList.toArray());
			if(order.equalsIgnoreCase("desc")) {
				Arrays.sort(copiedList.toArray(),Collections.reverseOrder());
			}
		}
		else {
			//for STRING
			Collections.sort(copiedList);
			if(order.equalsIgnoreCase("desc")) {
				Collections.reverse(copiedList);//list in DESC
			}
		}
				
		
		System.out.println("*********ORIGINAL list***********");
		for(String s: originalList)  //Enhanced for loop equivalent to: for(int i=0; i<originalList.size();i++)
		{
			System.out.println(s);
		}
		
		
		System.out.println("*********SORTED list***********");
		for(String s: copiedList) 
		{
			System.out.println(s);
		}
		
		//3.Compare the 2 arrays
		Assert.assertTrue(originalList.equals(copiedList));
		
		
		
		
	}
	
	

}
