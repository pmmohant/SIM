
package com.lavante.sim.customer.pageobjects.Admin.ManageFiles;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Piramanayagam.S
 *
 */
public class DownloadFiles {
	
	LavanteUtils lavanteUtils=new LavanteUtils();

	public DownloadFiles(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	
	@FindBy(how=How.CSS,using="[href*='customerDownloadFiles']")
	private WebElement Pagedownloadfile;	
	public WebElement Pagedownloadfile(){
		return Pagedownloadfile;
	}
	
	@FindBy(how=How.CSS,using="iframe[src*='download']")
	private WebElement IFRAMEdwnloadFile;	
	public WebElement IFRAMEdwnloadFile(){
		return IFRAMEdwnloadFile;
	}

	@FindBy(how=How.CSS,using="[id*='specify_data'] a")
	private WebElement specifydatadpdn;	
	public WebElement  specifydatadpdn(){
		return specifydatadpdn;
	}
	
	@FindBy(how=How.CSS,using="[id*='specific_data_change'] a")
	private WebElement specifydatedpdn;	
	public WebElement  specifydatedpdn(){
		return specifydatedpdn;
	}
	
	
	
	@FindBy(how=How.CSS,using="[type='submit']")
	private WebElement downloadbtn;	
	public WebElement  downloadbtn(){
		return downloadbtn;
	}
	
	@FindBy(how=How.CSS,using="[class*='dia'] button[class*='primary']")
	private WebElement OKbtn;	
	public WebElement  OKbtn(){
		return OKbtn;
	}
	
	
	

	@FindBy(how=How.CSS,using="[class*='refresh']")
	private WebElement refreshBtn;	
	public WebElement  refreshBtn(){
		return refreshBtn;
	}
	

	@FindBy(how=How.CSS,using="[id*='downloaded'] td:nth-child(1)")
	private List<WebElement> ListDownloadFile;	
	public List<WebElement>  ListDownloadFile(){
		return ListDownloadFile;
	}

	
	@FindBy(how=How.CSS,using="[id*='downloaded'] td:nth-child(3)")
	private List<WebElement> ListdownloadBy;	
	public List<WebElement>  ListdownloadBy(){
		return ListdownloadBy;
	}
	
	@FindBy(how=How.CSS,using="[id*='downloaded'] td:nth-child(4)")
	private List<WebElement> ListdownloadType;	
	public List<WebElement>  ListdownloadType(){
		return ListdownloadType;
	}

	@FindBy(how=How.CSS,using="[id*='downloaded'] td:nth-child(5)")
	private List<WebElement> ListdownloadNoofRecord;	
	public List<WebElement>  ListdownloadNoofRecord(){
		return ListdownloadNoofRecord;
	}

	
	@FindBy(how=How.CSS,using="[id*='downloaded'] td:nth-child(6)")
	private List<WebElement> ListdownloadStatus;	
	public List<WebElement>  ListdownloadStatus(){
		return ListdownloadStatus;
	}
	
	
	
	//Reusable Methods
	
	public void downloadFile(LinkedHashMap<String, String> dataMap) throws IOException {
		
		fillUpload(dataMap);
		formActionUpload(dataMap);
			
	}
	
	
	private void fillUpload(LinkedHashMap<String, String> dataMap) throws IOException {
		lavanteUtils.switchtoFrame(null);
		if(dataMap.containsKey("specifydata")){

				lavanteUtils.click(specifydatadpdn());
				lavanteUtils.selectvalueFrmDpdn(dataMap.get("specifydata"));
		}
		
		if(dataMap.containsKey("specifydate")){
		
			lavanteUtils.click(specifydatedpdn());
			lavanteUtils.selectvalueFrmDpdn(dataMap.get("specifydate"));
		
		}
		
		
	}
	
	private void formActionUpload(LinkedHashMap<String, String> dataMap) {
		lavanteUtils.switchtoFrame(null);
		if(dataMap.containsKey("Request")){
			lavanteUtils.click(downloadbtn());
			lavanteUtils.switchtoFrame(null);
		}
		


	}
	
	private boolean refreshgrid(WebElement iframe,
			String expStatus) {
		boolean flag=false;
		String actStatus="";
		int i=0;
		
		do{
			
			lavanteUtils.switchtoFrame(iframe);
			
			actStatus=ListdownloadStatus().get(0).getText();
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(refreshBtn());
			refreshBtn.click();
			i=i+1;
			System.out.println(i+actStatus+expStatus+flag);
			if(actStatus.contains(expStatus)){
				flag=true;
			}				
		}while((!(flag==true))&&(i<50));
	
		return flag;
	}
	
	
	
	
	
	public boolean refreshDownloadHistoryTable(LinkedHashMap<String, String> dataMap) {
		boolean flag=false;
		lavanteUtils.switchtoFrame(IFRAMEdwnloadFile());
		lavanteUtils.fluentwait(ListdownloadStatus().get(0));
		if(dataMap.containsKey("Status")){
			String expStatus=dataMap.get("Status");
			String actStatus=ListdownloadStatus().get(0).getText();
			
			if(actStatus.equalsIgnoreCase(expStatus)){
				flag=true;
			}else {
				flag=refreshgrid(IFRAMEdwnloadFile,expStatus);
			}
		}
		return flag;
		
		}
	
		
		/*if(dataMap.containsKey("Status")){
			String expStatus=dataMap.get("Status");
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.fluentwait(refreshBtn());
			refreshBtn().click();
			
			lavanteUtils.switchtoFrame(IFRAMEdwnloadFile());
			
			String actStatus=ListdownloadStatus().get(0).getText();
			int j=0;
			do{
				lavanteUtils.switchtoFrame(IFRAMEdwnloadFile());
				actStatus=ListdownloadStatus().get(0).getText();
				lavanteUtils.switchtoFrame(null);
				lavanteUtils.fluentwait(refreshBtn());
				refreshBtn().click();
				j++;
				
			}while((!expStatus.equalsIgnoreCase(actStatus))&&(j<50));
			
		}
		*/
	
	

	
	

}
