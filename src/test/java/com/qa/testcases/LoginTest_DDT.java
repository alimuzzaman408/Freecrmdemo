package com.qa.testcases;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.page.LoginPage;
import com.qa.util.Testutil;

public class LoginTest_DDT extends Base{


	@Test(dataProvider="logindata")
	public void ddtloginTest(String user,String passswordw) throws InterruptedException {

		LoginPage lpage=new LoginPage(driver);
		lpage.setusername(user);
		logger.info("username entered");
		lpage.password(password);
		logger.info("password entered");

		Thread.sleep(3000);
		lpage.clickbtn();
		logger.info("Login button clicked ");
		lpage.titletest();
		logger.info("Title test passed");

		Thread.sleep(3000);
		lpage.logout();
		logger.info("Logout button clicked");

	}

	@DataProvider(name="logindata")
	String [][]getdata() throws IOException{

		String path=".//src/test/java/com/qa/testdata/Book1.xlsx";	

		int rownum=Testutil.getRowCount(path, "sheet1");
		int colcount=Testutil.getCellCount(path, "sheet1",1);

		String [][]logindata=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++) {

			for(int j=0;j<colcount;j++) {

				logindata[i-1][j]=Testutil.getCellData(path, "sheet1", i, j);
			}

		}

		return logindata;






	}



}
