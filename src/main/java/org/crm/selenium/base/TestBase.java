package org.crm.selenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.crm.selenium.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ChromeOptions option;
	
	public TestBase() {
		
		//reading from the properties file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\anish\\eclipse-workspace\\FreeCRMAutomation\\src\\main\\java\\org"
					+ "\\crm\\selenium\\configs\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		
		public static void initialisation() {
			String browsername = prop.getProperty("browser");
			
			if (browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\anish\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver.exe");
//				option = new ChromeOptions();
//				option.setExperimentalOption("debuggerAddress", "localhost:9898");
//				
//				driver = new ChromeDriver(option);
				driver = new ChromeDriver();
			}else if(browsername.equals("FF")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\anish\\eclipse-workspace\\SeleniumFramework\\drivers\\chromedriver.exe");
				driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			//taking values from util class
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
			
			//launching the application url
			driver.navigate().to(prop.getProperty("url"));
			
		}
			
		public static void browserclose() {
			driver.close();
			driver.quit();
		}
	
}
