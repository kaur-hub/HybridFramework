package com.netBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
  
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver  rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);}
	    
	    @FindBy  (xpath="/html/body/div[3]/div/ul/li[2]/a")
	     WebElement linkAddcustomername;
	    @FindBy  (name="name")
		WebElement customername;
		
		@FindBy  (name="rad1")
		WebElement rdgender;

		@FindBy(name="dob")
		WebElement txtdob;

		@FindBy(name="addr")
		WebElement txtaddress;

		@FindBy(name="city")
		WebElement txtcity;
		@FindBy(name="state")
		WebElement txtstate;
		@FindBy(name="pinno")
		WebElement txtpin;
		@FindBy(name="telephoneno")
		WebElement txttelephone;
		@FindBy(name="emailid")
		WebElement txtemail;
		@FindBy(name="password")
		WebElement txtpassword;
		
		@FindBy(name="sub")
		WebElement btnsubmit;
		
		public void Clickaddnewcustomer(){
			linkAddcustomername.click();
			
		}
		public void CustomerName(String cname){
			customername.sendKeys(cname);;
			
		}
		public void gender(String cgender){
			rdgender.click();;
			
		}
	     public void dateofbirth(String mm,String dd,String yy){
			txtdob.sendKeys(mm);
			txtdob.sendKeys(dd);
			txtdob.sendKeys(yy);
			
		}
		public void address(String caddress){
			txtaddress.sendKeys(caddress);
			
		}
		public void city(String cityname){
			txtcity.sendKeys(cityname);
			
		}
		public void state(String statename){
			txtstate.sendKeys(statename);
			
		}
		public void pin(String cpin){
			txtpin.sendKeys(cpin);
			
		}
		public void telephone(String ctelephone){
			txttelephone.sendKeys(ctelephone);
			
		}
		public void emailid(String cemail){
			txtemail.sendKeys(cemail);}
			
		public void password(String cpwd){
			txtpassword.sendKeys(cpwd);
			
		}
		public void submit(){
			btnsubmit.click();
			
		}
		
		
		
		
		
		
		
		
	}

