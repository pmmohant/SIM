package lavante.recovery.utilities;

import org.testng.Assert;
import org.testng.Reporter;

public class Report extends seleniumBaseClass {
	
	//seleniumBaseClass commom = new seleniumBaseClass();
	
	public static void pass(String message){
		
		System.out.println("Pass: "+message);
		Reporter.log("Pass: "+message);

	}

	
	public static void fail(String message){
		
		System.out.println("Fail: "+message);
		Reporter.log("Fail: "+message);
		takeScreenshot();
		Assert.fail("Fail: "+message);


	}		
	
	
	public static void info(String message){
		
		System.out.println("Info: "+message);
		Reporter.log("Info: "+message);

	}

}
