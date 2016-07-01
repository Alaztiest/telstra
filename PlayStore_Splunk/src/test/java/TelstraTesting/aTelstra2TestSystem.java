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

public class aTelstra2TestSystem extends ClassHelper {
	private androidHelper android;


	public void setPagesAndHelpers(library lib) throws IOException {
		
		lib.loadPropertyFile("Telstra2Elements.properties"); //Update based on your properties file
	}

	
	@Test
	public void Login() throws Exception {
		try {
			setPagesAndHelpers(lib);
			Map<String, Object> params1 = new HashMap<>();
        	Object result1 = lib.getDriver().executeScript("mobile:handset:ready", params1);
        	lib.switchToContext(availableContexts.NATIVE_APP); 
        	
        	//launch Telstra 24x7
        	lib.clickElement(byFields.xpath, lib.getProp(prop.aAppListPick), 10);
        	getCollector().setSla(60000);
        	Map<String, Object> appLaunch = new HashMap<>();
        	appLaunch.put("content", "Register");
        	appLaunch.put("timeout", "180");
        	appLaunch.put("measurement", "accurate");
        	Object resultAppLaunch = lib.getDriver().executeScript("mobile:checkpoint:text", appLaunch);
        	lib.addStep("trans_1", "App Launch", lib.getUXTimer());
        	
        	//lib.sleep(50000);
  
        	// verify My usage
        	lib.clickElement(byFields.xpath, lib.getProp(prop.aMainMenu), 10);
        	lib.clickElement(byFields.xpath, lib.getProp(prop.aMyUsage), 10);
        	getCollector().setSla(60000);
        	Map<String, Object> myUsage = new HashMap<>();
        	myUsage.put("content", "Register");
        	myUsage.put("timeout", "180");
        	myUsage.put("measurement", "accurate");
        	Object resultMyUsage = lib.getDriver().executeScript("mobile:checkpoint:text", myUsage);
        	lib.addStep("trans_2", "My Usage", lib.getUXTimer());
        	
        	// verify My Bill
        	lib.clickElement(byFields.xpath, lib.getProp(prop.aMainMenu), 10);
        	lib.clickElement(byFields.xpath, lib.getProp(prop.aMyBill), 10);
        	
        	getCollector().setSla(60000);
        	Map<String, Object> myBill = new HashMap<>();
        	myBill.put("content", "Register");
        	myBill.put("timeout", "180");
        	myBill.put("measurement", "accurate");
        	Object resultMyBill = lib.getDriver().executeScript("mobile:checkpoint:text", myBill);
        	lib.addStep("trans_3", "My Bill", lib.getUXTimer());
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.aMainMenu), 10);
        	lib.addStep("trans_3", "TRAN_3", lib.getUXTimer());
        	
        	// clean app
//        	Map<String, Object> params13 = new HashMap<>();
//        	params13.put("name", "Telstra 24x7");
//        	//Object result13 = lib.getDriver().executeScript("mobile:application:clean", params11);
//        	Object result13 = lib.getDriver().executeScript("mobile:application:clean", params13);
        	 
        	
        	// close app
        	Map<String, Object> params12 = new HashMap<>();
        	params12.put("name", "Telstra 24x7");
        	Object result12 = lib.getDriver().executeScript("mobile:application:close", params12);
 
				
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			

		}
	}

}
