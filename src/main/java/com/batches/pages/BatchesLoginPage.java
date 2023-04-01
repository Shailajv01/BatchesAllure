package com.batches.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BatchesLoginPage extends BasePage {
	
	private static final Logger logger = Logger.getLogger(BatchesLoginPage.class.getName());

	@FindBy(xpath = "//p[text()='Login to your account']")
	private WebElement lblLoginToAccount;

	@FindBy(xpath = "//p[text()='Please enter the org code and your mobile number to continue']")
	private WebElement lblPleaseEnterMobleAndOrg;

	@FindBy(xpath = "//label[text()='Org Code']")
	private WebElement lblOrgCode;

	@FindBy(xpath = "//input[@placeholder='Enter org code']")
	private WebElement txtOrgCode;

	@FindBy(xpath = "//img[@class='accountLogin-org-status-icon']")
	private WebElement lblGreenColor;

	@FindBy(xpath = "//label[text()='Your Mobile Number']")
	private WebElement lblYourMobileNumber;

	@FindBy(xpath = "//p[text()='Sort']")
	private WebElement btnSort;

	@FindBy(xpath = "//div[@class='menu transition visible']")
	private List<WebElement> ddList;

	/*
	 * @FindBy(xpath = "//button[@class='ui primary disabled button']") private
	 * WebElement btnProceedSecurely;
	 */

	@FindBy(xpath = "//input[@placeholder='Enter your mobile number']")
	private WebElement txtYourMobileNumber;

	@FindBy(xpath = "//button[@class='ui primary button']")
	private WebElement btnProceedSecurely;

	@FindBy(xpath = "//p[text()=' Use your email instead']")
	private WebElement lnkUseEmail;

	@FindBy(xpath = "//a[text()='terms and conditions']")
	private WebElement lnkTermsAndConditions;

	@FindBy(xpath = "//input[@id='otp_input']")
	private WebElement txtOtp;

	@FindBy(xpath = "//button[@role='button']")
	private WebElement btnVerifyOtp;

	public BatchesLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getLoginToAccount() {
		logger.info("Starting of getLoginToAccount method");
		logger.info("Ending of getLoginToAccount method");
		return lblLoginToAccount.getText();

	}

	public String getPleaseEnterMobileAndOrgCode() {
		logger.info("Starting of getPleaseEnterMobileAndOrgCode method");
		logger.info("Ending of getPleaseEnterMobileAndOrgCode method");
		return lblPleaseEnterMobleAndOrg.getText();

	}

	public String getTextOrgCode() {
		logger.info("Starting of gettxtOrgCode method");
		logger.info("Ending of gettxtOrgCode method");
		return lblOrgCode.getText();

	}

	public String getTextYourMobileNumber() {
		logger.info("Starting of getYourMobileNumber method");
		logger.info("Ending of getYourMobileNumber method");
		return lblYourMobileNumber.getText();

	}

	public boolean isDisplayedProceedSecurelyButton() {
		logger.info("Starting of getProceedSecurelyButton method");
		logger.info("Ending of getProceedSecurelyButton method");

		try {

			return btnProceedSecurely.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}

	public String getLinkTextUseEmail() throws InterruptedException {
		logger.info("Starting of getLinkTextUseEmail method");
		logger.info("Ending of getLinkTextUseEmail method");
		Thread.sleep(2000);
		return lnkUseEmail.getText();

	}

	public String getLinkTermsAndConditions() {
		logger.info("Starting of getLinkTermsAndConditions method");
		logger.info("Ending of getLinkTermsAndConditions method");
		return lnkTermsAndConditions.getText();

	}

	public void clickOnTermsAndConditions() throws InterruptedException {
		logger.info("Starting of getLinkTermsAndConditions method");

		Thread.sleep(2000);
		this.lnkTermsAndConditions.click();
		logger.info("Ending of getLinkTermsAndConditions method");

	}

	public void setOrgCode(String strName) throws Exception {
		logger.info("Starting of setOrgCode method");
		// this.clickOnWebElement(txtBoxUsername);
		txtOrgCode.click();
		Thread.sleep(1000);
		this.txtOrgCode.sendKeys(strName);

		logger.info("Ending of setOrgCode method");
	}

	public String getPaidColor() throws Exception {
		logger.info("Starting of getPaidColor method");
		Thread.sleep(3000);
		String colorString = lblGreenColor.getCssValue("background-color");
		String hex = Color.fromString(colorString).asHex();
		System.out.println("**********************************colorString************" + hex);

		logger.info("Ending of getPaidColor method");

		return hex;
	}

	public void clickOnMobileNumberField() throws InterruptedException {
		logger.info("Starting of clickOnMobileNumberField method");
		
        Thread.sleep(2000);
		this.clickOnWebElement(lblYourMobileNumber);
		logger.info("Ending of clickOnMobileNumberField method");

	}

	public void setMobileNumber(String strPassword) {
		logger.info("Starting of setMobileNumber method");

		this.clickOnWebElement(txtYourMobileNumber);
		this.txtYourMobileNumber.sendKeys(strPassword);
		logger.info("Ending of setMobileNumber method");
	}

	public void clickOnProceedButton() throws InterruptedException {
		logger.info("Starting of clickOnPfroceedButton method");

		Thread.sleep(2000);
		this.clickOnWebElement(btnProceedSecurely);
		logger.info("Ending of clickOnPfroceedButton method");

	}

	public void setOtp(String strOTP) throws InterruptedException {
		logger.info("Starting of setMobileNumber method");

		//this.clickOnWebElement(txtOtp);
		this.txtOtp.sendKeys(strOTP);
		Thread.sleep(2000);
		logger.info("Ending of setMobileNumber method");
	}

	public void clickOnVerifyOtpButton() {
		logger.info("Starting of clickOnPfroceedButton method");

		this.clickOnWebElement(btnVerifyOtp);
		logger.info("Ending of clickOnPfroceedButton method");

	}

	public List<String> getList() {
		logger.info("Starting of getList method");
		logger.info("Ending of getList method");
		List<String> ss = new ArrayList<String>();
		for (WebElement element : ddList) {
			// String s = element.getText();
			// System.out.println(s);
			ss.add(element.getText());
		}
		return ss;
	}

	public void clickOnRecentlyAdded(String sort) {
		logger.info("Starting of getList method");
		logger.info("Ending of getList method");

		for (WebElement element : ddList) {
			if (element.getText().equals(sort)) {
				element.click();
			}
		}
	}
	

}