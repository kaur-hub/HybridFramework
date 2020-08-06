package com.netBanking.Testcase;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netBanking.Utilties.Readconfig;

public class BaseClass {
	Readconfig readconfig=new Readconfig();
public String baseurl=readconfig.getApplicationURL();
public String username=readconfig.getUserName();
public String password=readconfig.getPassword();
public static  WebDriver driver;
public static Logger logger;

@Parameters("browser")
@BeforeClass
public void setup(String br) {
	
	System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
     driver=new ChromeDriver();
     logger=(Logger) LogManager.getLogger(BaseClass.class);
 	PropertyConfigurator.configure("Log4j.properties");
	

	if(br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
	}
	/*else if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		driver = new FirefoxDriver();
	}
	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		driver = new InternetExplorerDriver();
	}*/
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(baseurl);
}

@AfterClass
public void tearDown()
{
	driver.quit();
}

public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}
public String randomString(){
String generatedsring=RandomStringUtils.randomAlphabetic(8);
return(generatedsring);
}
public String randomNum(){
	String generatedsring1=RandomStringUtils.randomNumeric(4);
	return(generatedsring1);
	}

}
