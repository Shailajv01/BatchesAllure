package com.batches.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.batches.pages.BatchesLoginPage;
import com.batches.pages.CreateBatchPage;
import com.batches.test.BaseTest.WEB_DRIVER;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CreateBatchTest extends BaseTest {

	private static final Logger logger = Logger.getLogger(BatchesLoginTest.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })

	public void initClass(String siteURL, String browser) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);

		this.goToSite(siteURL, driver);
		this.loginpage = new BatchesLoginPage(this.driver);
		this.createBatchPage = new CreateBatchPage(this.driver);
		super.login();
		logger.info("Ending of initClass method in LoginTest");

	}

	@Test(priority = 1, description = " Test Case #1 , Verify Navigate to create new batch page")
	@Description("Test Case #1, Verify Navigate to create new batch page")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #1,  Verify Navigate to create new batch page")
	public void testNavigateToNewBatchPage() throws InterruptedException {
		logger.info("Starting of testNavigateToNewBatchPage method");

		this.createBatchPage.clickOnCreateCatch();

		String lblNewBatch = this.createBatchPage.getTitleCreateNewBatch();
		Assert.assertEquals(lblNewBatch, expectedAssertionsProp.getProperty("text.label.title"));
		System.out.println(expectedAssertionsProp.getProperty("text.label.title"));

		String lblBatchName = this.createBatchPage.getLabelBatchName();
		Assert.assertEquals(lblBatchName, expectedAssertionsProp.getProperty("label.batch.name"));

		String lblBatchCode = this.createBatchPage.getLabelBatchCode();
		Assert.assertEquals(lblBatchCode, expectedAssertionsProp.getProperty("label.batch.code"));

		String lblBatchStartDate = this.createBatchPage.getLabelBatchStartDate();
		Assert.assertEquals(lblBatchStartDate, expectedAssertionsProp.getProperty("label.batch.date"));

		this.createBatchPage.clickOnCloseIcon();

		logger.info("Ending of testNavigateToNewBatchPage method");
	}

	@Test(priority = 2, description = " Test Case #2 , Verify Today's days asa default")
	@Description("Test Case #1, Verify Today's days asa default")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #2,  Verify Today's days asa default")
	public void testTodaysDate() throws Exception {
		logger.info("Starting of testNavigateToNewBatchPage method");

		this.createBatchPage.clickOnCreateCatch();
		// createBatchPage.getCurrentDate();
		this.createBatchPage.clickOnCloseIcon();

	}

	@Test(priority = 3, description = " Test Case #3 , Verify past date")
	@Description("Test Case #3, Verify past date")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #1,  Verify past date")
	public void testValidateBatchCode() throws Exception {
		logger.info("Starting of testValidateBatchCode method");

		this.createBatchPage.clickOnCreateCatch();
		this.createBatchPage.setBatchName(testDataprop.getProperty("text.batch.name"));
		this.createBatchPage.isEnabledBatchCode();
		this.createBatchPage.getPaidColor();
		this.createBatchPage.clickOnCloseIcon();

		logger.info("Ending of testValidateBatchCode method");

	}

	@Test(priority = 4, description = " Test Case #3 , Verify past date")
	@Description("Test Case #3, Verify past date")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #4,  Verify past date")
	public void testFutureDate() throws InterruptedException {
		logger.info("Starting of testFutureDate method");

		this.createBatchPage.clickOnCreateCatch();
		String currentDate = this.createBatchPage.getCurrentDate();
		String localCurrentDate = this.createBatchPage.getLocalDate();
		Assert.assertEquals(localCurrentDate, currentDate);
		this.createBatchPage.clickOnCalender();

		logger.info("Ending of testFutureDate method");
	}

}
