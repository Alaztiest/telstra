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
		
		lib.loadPropertyFile("PSElements.properties"); //Update based on your properties file
	}

	
	@Test
	public void Login() throws Exception {
		try {
			
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			

		}
	}

}
