package TelstraTesting;

import java.lang.reflect.Method;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pages.*;
import utilities.*;
import utilities.library.availableContexts;
import utilities.library.byFields;
import utilities.library.prop;

public class iTelstra2TestSystem extends ClassHelper {
	private androidHelper android;


	public void setPagesAndHelpers(library lib) throws IOException {
		
		lib.loadPropertyFile("TelstraElements.properties"); //Update based on your properties file
	}

	
	@Test
	public void Login() throws Exception {
		try {
			
			setPagesAndHelpers(lib);
			Map<String, Object> params1 = new HashMap<>();
        	Object result1 = lib.getDriver().executeScript("mobile:handset:ready", params1);

        	
        	// launch appstore 
        	Map<String, Object> params10 = new HashMap<>();
        	params10.put("name", "Telstra 24x7");
        	params10.put("identifier", "com.telstra.telstra24x7iphone");
        	Object result10 = lib.getDriver().executeScript("mobile:application:open", params10);
        	
        	getCollector().setSla(60000);
        	lib.StartTransaction("trans_1", "Telstra24x7 Launch");
        	Map<String, Object> appLaunch = new HashMap<>();
        	appLaunch.put("content", "Register");
        	appLaunch.put("timeout", "180");
        	appLaunch.put("threshold", "90");
        	appLaunch.put("measurement", "accurate");
        	appLaunch.put("source", "camera");
        	Object resultAppLaunch = lib.getDriver().executeScript("mobile:checkpoint:text", appLaunch);
        	lib.EndTransaction("trans_1", "Telstra24x7 Launch");
        	//lib.addStep("trans_1", "Telstra24x7 Launch", lib.getUXTimer());
        	
        	lib.switchToContext(availableContexts.NATIVE_APP);   // Switch to NATIVE

        	// verify menu
        	lib.clickElement(byFields.xpath, lib.getProp(prop.mainMenu), 10);
        	lib.clickElement(byFields.xpath, lib.getProp(prop.myUsage), 10);
        	
        	getCollector().setSla(60000);
        	lib.StartTransaction("trans_2", "My Usage");
        	Map<String, Object> myUsage = new HashMap<>();
        	myUsage.put("content", "Register");
        	myUsage.put("timeout", "180");
        	myUsage.put("threshold", "90");
        	myUsage.put("measurement", "accurate");
        	myUsage.put("source", "camera");
        	Object resultMyUsage = lib.getDriver().executeScript("mobile:checkpoint:text", myUsage);
        	lib.EndTransaction("trans_2", "My Usage");
        	
        	//lib.addStep("trans_2", "My Usage", lib.getUXTimer());
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.mainMenu), 10);
        	lib.clickElement(byFields.xpath, lib.getProp(prop.myBill), 10);
        	
        	getCollector().setSla(60000);
        	lib.StartTransaction("trans_3", "My Bill");
        	Map<String, Object> myBill = new HashMap<>();
        	myBill.put("content", "Register");
        	myBill.put("timeout", "180");
        	myBill.put("threshold", "90");
        	myBill.put("measurement", "accurate");
        	myBill.put("source", "camera");
        	Object resultMyBill = lib.getDriver().executeScript("mobile:checkpoint:text", myBill);
        	lib.EndTransaction("trans_3", "My Bill");
        	
        	//lib.addStep("trans_3", "My Bill", lib.getUXTimer());
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.mainMenu), 10);

        	// close app
        	Map<String, Object> params12 = new HashMap<>();
        	params12.put("name", "Telstra 24x7");
        	params12.put("identifier", "com.telstra.telstra24x7iphone");
        	Object result12 = lib.getDriver().executeScript("mobile:application:close", params12);
	
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			

		}
	}

}
