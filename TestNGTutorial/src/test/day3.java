package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before executing any methods in the class");

	}

	@Parameters({ "URL", "APIKey/username" })
	@Test
	public void webLoginCarLoan(@Optional("Optional URL") String urlName, @Optional("Optional Key") String skey) {
		// selenium
		System.out.println("weblogincar");
		System.out.println(urlName);
		System.out.println(skey);
	}

	@BeforeMethod
	public void beforeEvery() {
		System.out.println("I will execute before every method in day 3");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After executing any methods in the class");
	}

	@AfterMethod
	public void afterEvery() {
		System.out.println("I will execute after every method in day 3");
	}

	@Test(groups = { "Smoke" })
	public void mobileLoginCarLoan() {
		// Appium
		System.out.println("mobilelogincar");
	}

	@BeforeSuite
	public void bfSuite() {
		System.out.println("I am no. 1");
	}

	@Test(enabled = false)
	public void mobileSignInCarLoan() {
		// Appium
		System.out.println("mobile SIG IN car");
	}

	// @Test(timeOut=4000)
	@Test(dataProvider = "getData")
	public void mobileSignOutCarLoan(String username, String password) {
		// Appium
		System.out.println("mobile Sign Out car");
		System.out.println(username);
		System.out.println(password);
	}

	// @Test(dependsOnMethods= {"WebLoginCarLoan"}) //can also be multiple
	@Test(dependsOnMethods = { "webLoginCarLoan", "mobileSignOutCarLoan" })
	// @Test
	public void apiCarLoan() {
		// Rest API automation
		System.out.println("loginAPIcar");
	}

	@DataProvider
	public Object[][] getData() {
		// 1st combination username password - good credit history
		// 2nd username, pass - no credit history
		// 3rd fraudulent credit history

		Object[][] data = new Object[3][2]; // 3 rows 2 columns (multidimensional object array)
		
		data[0][0] = "firstsetusername";
		data[0][1] = "firstpassword";
				
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		return data;

	}

}
