package com.lavante.configurator.pageobjects.buyers.User;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.lavante.configurator.Common.Util.LavanteUtils;

public class UsersPage {
	
	LavanteUtils lavanteUtils = new LavanteUtils();

	public UsersPage(WebDriver driver) {
		lavanteUtils.driver = driver;
	}
	
	//Add user locators 
	
	@FindBy(id="btn-add")
	private WebElement click_addusrbtn; //click on add user btn
	public WebElement click_addusrbtn(){
		return click_addusrbtn;
	}
	
	@FindBy(id="contactName")
	private WebElement add_user; //add user name 
	public WebElement add_user(){
		return add_user;
	}
	@FindBy(id="jobTitle")
	private WebElement add_jobTitle; //add job title 
	public WebElement add_jobTitle(){
		return add_jobTitle;
	}
	@FindBy(css = "[ng-click='$select.activate()']")
	private WebElement add_department; //add department  
	public WebElement add_department(){
		return add_department;
	}
	@FindBy(id = "primaryPhone")
	private WebElement add_primaryPhone; //add phone number
	public WebElement add_primaryPhone(){
		return add_primaryPhone;
	}
	@FindBy(id = "primaryFax")
	private WebElement add_primaryFax; //add fax number
	public WebElement add_primaryFax(){
		return add_primaryFax;
	}
	@FindBy(id = "email")
	private WebElement add_email; //add email
	public WebElement add_email(){
		return add_email;
	}
	@FindBy(css= "[ng-model='accountCreated']")
	private WebElement add_createUserAccountCheckbox; //click createUserAccountCheckbox
	public WebElement add_createUserAccountCheckbox(){
		return add_createUserAccountCheckbox;
	}
	@FindBy(css= "div[placeholder='Select Role'] span[class*='select-placeholder']")
	private WebElement add_userRole; //click user role
	public WebElement add_userRole(){
		return add_userRole;
	}
	@FindBy(css= "[ng-model='$root.selectedgroupmodel']")
	private WebElement add_userGroup; //add user group 
	public WebElement add_userGroup(){
		return add_userGroup;
	}
	
	@FindBy(name = "submitBtn")
	private WebElement add_submitBtn; //submitBtn 
	public WebElement add_submitBtn(){
		return add_submitBtn;
	}
	
	@FindBy(xpath="//button[contains(.,'Edit')]")
	private WebElement add_editUser; //Edit user
	public WebElement add_editUser(){
		return add_editUser;
	}
	
	@FindBy(css="[ng-click='submit()']")
	private WebElement add_saveEditUser; //save edit User
	public WebElement add_saveEditUser(){
		return add_saveEditUser;
	}
	
	@FindBy(css="[name='filter-contactName']")//search user name
	private WebElement user_username;
	public WebElement user_username(){
		return user_username;
	}
	
	
			
	@FindBy(css="input[placeholder='Select department']")
	private WebElement selDeptTxtBox;
	public WebElement selDeptTxtBox(){
		return selDeptTxtBox;
	}
	
	@FindBy(css="input[placeholder='Select Role']")
	private WebElement selRoleTxtBox;
	public WebElement selRoleTxtBox(){
		return selRoleTxtBox;
	}
	
	@FindBy(css = "[ng-click*='deleteRoles']") //delete user
	private WebElement role_DeleteRoles;
	public WebElement role_DeleteRoles(){
		return role_DeleteRoles;
	}
	
	public void addUser(LinkedHashMap<String, String> dataMap){
		clickAddUser();
		fillAdddUser(dataMap);
		formAction(dataMap);
		
	}
	public void clickAddUser(){
		lavanteUtils.refreshPage();
		lavanteUtils.fluentwait(click_addusrbtn);
		lavanteUtils.click(click_addusrbtn);
		lavanteUtils.fluentwait(click_addusrbtn);
	}
	
	private void fillAdddUser(LinkedHashMap<String, String> dataMap) {
		if(dataMap.containsKey("UserName")){
			lavanteUtils.typeinEdit(dataMap.get("UserName"), add_user);
			
		}
		if(dataMap.containsKey("JobTitle")){
			lavanteUtils.typeinEdit(dataMap.get("JobTitle"), add_jobTitle);
		}
		if(dataMap.containsKey("Department")){
			
			lavanteUtils.click(add_department);
			lavanteUtils.waitForTime(1000);
			lavanteUtils.typeinEdit(dataMap.get("Department"), selDeptTxtBox);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectvalueFromDropdown(dataMap.get("Department"));
			lavanteUtils.waitForTime(1000);
		}
		if(dataMap.containsKey("Phone")){
			lavanteUtils.typeinEdit(dataMap.get("Phone"), add_primaryPhone);
		}
		
		if(dataMap.containsKey("Fax")){
			lavanteUtils.typeinEdit(dataMap.get("Fax"),add_primaryFax);
		}
		if(dataMap.containsKey("Email")){
			lavanteUtils.typeinEdit(dataMap.get("Email"),add_email);
		}
		
		if(dataMap.containsKey("CreateUserAccount")){
			
			lavanteUtils.click(add_createUserAccountCheckbox);
			lavanteUtils.waitForTime(3000);
		}
		
		if(dataMap.containsKey("UserRole")){
			
			lavanteUtils.click(add_userRole);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.typeinEdit(dataMap.get("UserRole"), selRoleTxtBox);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.selectvalueFromDropdown(dataMap.get("UserRole"));
			lavanteUtils.waitForTime(1000);
			
			//lavanteUtils.click(userRole);
			//lavanteUtils.waitForTime(3000);
		}
		
		if(dataMap.containsKey("UserGroup")){
			lavanteUtils.typeinEdit(dataMap.get("UserGroup"),add_userGroup);
		}
		
		
	}
	public void formAction(LinkedHashMap<String, String> dataMap) {
		
		
		if(dataMap.containsKey("Add")){
			lavanteUtils.click(add_submitBtn);
			lavanteUtils.waitForTime(3000);
			
		}
		
		if(dataMap.containsKey("FilterContactName")){
			
			
			lavanteUtils.click(user_username);
			lavanteUtils.waitForTime(3000);
			lavanteUtils.typeinEdit(dataMap.get("FilterContactName"),user_username);
		}
		
		if(dataMap.containsKey("Edit")){
			lavanteUtils.click(add_editUser);
		}
		
		
	}

	public void deleteUser() {
		
		lavanteUtils.waitForTime(3000);
		lavanteUtils.click(role_DeleteRoles);
		lavanteUtils.waitForTime(1000);
		
		
	}
	
	
	//Re Usable Method
	
	
	

}
