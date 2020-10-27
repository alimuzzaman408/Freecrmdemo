package com.qa.testcases;
import org.testng.annotations.Test;

import com.qa.page.LoginPage;

public class Logintest extends Base{
	
	
	@Test
	public  void loginDemo() throws InterruptedException {		
		LoginPage lpage=new LoginPage(driver);
        lpage.setusername(username);
        logger.info("username entered");
		lpage.password(password);
		logger.info("password entered");
		Thread.sleep(3000);
		lpage.clickbtn();
		logger.info("Login button clicked ");
		lpage.titletest();
		logger.info("Title test passed");
	}





}
