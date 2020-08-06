package com.netBanking.Utilties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Readconfig {
 Properties prop;
 
 public Readconfig(){
	 File src= new File("./configuration/config.properties");
	 try {
		 FileInputStream fis = new  FileInputStream (src);
		 prop= new Properties();
		 prop.load(fis);
	 }catch(Exception e){
		 System.out.println("Exception is "+e.getMessage());
	 }
 
 
 }
 public String getChromePath(){
	 String path=prop.getProperty("chromepath");
	return path;
	 
 }
public String getApplicationURL() {
	String url=prop.getProperty("baseurl");
	return url;
	
}
public String getUserName() {
	String Username=prop.getProperty("username");
	return Username;
}

public String getPassword() {
		 String Password=prop.getProperty("password");
		return Password;
}

}






