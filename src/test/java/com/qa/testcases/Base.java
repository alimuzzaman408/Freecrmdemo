package com.qa.testcases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.util.Readconfig;

public class Base {
      
     Readconfig rc=new Readconfig();    
	 public String url=rc.geturl();
	 public String username=rc.getusername();
	 public String password=rc.getpasword();
	 public static WebDriver driver;
	 public static Logger logger;
	
	 
	
	@BeforeTest
	public void setup() {
		
		logger=Logger.getLogger("Freecrmdemo");
		PropertyConfigurator.configure("log4j.properties");
		
		if(rc.getBrowsername().equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		}
		
		else if(rc.getBrowsername().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Driver/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterTest
	public void tearDown() {

		driver.quit();
	}



}
