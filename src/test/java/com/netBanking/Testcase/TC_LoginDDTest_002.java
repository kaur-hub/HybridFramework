package com.netBanking.Testcase;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netBanking.PageObjects.LoginPage;
import com.netBanking.Utilties.XLUtils;

public class TC_LoginDDTest_002 extends BaseClass {
	@Test(dataProvider="LoginData")
	public void LoginDDT(String user,String pwd) throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered username");
		lp.setPassword(pwd);
		logger.info("Entered password");
		lp.clicksubmit();
		Thread.sleep(3000);
		
		if (isAlertPresent()==true){
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); 
			Assert.assertTrue(false);
			captureScreen(driver,"LoginDDTest");
			logger.warn("login failed");
			}
		else{
			Assert.assertTrue(true);
			lp.logout();
			Thread.sleep(3000);
			logger.info("login passed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
	}
		
		
		public boolean isAlertPresent(){
			try{;
				driver.switchTo().alert();
				return true;	
			}
			catch(NoAlertPresentException e) {
				
			return false;}	
		}
		
	

		@DataProvider(name="LoginData")
		String [][] getData() throws IOException
		{
			String path=System.getProperty("user.dir")+"/src/test/java/com/netBanking/Testdata/logindata.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String logindata[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
				}
					
			}
		return logindata;
		}

}
