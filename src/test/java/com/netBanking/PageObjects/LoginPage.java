package com.netBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver  rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
@FindBy(name="uid")
WebElement txtusername;

@FindBy(name="password")
WebElement txtpassword;

@FindBy(name="btnLogin")
WebElement btnlogin;

@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
WebElement Logout;


public void setUserName(String uname){
	txtusername.sendKeys(uname);
}
public void setPassword(String pwd){
	txtpassword.sendKeys(pwd);
}
public void clicksubmit(){
	btnlogin.click();
}
public void logout(){
	 Logout.click();
}
}
