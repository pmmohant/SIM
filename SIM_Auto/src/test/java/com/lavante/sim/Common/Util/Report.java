package com.lavante.sim.Common.Util;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;

public class Report extends LavanteUtils {
	
	//seleniumBaseClass commom = new seleniumBaseClass();
	
	static Logger log = Logger.getLogger(Report.class.getName());

	
	public static void pass(String message){
		
		System.out.println("Pass: "+message);
		Reporter.log("Pass: "+message);

	}

	
	public static void fail(String message){
		
		System.out.println("Fail: "+message);
		log.info(message);
		Reporter.log("Fail: "+message);
		/*File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(getPresentWorkingDir()+File.separator+dir+File.separator+randomnum()+".png"));*/
		Assert.fail("Fail: "+message);


	}		
	
	
	public static void info(String message){
		
		System.out.println("Info: "+message);
		log.info(message);
		Reporter.log("Info: "+message);

	}

}
