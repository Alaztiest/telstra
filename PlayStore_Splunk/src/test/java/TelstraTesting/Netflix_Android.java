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

public class Netflix_Android extends ClassHelper {
	private androidHelper android;


	public void setPagesAndHelpers(library lib) throws IOException {
		
		lib.loadPropertyFile("Netflix.properties"); // -Update based on your properties file
	}

	
	@Test
	public void Login() throws Exception {
		try {
			setPagesAndHelpers(lib);
			Map<String, Object> params1 = new HashMap<>();
        	Object result1 = lib.getDriver().executeScript("mobile:handset:ready", params1);
        	lib.switchToContext(availableContexts.NATIVE_APP);
        	
        	try {
	        	System.out.println("----------Closing the application");
	        	//launch Netflix
	        	Map<String, Object> closeApp = new HashMap<>();
	        	closeApp.put("name", "Netflix");
	        	Object resultCloseApp = lib.getDriver().executeScript("mobile:application:close", closeApp);
	
			} catch (Exception ex) {
				System.out.println("----------App is already closed. Starting the application");	
			}
			
			Map<String, Object> startApp = new HashMap<>();
        	startApp.put("name", "Netflix");
        	Object resultStartApp = lib.getDriver().executeScript("mobile:application:open", startApp);
			
        	getCollector().setSla(60000);
        	lib.StartTransaction("trans_1", "Netflix Launch");
        	Map<String, Object> appLaunch = new HashMap<>();
        	appLaunch.put("content", "Popular");
        	appLaunch.put("timeout", "180");
        	appLaunch.put("threshold", "90");
        	appLaunch.put("measurement", "accurate");
        	appLaunch.put("source", "camera");
        	Object resultAppLaunch = lib.getDriver().executeScript("mobile:checkpoint:text", appLaunch);
        	lib.EndTransaction("trans_1", "Netflix Launch");
        	
        	Map<String, Object> playPopular = new HashMap<>();
        	playPopular.put("label", "Popular");
        	playPopular.put("timeout", "20");
        	playPopular.put("label.direction", "above");
        	playPopular.put("label.offset", "10%");
        	Object resultPlayPopular = lib.getDriver().executeScript("mobile:button-text:click", playPopular);
        	
        	
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.AplayButton), 20);
 
        	
        	lib.sleep(10000);
        	
        	
        	
        	
        	
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			

		}
	}

}
