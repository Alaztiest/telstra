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
	        try {
	        	System.out.println("----------Closing the application");
	        	//launch Telstra 24x7
	        	Map<String, Object> closeApp = new HashMap<>();
	        	closeApp.put("name", "Telstra 24x7");
	        	Object resultCloseApp = lib.getDriver().executeScript("mobile:application:close", closeApp);
	
			} catch (Exception ex) {
				// TODO Auto-generated catch block
//				ex.printStackTrace();
				System.out.println("----------App is already closed. Starting the application");	
			}
        	
        
	        System.out.println("----------Starting the application");
	        Map<String, Object> startApp = new HashMap<>();
        	startApp.put("name", "Telstra 24x7");
        	Object resultStartApp = lib.getDriver().executeScript("mobile:application:open", startApp);
        	
        	System.out.println("----------Checking for the word \"Recharge\" on the screen");
        	getCollector().setSla(60000);
        	lib.StartTransaction("trans_1", "Telstra24x7 Launch");
        	Map<String, Object> appLaunch = new HashMap<>();
        	appLaunch.put("content", "Recharge");
        	appLaunch.put("timeout", "180");
        	appLaunch.put("threshold", "90");
        	appLaunch.put("measurement", "accurate");
        	appLaunch.put("source", "camera");
        	Object resultAppLaunch = lib.getDriver().executeScript("mobile:checkpoint:text", appLaunch);
        	lib.EndTransaction("trans_1", "Telstra24x7 Launch");
        	//lib.addStep("trans_1", "Telstra24x7 Launch", lib.getUXTimer());
        	
        	lib.switchToContext(availableContexts.NATIVE_APP);   // Switch to NATIVE

        	// verify menu
        	System.out.println("----------Open menu");
        	lib.clickElement(byFields.xpath, lib.getProp(prop.mainMenu), 10);
        	System.out.println("----------Click on Recharge");
        	lib.clickElement(byFields.xpath, lib.getProp(prop.myRecharge), 10);
        	
        	System.out.println("----------Checking for the word \"PayPal\" on the screen");
        	getCollector().setSla(60000);
        	lib.StartTransaction("trans_2", "Recharge");
        	Map<String, Object> myUsage = new HashMap<>();
        	myUsage.put("content", "PayPal");
        	myUsage.put("timeout", "180");
        	myUsage.put("threshold", "90");
        	myUsage.put("measurement", "accurate");
        	myUsage.put("source", "camera");
        	Object resultMyUsage = lib.getDriver().executeScript("mobile:checkpoint:text", myUsage);
        	lib.EndTransaction("trans_2", "Recharge");
        	
        	//lib.addStep("trans_2", "My Usage", lib.getUXTimer());
        	
//        	lib.clickElement(byFields.xpath, lib.getProp(prop.mainMenu), 10);
//        	lib.clickElement(byFields.xpath, lib.getProp(prop.myBill), 10);
//        	
//        	getCollector().setSla(60000);
//        	lib.StartTransaction("trans_3", "My Bill");
//        	Map<String, Object> myBill = new HashMap<>();
//        	myBill.put("content", "Register");
//        	myBill.put("timeout", "180");
//        	myBill.put("threshold", "90");
//        	myBill.put("measurement", "accurate");
//        	myBill.put("source", "camera");
//        	Object resultMyBill = lib.getDriver().executeScript("mobile:checkpoint:text", myBill);
//        	lib.EndTransaction("trans_3", "My Bill");
        	
        	//lib.addStep("trans_3", "My Bill", lib.getUXTimer());
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.mainMenu), 10);

        	// close app
        	System.out.println("----------Closing the application and ending the script");
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
