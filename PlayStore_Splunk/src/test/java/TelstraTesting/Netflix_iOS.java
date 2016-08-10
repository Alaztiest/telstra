package TelstraTesting;

import java.lang.reflect.Method;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;








import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pages.*;
import utilities.*;
import utilities.library.availableContexts;
import utilities.library.byFields;
import utilities.library.prop;

public class Netflix_iOS extends ClassHelper {
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
        	lib.setFluentWait(30, 500);
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
        	
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.playPopular), 10);
        	
        	lib.clickElement(byFields.xpath, lib.getProp(prop.playButton), 10);
        	
        	lib.getElementFluent(byFields.xpath, lib.getProp(prop.pauseBtn));
        	
        	long waitForPlay = lib.getUXTimer();
        	
        	long finaltime=0;
        	long runningtime=0;
        	Stopwatch stopwatch = Stopwatch.createStarted();
        	for(int i=0;i<=10;i++)
        	{
        	String timer1 = lib.getElement(byFields.xpath, lib.getProp(prop.remainingTime)).getText();
        runningtime=runningtime+lib.getSystemTimer();
        	lib.sleep(1000);
        	 runningtime=runningtime+1000;
        	String timer2 = lib.getElement(byFields.xpath, lib.getProp(prop.remainingTime)).getText();
        	 runningtime=runningtime+lib.getSystemTimer();
        	if(!timer1.equals(timer2))
        	{
        		break;
        	}
        	}
        	stopwatch.stop();
        	
        	finaltime=waitForPlay+(stopwatch.elapsed(TimeUnit.MILLISECONDS)-runningtime);
        	System.out.println(finaltime);
        	
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
			

		}
	}

}
