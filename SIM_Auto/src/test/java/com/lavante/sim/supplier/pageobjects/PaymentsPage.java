package com.lavante.sim.supplier.pageobjects;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lavante.sim.Common.Util.LavanteUtils;

public class PaymentsPage {

	public WebDriver driver;
	public LavanteUtils lavanteUtils = new LavanteUtils();

	public PaymentsPage(WebDriver driver) {
		lavanteUtils.driver = driver;
		this.driver = driver;
	}

	@FindBy(id = "payNow")
	private WebElement PayNowBtn;

	public WebElement PayNowBtn() {
		return PayNowBtn;
	}

	@FindBy(id = "register")
	private WebElement RegisterBtn;

	public WebElement RegisterBtn() {
		return RegisterBtn;
	}

	@FindBy(id = "payLater")
	private WebElement PayLaterBtn;

	public WebElement PayLaterBtn() {
		return PayLaterBtn;
	}

	@FindBy(id = "exact_cardholder_name")
	private WebElement CardHolderNameTxtBox;

	public WebElement CardHolderNameTxtBox() {
		return CardHolderNameTxtBox;
	}

	@FindBy(id = "x_card_num")
	private WebElement CreditCardNumTxtBox;

	public WebElement CreditCardNumTxtBox() {
		return CreditCardNumTxtBox;
	}

	@FindBy(id = "x_exp_date")
	private WebElement ExpiryDateTxtBox;

	public WebElement ExpiryDateTxtBox() {
		return ExpiryDateTxtBox;
	}

	@FindBy(name = "commit")
	private WebElement SubmitBtn;

	public WebElement SubmitBtn() {
		return SubmitBtn;
	}

	@FindBy(css = "table[class*='activities-table'] td[class*='total']")
	private WebElement TotalAmount;

	public WebElement TotalAmount() {
		return TotalAmount;
	}

	/**
	 * Register new card for campaign payment
	 * 
	 * @author Subhas.BV
	 * @param LinkedHashMap<String,
	 *            String> dataMap
	 */
	public void registerNewCard(LinkedHashMap<String, String> dataMap) {
		if (dataMap.containsKey("CardHolderName")) {
			lavanteUtils.typeinEdit(dataMap.get("CardHolderName"), CardHolderNameTxtBox);
		}
		if (dataMap.containsKey("CreditCardNumber")) {
			lavanteUtils.typeinEdit(dataMap.get("CreditCardNumber"), CreditCardNumTxtBox);
		}
		if (dataMap.containsKey("ExpiryDate")) {
			lavanteUtils.typeinEdit(dataMap.get("ExpiryDate"), ExpiryDateTxtBox);
		}
		lavanteUtils.clicks(SubmitBtn);
	}

}
