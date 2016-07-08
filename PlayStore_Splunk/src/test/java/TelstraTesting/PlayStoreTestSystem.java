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

public class PlayStoreTestSystem extends ClassHelper {
	private androidHelper android;


	public void setPagesAndHelpers(library lib) throws IOException {
		
		lib.loadPropertyFile("PSElements.properties");
	}

	// this is comment from VM machine
	@Test
	public void Login() throws Exception {
		try {
			
			setPagesAndHelpers(lib);
			Map<String, Object> params1 = new HashMap<>();
        	Object result1 = lib.getDriver().executeScript("mobile:handset:ready", params1);
        	try {
        		lib.closeApplication("Google Play Store");
        		
        		Map<String, Object> params16 = new HashMap<>();
    			params16.put("name", "WhatsApp");
    			Object result16 =lib.getDriver().executeScript("mobile:application:uninstall", params16);
    			System.out.println("---------- App Uninstalled +++");
    		} catch (Exception ex) {
    			// TODO Auto-generated catch block
    			ex.printStackTrace();
    			System.out.println("----------Error App Uninstall+++");	
    		}
			
			lib.closeApplication("com.android.vending");

			lib.switchToContext(availableContexts.NATIVE_APP); 

			//launch Play Store
        	lib.clickElement(byFields.xpath, lib.getProp(prop.PlayStoreLaunch), 10);
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.PSclickSearch), 10);
		
			lib.setText(byFields.xpath, lib.getProp(prop.PSreadyText), "whatsapp", true, 10);
			
			lib.clickElement(byFields.xpath, lib.getProp(prop.PSfindList), 10);
			
			lib.clickElement(byFields.xpath, lib.getProp(prop.PSListApps), 10);
			
			getCollector().setSla(20000); //update SLA seconds 
			lib.StartTransaction("trans_1", "WhatsApp Search");
			Map<String, Object> params12 = new HashMap<>();
			params12.put("content", "Install");
			params12.put("timeout", "60");
			params12.put("threshold", "90");
			params12.put("measurement", "accurate");
			params12.put("source", "camera");
			Object result12 = lib.getDriver().executeScript("mobile:checkpoint:text", params12);
			lib.EndTransaction("trans_1", "WhatsApp Search");
			
			//lib.addStep("trans_1", "WhatsApp Search", lib.getUXTimer());
			
			lib.clickElement(byFields.xpath, lib.getProp(prop.PSclickInstall), 10);
			
			getCollector().setSla(320000); //update SLA seconds 
			lib.StartTransaction("trans_2", "Download");
			Map<String, Object> params11 = new HashMap<>();
			params11.put("content", "Uninstall");
			params11.put("timeout", "420");
			params11.put("threshold", "95");
			params11.put("measurement", "accurate");
			params11.put("source", "camera");
			Object result11 = lib.getDriver().executeScript("mobile:checkpoint:text", params11);
			lib.EndTransaction("trans_2", "Download");
			
			//lib.addStep("trans_2", "Download", lib.getUXTimer());
			
			lib.clickElement(byFields.xpath, lib.getProp(prop.PSlaunchBtn), 10);
		
			getCollector().setSla(20000); //update SLA seconds
			lib.StartTransaction("trans_3", "App Launched");
			Map<String, Object> params15 = new HashMap<>();
			params15.put("content", "Welcome to WhatsApp");
			params15.put("timeout", "50");
			params15.put("threshold", "90");
			params15.put("measurement", "accurate");
			params15.put("source", "camera");
			Object result15 = lib.getDriver().executeScript("mobile:checkpoint:text", params15);
			lib.EndTransaction("trans_3", "App Launched");
			
			
			//lib.addStep("trans_3", "App Launched", lib.getUXTimer());
			
			try {
				lib.closeApplication("com.android.vending");
        		
        		Map<String, Object> params16 = new HashMap<>();
    			params16.put("name", "WhatsApp");
    			Object result16 =lib.getDriver().executeScript("mobile:application:uninstall", params16);
    			System.out.println("---------- App Uninstalled +++");
    		} catch (Exception ex) {
    			// TODO Auto-generated catch block
    			ex.printStackTrace();
    			System.out.println("----------Error App Uninstall+++");	
    		}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			

		}
	}

}
