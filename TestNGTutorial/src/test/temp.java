package test;

import org.testng.annotations.Test;

public class temp {
	
	
	 @Test(priority=1)
	    public void t1()
	    {
	        System.out.println("Running 1");
	    }
	    @Test(priority=2,dependsOnMethods="t1")
	    public void t2()
	    {
	        System.out.println("Running 2");
	    }
	    @Test(priority=3,dependsOnMethods="t2")
	    public void t3()
	    {
	        System.out.println("Running 3");
	    }
	    @Test(priority=4)
	    public void t4()
	    {
	        System.out.println("Running 4");
	    }
	//Actual output without the priority is: 1 4 2 3 
	    
	    
}
