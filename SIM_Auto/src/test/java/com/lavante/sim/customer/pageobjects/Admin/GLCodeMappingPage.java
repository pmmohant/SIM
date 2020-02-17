package com.lavante.sim.customer.pageobjects.Admin;

import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

/**
 * @author Ramya
 *
 */
public class GLCodeMappingPage {
	
	public LavanteUtils lavanteUtils=new LavanteUtils();
	
	public GLCodeMappingPage(WebDriver driver){
		lavanteUtils.driver=driver;
	}
	
	@FindBy(name="searchFilter")
	private WebElement GLCodemappingSearch;
	public WebElement GLCodemappingSearch(){
		return GLCodemappingSearch;
	}
	
	
	@FindBy(css="table[class*='data_table'] tbody tr td:nth-child(2)")
	private WebElement GLCodeValueinTable;
	public WebElement GLCodeValueinTable(){
		return GLCodeValueinTable;
	}
	
	@FindBy(id="searchGLCode")
	private WebElement SearchButton;
	public WebElement SearchButton(){
		return SearchButton;
	}
	
	@FindBy(css="a[href*='addGLCodeMapping.lvp']")
	private WebElement addGlCodeMappingButton;
	public WebElement addGlCodeMappingButton(){
		return addGlCodeMappingButton;
	}
	
	@FindBy(css="iframe[src*='addGLCodeMapping']")
	private WebElement AddWindowFrame;
	public WebElement AddWindowFrame(){
		return AddWindowFrame;
	}
	
	@FindBy(css="#glCodes_chosen li a")
	private List<WebElement> GLCodeSearchfieldList;
	public  List<WebElement> GLCodeSearchfieldList(){
		return GLCodeSearchfieldList;
	}
	
	@FindBy(css="#glCodes_chosen input")
	private WebElement GLCodeSearchfield;
	public WebElement GLCodeSearchfield(){
		return GLCodeSearchfield;
	}
	
	@FindBy(css="div[id*='glCodes']>ul>li")
	private WebElement GLCodeValueDropdown;
	public WebElement GLCodeValueDropdown(){
		return GLCodeValueDropdown;
	}
	@FindBy(css="#customerOrganizations_chosen input")
	private WebElement DivisionSearchBox;
	public WebElement DivisionSearchBox(){
		return DivisionSearchBox;
	}
	
	@FindBy(css="#customerOrganizations_chosen ul li:nth-child(3)")
	private WebElement selectDivision;
	public WebElement selectDivision(){
		return selectDivision;
	}
	
//	@FindBy(id= "glCodes")
//	private WebElement glcodeDropdown;
//	public WebElement glcodeDropdown(){
//		return glcodeDropdown;
//	}
	
	@FindBy(css = "button[value='Save']")
	private WebElement AddNewGLCodeMappingSaveBtn;
	public WebElement AddNewGLCodeMappingSaveBtn(){
		return AddNewGLCodeMappingSaveBtn;
	}
	
	@FindBy(css = "button[class*='cancel']")
	private WebElement AddNewGLCodeMappingCancelBtn;
	public WebElement AddNewGLCodeMappingCancelBtn(){
		return AddNewGLCodeMappingCancelBtn;
	}
	
	@FindBy(id= "searchCGLCode")
	private WebElement searchbutton;
	public WebElement searchbutton(){
		return searchbutton;
	}
	
	@FindBy(css= "a[href*='deleteGLCodeMapping.lvp']")
	private WebElement DeleteGLCodeMapping;
	public WebElement DeleteGLCodeMapping(){
		return DeleteGLCodeMapping;
	}
	
	@FindBy(css="div[style*='block']  button[class*='button_primary']")
	private WebElement deleteConfirmButton;
	public WebElement deleteConfirmButton(){
		return deleteConfirmButton;
	}
	
	@FindBy(css="table[class*='data_table'] tr td")
	private WebElement noResultsText;
	public WebElement noResultsText(){
		return noResultsText;
	}
	
	@FindBy(css = "span[ng-bind*='error']")
	private WebElement Errormsg;
	public WebElement Errormsg(){
		return Errormsg;
	}
	
	@FindBy(css=".bannerMessage")
	private WebElement bannerMsg;
	public WebElement bannerMsg(){
		return bannerMsg;
	}
	
	@FindBy(css = "[id*='manage-buyer-claim'] table[class] tbody td:nth-child(1)")
	public List<WebElement> ListDivisionName;
	
	@FindBy(css = "[id*='manage-buyer-claim'] table[class] tbody td:nth-child(2)")
	public List<WebElement> ListGLCodeName;
	
	@FindBy(css = "a[href*='edit']")
	public List<WebElement> ListEditGLCodeMapping;
	
	@FindBy(css = "a[href*='delete']")
	public List<WebElement> ListDeleteGLCodeMapping;
	
	/**
	 * MethodName : addGLCodeMapping : will add new gl code mapping
	 * 
	 * @param testData
	 *            : LinkedHashMap<String, String> testData
	 *            
	 * @author Priyanka
	 */
	public LinkedHashMap<String, String> addGLCodeMapping(LinkedHashMap<String, String> testData){
		
		clickAddGLCodeMapping();
		LinkedHashMap<String, String> dataMap=fillGLCodeMapping(testData);
		formAction(testData);
		return dataMap;
	}
	
	private void clickAddGLCodeMapping(){
			lavanteUtils.click(addGlCodeMappingButton);
	}
	
	public LinkedHashMap<String, String> fillGLCodeMapping(LinkedHashMap<String, String> testData) {
		lavanteUtils.switchtoFrame(AddWindowFrame);

		if (testData.containsKey("Division")) {
			String org = testData.get("Division");
			lavanteUtils.click(DivisionSearchBox);
			String x=lavanteUtils.selectContainFrmDpdn(org);
			lavanteUtils.switchtoFrame(AddWindowFrame);
			testData.put("Division", x);
		}
				
		if(testData.containsKey("GLCode")){
			String gl = testData.get("GLCode");
			if(GLCodeSearchfieldList.size()>0){
				boolean flag=lavanteUtils.isElementDisplayed(GLCodeSearchfieldList.get(0));
				if(flag){
					for(int i=0;i<GLCodeSearchfieldList.size();i++){
						lavanteUtils.click(GLCodeSearchfieldList.get(0));
					}
				}
			}
			
			//As lot of GL Code are available , we are typing the value  	lavanteUtils.click(GLCodeSearchfield)
			lavanteUtils.typeinEdit(gl,GLCodeSearchfield);
			String x=lavanteUtils.selectvalueFrmDpdn(gl);
			testData.put("GLCode", x);
			lavanteUtils.switchtoFrame(AddWindowFrame);
		}
		
		return testData;
	}


	public void formAction(LinkedHashMap<String, String> testData) {
		lavanteUtils.switchtoFrame(AddWindowFrame);
		if (testData.containsKey("Save")) {
			lavanteUtils.click(AddNewGLCodeMappingSaveBtn);
			lavanteUtils.switchtoFrame(null);
			lavanteUtils.waitForTime(3000);
		}
		if(testData.containsKey("Cancel")) {
			lavanteUtils.click(AddNewGLCodeMappingCancelBtn);
			lavanteUtils.switchtoFrame(null);
		}
	}
	
	
	 public void searchGLCode(LinkedHashMap<String, String> dataMap){
		    if(dataMap.containsKey("SearchValue")){
		    	String data=dataMap.get("SearchValue");
		    	lavanteUtils.fluentwait(GLCodemappingSearch);
		    		if(data.length()>0){
		    			GLCodemappingSearch.clear();
		    			lavanteUtils.typeString(data, GLCodemappingSearch);
		    		}
			}
			lavanteUtils.click(searchbutton);
			lavanteUtils.fluentwait(searchbutton);
			
		}
	/**
	 * Sanity Test
	 * 
	 * @author Thejaswi.Bhat
	 */
	public boolean verifyGLCodeMappingPage() {
		boolean flag=false;
		lavanteUtils.switchtoFrame(null);
		flag=lavanteUtils.verifyElementDisplayed("GLCodeMapping  Button", addGlCodeMappingButton);
		
		return flag;
	}
		
	
	
}
	
	
	
	
	
	
	
	
	
	


