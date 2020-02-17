/**
 * 
 */
package com.lavante.sim.customer.pageobjects.SupportProperties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class BackGroundTasks {
	
	LavanteUtils lavanteUtils=new LavanteUtils();
	
	public BackGroundTasks(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	//Table Data
	
	@FindBy(css = "div[class*='caption']")
	public WebElement Backgroundtitle;
	
	
	@FindBy(css = "form[id*='Back'] td:nth-child(2)")
	public List<WebElement> BackgroundName;
	
	@FindBy(css = "form[id*='Back'] td:nth-child(4)")
	public List<WebElement> BackgroundFreq;
	
	@FindBy(css = "form[id*='Back'] td:nth-child(5)")
	public List<WebElement> BackgroundDesc;
	
	
	@FindBy(css= "button[class*='action_buttons']")
	private WebElement Actnbtn;

	@FindBy(id= "pause")
	private WebElement PauseBtn;
	
	@FindBy(id= "resume")
	private WebElement ResumeBtn;
	
	@FindBy(id= "start")
	private WebElement Processbtn;
	
	@FindBy(id= "reschedule")
	private WebElement Reschedulebtn;
	
	@FindBy(css= "[src*='reschedule']")
	private WebElement IFRAMEReschedule;
	
	@FindBy(id= "cronExpression")
	private WebElement cronExpression;
	
	@FindBy(css= "input[class*='primary']")
	private WebElement submitbtn;
	
	@FindBy(css= "div button[class*='primary']")
	private WebElement Yesbtn;
	
	/**
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	public void SelectBackgroundTaskAction(LinkedHashMap<String,String> dataMap){
		selectBGTask(dataMap);
		selectformAction(dataMap);
	}

	/**
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	private void selectBGTask(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("BackgroundTask")){
			String exp=dataMap.get("BackgroundTask");
			for(int i=0;i<BackgroundName.size();i++){
				String act=BackgroundName.get(i).getText();
				
				if(act.equalsIgnoreCase(exp)){
					lavanteUtils.click(BackgroundName.get(i));
					break;
				}
			}
		}
	}

	
	/**
	 * 
	 * @author Piramanayagam.S
	 * @param dataMap
	 */
	private void selectformAction(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("Pause")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(PauseBtn);
			lavanteUtils.click(Yesbtn);
		}
		if(dataMap.containsKey("Resume")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(ResumeBtn);	
			lavanteUtils.click(Yesbtn);
		}
		if(dataMap.containsKey("ProcessImmediately")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(Processbtn);	
			lavanteUtils.click(Yesbtn);
		}
		if(dataMap.containsKey("Reschedule")){
			lavanteUtils.click(Actnbtn);
			lavanteUtils.click(Reschedulebtn);
			
			
			lavanteUtils.switchtoFrame(IFRAMEReschedule);
			String x=dataMap.get("Reschedule");
			lavanteUtils.typeinEdit(x, cronExpression);
			lavanteUtils.click(submitbtn);
			
			
		}
		
	}
	
	
	//Sanity
	public boolean BackGround() throws FileNotFoundException, IOException, SQLException{
		
		boolean flag=false;
		
		Reporter.log("Expected Title: Configure Background Jobs,Actuals"+Backgroundtitle.getText(),true);
		Assert.assertEquals(Backgroundtitle.getText(), "Configure Background jobs","Title not matched");
		
		String count=""+BackgroundDesc.size();
		String x="select Count(JOB_NAME)from QRTZ_TRIGGERS";
		x=lavanteUtils.fetchDBdataPlatform(x);
		
		Reporter.log("Total count of Jobs"+x+",Actuals:"+count,true);
		Assert.assertEquals(x,count,"Job Count not matched");
		
		return flag;
		
	}
	
	
}
