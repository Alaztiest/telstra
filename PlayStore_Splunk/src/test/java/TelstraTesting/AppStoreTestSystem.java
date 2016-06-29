package TelstraTesting;

import java.lang.reflect.Method;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class AppStoreTestSystem extends ClassHelper {
	private androidHelper android;
	protected RemoteWebDriver driver;
	
	public void setPagesAndHelpers(library lib) throws IOException {
		
		lib.loadPropertyFile("TelstraElements.properties");
	}

	
	@Test
	public void Login() throws Exception {
		try {
			setPagesAndHelpers(lib);
			Map<String, Object> params1 = new HashMap<>();
        	Object result1 = lib.getDriver().executeScript("mobile:handset:ready", params1);
		
        	try {
        		lib.closeApplication("App Store");
        		
        		Map<String, Object> params16 = new HashMap<>();
    			params16.put("name", "WhatsApp");
    			Object result16 =lib.getDriver().executeScript("mobile:application:uninstall", params16);
    			System.out.println("---------- App Uninstalled +++");
    		} catch (Exception ex) {
    			// TODO Auto-generated catch block
    			ex.printStackTrace();
    			System.out.println("----------Error App Uninstall+++");	
    		}
        	
        	// launch appstore 
        	lib.goToPage("https://itunes.apple.com/us/app/whatsapp-messenger/id310633997?mt=8");
        	//added from my Mac
			Map<String, Object> params12 = new HashMap<>();
			params12.put("content", "whatsapp");
			params12.put("timeout", "60");
			Object result12 = lib.getDriver().executeScript("mobile:checkpoint:text", params12);
			lib.addStep("trans_1", "App Search", lib.getUXTimer());
        	
        	lib.switchToContext(availableContexts.NATIVE_APP);   // Switch to NATIVE
        				
			//appDownload
			lib.clickElement(byFields.xpath, lib.getProp(prop.appDownload), 60);
			
			Map<String, Object> params11 = new HashMap<>();
			params11.put("content", "Open");
			params11.put("timeout", "420");
			Object result11 = lib.getDriver().executeScript("mobile:checkpoint:text", params11);
			lib.addStep("trans_2", "Download", lib.getUXTimer());
			System.out.println("----------Open btn displayed +++");
			
			//open verify: 
			lib.clickElement(byFields.xpath, lib.getProp(prop.appOpen), 10);

			Map<String, Object> params13 = new HashMap<>();
			params13.put("content", "Agree & Continue");
			params13.put("timeout", "60");
			Object result13 = lib.getDriver().executeScript("mobile:checkpoint:text", params13);
			lib.addStep("trans_3", "App Launched", lib.getUXTimer());
			
			System.out.println("----------Application Launched +++");

			// uninstall Telstra
			try {
				//lib.switchToContext(availableContexts.NATIVE_APP);   // Switch to NATIVE
//				Map<String, Object> params16 = new HashMap<>();
//				params16.put("name", "com.telstra.telstra24x7iphone");
//				Object result16 = driver.executeScript("mobile:application:uninstall", params16);
			} catch (Exception ex) {
    			// TODO Auto-generated catch block
    			ex.printStackTrace();
    			System.out.println("---------- Uninstall fail +++");	
    		}
					
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			// uninstall Telstra
			//lib.switchToContext(availableContexts.NATIVE_APP);   // Switch to NATIVE
//			Map<String, Object> params16 = new HashMap<>();
//			params16.put("name", "Telstra");
//			Object result16 = driver.executeScript("mobile:application:uninstall", params16);
//			System.out.println("----------not found");			
		}
	}

}
