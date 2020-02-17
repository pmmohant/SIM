package com.lavante.sim.customer.pageobjects.Dashboard;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * 
 * @author subhas.bv
 *
 */
public class ExpiringCertifications {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public ExpiringCertifications(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}
	
	@FindBy(css = "span[title]")
	public List<WebElement> chartsHeaderList;

	public List<WebElement> chartsHeaderList() {
		return chartsHeaderList;
	}

}
