package com.batches.test;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.batches.pages.BatchesLoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class BatchesLoginTest extends BaseTest {

	private static final Logger logger = Logger.getLogger(BatchesLoginTest.class.getName());

	@BeforeClass
	@Parameters({ "siteURL", "browser" })

	public void initClass(String siteURL, String browser) throws Exception {
		logger.info("Starting of initClass method in LoginTest");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);

		this.goToSite(siteURL, driver);
		this.loginpage = new BatchesLoginPage(this.driver);

		logger.info("Ending of initClass method in LoginTest");

	}

	@Test(priority = 1, description = " Test Case #1 , Verify UI elements")
	@Description("Test Case #1, Verify UI elements")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #1,  Verify UI elements")
	public void testUIElements() throws InterruptedException {
		logger.info("Starting of testUIElements method");

		String txtLoginToAccount = this.loginpage.getLoginToAccount();
		Assert.assertEquals(txtLoginToAccount, expectedAssertionsProp.getProperty("text.login.to.account"));
		System.out.println(expectedAssertionsProp.getProperty("text.login.to.account"));

		String txtPleaseEnterMobleAndOrg = this.loginpage.getPleaseEnterMobileAndOrgCode();
		Assert.assertEquals(txtPleaseEnterMobleAndOrg,
				expectedAssertionsProp.getProperty("text.enter.mobilenumber.orgcode"));

		String txtOrgCode = this.loginpage.getTextOrgCode();
		Assert.assertEquals(txtOrgCode, expectedAssertionsProp.getProperty("text.org.code"));

		String txtYourMobileNumber = this.loginpage.getTextYourMobileNumber();
		Assert.assertEquals(txtYourMobileNumber, expectedAssertionsProp.getProperty("text.enter.mobilenumber"));

		this.loginpage.isDisplayedProceedSecurelyButton();

		/*
		 * String lnkUseEmail = this.loginpage.getLinkTextUseEmail();
		 * Assert.assertEquals(lnkUseEmail,
		 * expectedAssertionsProp.getProperty("text.link.useemail"));
		 */
		String lnkTermsAndConditions = this.loginpage.getLinkTermsAndConditions();
		Assert.assertEquals(lnkTermsAndConditions.trim(),
				expectedAssertionsProp.getProperty("text.terms.conditions").trim());

		logger.info("Ending of testUIElements method");
	}

	@Test(priority = 2, description = " Test Case #2 ,verify org code")
	@Description("Test Case #2, verify org code")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #2,  verify org code")
	public void testVerifyOrgCode() throws Exception {
		logger.info("Starting of testVerifyOrgCode method");

		this.loginpage.setOrgCode(testDataprop.getProperty("text.org.code"));
		this.loginpage.clickOnMobileNumberField();
		// this.loginpage.getPaidColor(expectedAssertionsProp.getProperty("color.green"));

		String lblGreenColor = this.loginpage.getPaidColor();
		Assert.assertEquals(lblGreenColor, expectedAssertionsProp.getProperty("color.green"));
		logger.info("Ending of testVerifyOrgCode method");
	}

	@Test(priority = 3, description = " Test Case #3 , Verify MobileNumber")
	@Description("Test Case #3, Verify MobileNumber")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3,  Verify MobileNumber")
	public void testerifyMobileNumber() throws InterruptedException {
		logger.info("Starting of Verify MobileNumber");

		loginpage.setMobileNumber(testDataprop.getProperty("text.mobile.number"));
		loginpage.clickOnProceedButton();
		loginpage.setOtp(testDataprop.getProperty("text.otp"));
		loginpage.clickOnVerifyOtpButton();

	}

	@Parameters({ "siteURL" })
	@Test(priority = 4, description = " Test Case #3 , Verify Terms And Conditions")
	@Description("Test Case #4, Verify Terms And Conditions")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3,  Verify Terms And Conditions")
	public void testVerifyTermsAndConditions(String siteURL) throws InterruptedException {
		logger.info("Starting of testVerifyTermsAndConditions method");

		Thread.sleep(2000);
		driver.get(siteURL);
		Thread.sleep(2000);
		loginpage.clickOnTermsAndConditions();

		logger.info("Ending of testVerifyTermsAndConditions method");
	}

	@Parameters({ "siteURL" })
	@Test(priority = 5, description = " Test Case #5 , Verify mobile number lessthan ten digits")
	@Description("Test Case #5, Verify mobile number lessThan ten digits")
	@Severity(SeverityLevel.BLOCKER)
	@Story("Test Case #3,  Verify mobile number lessthan ten digits")
	public void testMobileNumberLessThanTenDigits(String siteURL) throws InterruptedException {
		logger.info("Starting of testMobileNumberLessThanTenDigits method");

		driver.get(siteURL);
		Thread.sleep(3000);
		loginpage.clickOnMobileNumberField();
		loginpage.setMobileNumber(testDataprop.getProperty("mobile.number.fivedigits"));

		logger.info("Ending of testMobileNumberLessThanTenDigits method");
	}

	@AfterClass
	public void quiteDriver() throws InterruptedException {
		logger.info("Starting of quiteDriver method");

		Thread.sleep(3000);
		driver.quit();

		logger.info("Ending of quiteDriver method");

	}

}
