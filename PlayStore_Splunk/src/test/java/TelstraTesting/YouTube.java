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

public class YouTube extends ClassHelper {
	private androidHelper android;


	public void setPagesAndHelpers(library lib) throws IOException {
		
		lib.loadPropertyFile("PSElements.properties"); // -Update based on your properties file
	}

	
	@Test
	public void Login() throws Exception {
		try {
			try {
	        	System.out.println("----------Closing the application");
	        	//launch Youtube
	        	Map<String, Object> closeApp = new HashMap<>();
	        	closeApp.put("name", "Youtube");
	        	Object resultCloseApp = lib.getDriver().executeScript("mobile:application:close", closeApp);
	
			} catch (Exception ex) {
				// TODO Auto-generated catch block
//				ex.printStackTrace();
				System.out.println("----------App is already closed. Starting the application");	
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			

		}
	}

}
