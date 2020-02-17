package com.lavante.configurator.pageobjects;

import org.openqa.selenium.support.PageFactory;

import com.lavante.configurator.Common.Util.LavanteUtils;
import com.lavante.configurator.pageobjects.buyers.User.UsersPage;

public class pageInitiator extends LavanteUtils {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public SanityTest sanityTest;
	
	public UsersPage userPage;
	
	public void initiate()
	{

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		
		sanityTest = PageFactory.initElements(driver, SanityTest.class);
		
		userPage= PageFactory.initElements(driver, UsersPage.class);
	    
	}

}
