package utilities;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class testSetup {

	private RemoteWebDriver driver;
	private boolean device;
	public String SELENIUM_HUB_URL;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	private library lib;
	private String target;
	private String network;
	private String networkLatency;
	public String host;

	public testSetup(String targetEnvironment, RemoteWebDriver driver, String network, String networkLatency) {
		this.target = targetEnvironment;
		this.driver = driver;
		this.network = network;
		this.networkLatency = networkLatency;
	}

	// sets capabilities based on environment returned from testNG
	public void flowControl() {
		switch (target) {
//		case "Galaxy S6 Edge":
//		device = true;
//		//capabilities.setCapability("deviceName", "02157DF272D13612");
//		//capabilities.setCapability("deviceName", "30EDD233");//067C0546439C8F54
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("model", "Galaxy S6 Edge");
//		//capabilities.setCapability("model", "Galaxy S5");
//		capabilities.setCapability("browserName", "Chrome");
//		capabilities.setCapability("description", "Available US");
//		capabilities.setCapability("automationName", "PerfectoMobile");
//		break;
		
		case "Galaxy S6":
			device = true;
			//capabilities.setCapability("deviceName", "02157DF2A1B46C22"); //1015FA22A3292504
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "Galaxy S6");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("automationName", "Appium");
			//capabilities.setCapability("autoLaunch", true);
			//capabilities.setCapability("fullReset", true);
			//capabilities.setCapability("app", "PUBLIC:Samples/TestApp.apk");
			//capabilities.setCapability("appPackage", "com.android.vending");
			capabilities.setCapability("Name", "Google Play Store");
			capabilities.setCapability("description", "TelstraPOC");
			break;
		case "Galaxy S7":
			device = true;
			//capabilities.setCapability("deviceName", "02157DF2A1B46C22"); //1015FA22A3292504
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "Galaxy S7");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("automationName", "Appium");
			//capabilities.setCapability("autoLaunch", true);
			//capabilities.setCapability("fullReset", true);
			//capabilities.setCapability("app", "PUBLIC:Samples/TestApp.apk");
			//capabilities.setCapability("appPackage", "com.android.vending");
			capabilities.setCapability("Name", "Google Play Store");
			capabilities.setCapability("description", "TelstraPOC");
			break;
		/*case "Galaxy S5":
			device = true;
			//capabilities.setCapability("deviceName", "30EDD233"); //067C0546439C8F54
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "Galaxy S5");
			capabilities.setCapability("browserName", "Chrome");
			//capabilities.setCapability("description", "Mon-GalaxyS5-Boston");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
			case "iPhone-6":
			device = true;
			capabilities.setCapability("deviceName", "71EDDAE8C07850B0A910F2CF9E69A93095B996DA");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("model", "iPhone-6");
			capabilities.setCapability("browserName", "safari");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		case "iPhone-5S":
			device = true;
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("model", "iPhone-5S");
			capabilities.setCapability("browserName", "safari");
			//capabilities.setCapability("description", "Mon-iPhone5S-Boston");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		/*case "HTC One X":
			device = true;
			//capabilities.setCapability("deviceName", "HT29BW305170");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "HTC One X");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("description", "jeremy");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
	  case "Galaxy S6":
			device = true;
			capabilities.setCapability("deviceName", "02157DF2A1B46C22");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "Galaxy S6");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		case "iPad Mini":
			device = true;
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("model", "iPad Mini 2");
			capabilities.setCapability("browserName", "Safari");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		case "Galaxy S IV":
			device = true;
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "Galaxy S IV");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		case "WFTest LG G2":
			device = true;
			capabilities.setCapability("deviceName", "VS9804G1B5419F9");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "LG G2");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		case "WFTest I337 Galaxy S IV":
			device = true;
			capabilities.setCapability("deviceName", "1DCD723E");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "I337 Galaxy S IV");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
			*/
		case "iPhone-6S":
			device = true;
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("model", "iPhone-6S");
			capabilities.setCapability("browserName", "");
			capabilities.setCapability("automationName", "Appium");
			capabilities.setCapability("description", "TelstraPOC");
			break;
		case "iPhone-5":
			device = true;
			capabilities.setCapability("deviceName", "EBB620E023B3FA0A72CAF31B46A21A51213C590E");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("model", "iPhone-5");
			capabilities.setCapability("browserName", "");
			capabilities.setCapability("automationName", "Appium");
			//capabilities.setCapability("description", "TelstraPOC");
			break;
			/*
		case "Galaxy Tab":
			device = true;
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("model", "SCH-I705 Galaxy Tab 2");
			capabilities.setCapability("browserName", "mobileChrome");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		case "Firefox":
			device = false;
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "firefox");
			capabilities.setCapability("version", "");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;
		case "Chrome":
			device = false;
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "chrome");
			capabilities.setCapability("version", "");
			break;
		case "Internet Explorer":
			device = false;
			capabilities.setCapability("platform", Platform.ANY);
			capabilities.setCapability("browserName", "internet explorer");
			capabilities.setCapability("version", "");
			capabilities.setCapability("automationName", "PerfectoMobile");
			break;*/
		default:
			lib.errorCleanup();
			break;
		}
	}

	// connects to selenium grid at perfecto as well as establishes
	// device connectivity to mobile cloud
	public library driverAndLibrarySetup()
			throws UnsupportedEncodingException, MalformedURLException, InterruptedException {
		if (device) {
			capabilities.setCapability("windTunnelPersona", "empty");
			capabilities.setCapability("outputVisibility", "public");	
			capabilities.setCapability("scriptName", "TelstraMonitoring");	
			host = "demo.perfectomobile.com";
			
			String user = URLEncoder.encode("vahanm@perfectomobile.com", "UTF-8");
			String password = URLEncoder.encode("Hova8584", "UTF-8");
					
			// String host = "mobilecloud.perfectomobile.com";
			// String user = URLEncoder.encode("jeremyp@perfectomobile.com",
			// "UTF-8");
			// String password = URLEncoder.encode("Perfecto123", "UTF-8");

			// String host = "vzw.perfectomobile.com";
			// String user = URLEncoder.encode("jeremyp@perfectomobile.com",
			// "UTF-8");
			// String password = URLEncoder.encode("JP123!", "UTF-8");

			URL gridURL = new URL("http://" + user + ":" + password + "@" + host + "/nexperience/wd/hub");
			SELENIUM_HUB_URL = getConfigurationProperty("SELENIUM_HUB_URL", "test.selenium.hub.url",
					gridURL.toString());
		} else {
			host="127.0.0.1:5555";
			SELENIUM_HUB_URL = getConfigurationProperty("SELENIUM_HUB_URL", "test.selenium.hub.url",
					"http://"+host+"/wd/hub");
		}

		int z = 0;
		int tryCount = 0;
		while (z != 1) {
			try {
				
				
				
				driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), capabilities);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
				lib = new library(driver, target, 1, network, networkLatency);
				z = 1;
			} catch (Exception ex) {
				tryCount++;
				if (tryCount > 5) {
					z = 1;
					throw ex;
				} else {
					z=0;
					Thread.sleep(25000);
				}
			}
		}

		return lib;
	}

	// parses the cloud/grid connectivity parameters
	public String getConfigurationProperty(String envKey, String sysKey, String defValue) {
		String retValue = defValue;
		String envValue = System.getenv(envKey);
		String sysValue = System.getProperty(sysKey);
		// system property prevails over environment variable
		if (sysValue != null) {
			retValue = sysValue;
		} else if (envValue != null) {
			retValue = envValue;
		}
		return retValue;
	}
}
