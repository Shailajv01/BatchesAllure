package com.batches.pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateBatchPage extends BasePage {

	private static final Logger logger = Logger.getLogger(BatchesLoginPage.class.getName());

	@FindBy(xpath = "//div[@class='btn btn-primary']")
	private WebElement btnCreateBatch;

	@FindBy(xpath = "//div[text()='Create New Batch']")
	private WebElement lblNewBatch;

	@FindBy(xpath = "//label[text()='Batch Name']")
	private WebElement lblBatchName;

	@FindBy(xpath = "//label[text()='Batch Code']")
	private WebElement lblBatchCode;

	@FindBy(xpath = "//label[text()='Batch Start Date']")
	private WebElement lblBatchStartDate;

	@FindBy(xpath = "//input[@name='batchName']")
	private WebElement txtBatchName;

	@FindBy(xpath = "//input[@name='batchCode']")
	private WebElement txtBatchCode;

	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement txtBatchStartDate;
	
	@FindBy(xpath = "//img[@alt='error']")
	private WebElement imgColor;

	@FindBy(xpath = "//img[@alt='close']")
	private WebElement iconClose;

	@FindBy(xpath = "//td[@class='rdtDay rdtToday']")
	private WebElement dtCurrentDate;
	
	
	
	public CreateBatchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateCatch() {
		logger.info("Starting of clickOnCreateCatch method");

		this.btnCreateBatch.click();

		logger.info("Ending of clickOnCreateCatch method");

	}

	public String getTitleCreateNewBatch() {
		logger.info("Starting of getTitleCreateNewBatch method");
		logger.info("Ending of getTitleCreateNewBatch method");

		return lblNewBatch.getText();

	}

	public String getLabelBatchName() {
		logger.info("Starting of getLabelBatchName method");
		logger.info("Ending of getLabelBatchName method");

		return lblBatchName.getText();

	}

	public String getLabelBatchCode() {
		logger.info("Starting of getLabelBatchCode method");
		logger.info("Ending of getLabelBatchCode method");

		return lblBatchCode.getText();

	}

	public String getLabelBatchStartDate() {
		logger.info("Starting of getLabelBatchStartDate method");
		logger.info("Ending of getLabelBatchStartDate method");

		return lblBatchStartDate.getText();

	}

	public void setBatchName(String strBatchName) {
		logger.info("Starting of setBatchName method");

		this.txtBatchName.sendKeys(strBatchName);

		logger.info("Starting of setBatchName method");
	}

	public boolean isEnabledBatchCode() {
		logger.info("Starting of isEnabledBatchCode method");
		logger.info("Ending of isEnabledBatchCode method");

		try {

			return imgColor.isEnabled();

		} catch (Exception e) {
			return true;
		}
	
		
	}
	public String getPaidColor() throws Exception {
		logger.info("Starting of getPaidColor method");
		Thread.sleep(3000);
		String colorString = imgColor.getCssValue("background-color");
		String hex = Color.fromString(colorString).asHex();
		System.out.println("**********************************colorString************" + hex);

		logger.info("Ending of getPaidColor method");

		return hex;
	}
	
	public void clickOnCloseIcon() throws InterruptedException {
		logger.info("Starting of clickOnCreateCatch method");

        Thread.sleep(2000);
		this.iconClose.click();

		logger.info("Ending of clickOnCreateCatch method");

	}

	
	public void clickOnCalender() throws InterruptedException {
		logger.info("Starting of clickOnCalender method");

        Thread.sleep(2000);
		this.txtBatchStartDate.click();

		logger.info("Ending of clickOnCalender method");

	}
	
	public String getCurrentDate() {
		logger.info("Starting of getCurrentDate method");
	       System.out.println(txtBatchStartDate.getAttribute("value"));

		return txtBatchStartDate.getAttribute("value");
	
	}
	
	public String getLocalDate() {

		/*
		 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");
		 * LocalDateTime now = LocalDateTime.now(); String date = dtf.format(now);
		 * System.out.println(date);
		 */
		 LocalDate currentDate = LocalDate.now();
	        int year = currentDate.getYear();
	        int month = currentDate.getMonthValue();
	        int day = currentDate.getDayOfMonth();


System.out.println(year+"/"+month+"/"+day);
		return year+"/0"+month+"/0"+day;
	
	}
	
	public void clickOnCurrentDate() throws InterruptedException {
		logger.info("Starting of clickOnCurrentDate method");

        Thread.sleep(2000);
		this.dtCurrentDate.click();

		logger.info("Ending of clickOnCurrentDate method");

	}
	
	public void SetDateCalenderField() throws InterruptedException {
		logger.info("Starting of clickOnCalenderField method");

		Thread.sleep(2000);
		this.clickOnWebElement(lblBatchStartDate);
		Thread.sleep(2000);
		this.txtBatchStartDate.getAttribute("value");

		logger.info("Ending of clickOnCalenderField method");

	}
}
