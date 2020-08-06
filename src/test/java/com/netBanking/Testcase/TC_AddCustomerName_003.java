package com.netBanking.Testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.PageObjects.AddCustomerPage;
import com.netBanking.PageObjects.LoginPage;

public class TC_AddCustomerName_003 extends BaseClass {
	@Test
	public void addcustomername() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clicksubmit();
		logger.info("Click on submit button");

		AddCustomerPage addcp = new AddCustomerPage(driver);
		addcp.Clickaddnewcustomer();
		logger.info("Providing Customers details-------");
		addcp.CustomerName("SukhwinderKaur");
		addcp.gender("female");
		addcp.dateofbirth("03", "26", "1980");
		Thread.sleep(3000);
		addcp.address("ssaadd");
		addcp.city("rrruuuo");
		addcp.state("saas");
		addcp.pin("950358");
		addcp.telephone("408567893");
		String cusemail = randomString() + "@gmail.com";
		addcp.emailid(cusemail);
		addcp.password("abcdef");
		addcp.submit();
		Thread.sleep(3000);
		logger.info("Validating the page-----------");

		boolean res =driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");

		} else {
			logger.info("test case failed....");
			captureScreen(driver, "addcustomername");
			Assert.assertTrue(false);
		}

	}

}
