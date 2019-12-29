package test;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	@Parameters({"URL"})
	@Test
	public void webLoginHomeLoan(@Optional("Optional URL") String uname) {
		//selenium
		System.out.println("webloginPersonalLoan");
		System.out.println(uname);
	}
	
	@Test(groups={"Smoke"})
	public void mobileLoginHomeLoan() {
		//Appium
		System.out.println("mobileloginHome");
	}
	
	@Test
	public void loginAPIHomeLoan() {
		//Rest API automation
		System.out.println("loginAPIHome");
	}
	
	

}
