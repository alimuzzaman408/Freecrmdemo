package com.qa.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.page.LoginPage;

public class Logintest extends Base{
	
	
	@Test
	public  void loginDemo() throws InterruptedException, IOException {		
		LoginPage lpage=new LoginPage(driver);
        lpage.setusername(username);
        logger.info("username entered");
		lpage.password(password);
		logger.info("password entered");
		Thread.sleep(3000);
		lpage.clickbtn();
		logger.info("Login button clicked ");
		
		if(lpage.gettitle().equals("CRMPRO")) {
			Assert.assertTrue(true);
			logger.info("Title test passed");
		}
		else {
			captureScreen(driver,"Logintest");
			Assert.assertTrue(false);
			logger.info("Title test failed");
		}
		
		
		
	}





}
