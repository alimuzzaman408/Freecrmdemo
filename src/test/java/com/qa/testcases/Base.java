package com.qa.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.util.Readconfig;

public class Base {
      
     Readconfig rc=new Readconfig();    
	 public String url=rc.geturl();
	 public String username=rc.getusername();
	 public String password=rc.getpasword();
	 public static WebDriver driver;
	 public static Logger logger;
	
	 
	@Parameters("browser")
	@BeforeTest
	public void setup(String br) {
		
		logger=Logger.getLogger("Freecrmdemo");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox")) {
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

	public static void captureScreen(WebDriver driver,String tname) throws IOException {

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir") +"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");


	}


}
