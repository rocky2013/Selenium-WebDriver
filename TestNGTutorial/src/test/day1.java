package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class day1 {

	@AfterTest
	public void lastExecution() {
		System.out.println("I will execute last");
	}

	@Test
	// Demo -> test case name
	public void demo() { 
		System.out.println("Hello");
		Assert.assertTrue(false); // to demonstrate failed listener
	}

	@AfterSuite
	public void afSuite() {
		System.out.println("Im the very last to execute");
	}

	@Test
	public void secondTest() {
		System.out.println("Bye");
	}

}
