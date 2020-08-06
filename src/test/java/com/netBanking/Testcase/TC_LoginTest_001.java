package com.netBanking.Testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking.PageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
@Test
public void loginTest() throws IOException{
	driver.get(baseurl);
	logger.info("url is opened");
	
	LoginPage lp=new LoginPage(driver);
	  lp.setUserName(username);
	  logger.info("Entered username");
	  lp.setPassword(password);
	  logger.info("Entered password");
	  lp.clicksubmit();
	  logger.info("Click on submit button");
	  
	 if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
		 Assert.assertTrue(true);
		 logger.info("login test passed");
	 }
	 else {
		 captureScreen(driver,"LoginTest");
		Assert.assertTrue(false); 
		logger.info("login test failed");
	 }
	
	
	
	
	
}
}
