import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

		// TODO Auto-generated method stub
		String downloadPath = System.getProperty("user.dir");	//to make the path generic	
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
		
		//from ChromeOptions documentation link
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://altoconvertpdftojpg.com/");		
		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();
		Thread.sleep(3000);		
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\resources\\fileupload.exe");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

		driver.findElement(By.cssSelector("button[class*='medium']")).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		//Commented out if No strong antivirus
		//driver.findElement(By.linkText("Download Now")).click();   
		Thread.sleep(5000);   ///we cannot use WebdriverWait because this in not a web part but a desktop
		//File f = new File(downloadPath + "/converted.zip");
		File f = new File(downloadPath + "/temp.txt");
		if(f.exists()) {			
			Assert.assertTrue(f.exists());			
			if(f.delete()) {
				System.out.println("file deleted");
			}
		}

	}

}
