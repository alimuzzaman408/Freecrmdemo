package com.qa.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.WaitHelper;

public class LoginPage {
	WaitHelper waithelp;
	WebDriver driver;	
	public LoginPage(WebDriver ldriver) {	
		this.driver=ldriver;
		PageFactory.initElements(driver, this);	
		waithelp=new WaitHelper(ldriver);
		
		
	}


	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement button;

	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	
	public String gettitle() {
		  
		  return driver.getTitle();
		  
	  }
	

	public void logout() {
        waithelp.waitforelement(logout, 10);
		JavascriptExecutor js = (JavascriptExecutor)driver;
	 	js.executeScript("arguments[0].click();", logout) ; 

	}

	public void setusername(String uname) {
		
	   waithelp.waitforelement(username, 10);
		username.clear();
		username.sendKeys(uname);

	}
	public void password(String pwd) {
		waithelp.waitforelement(password, 10);
		password.clear();
		password.sendKeys(pwd);

	}
	public void clickbtn() {
		button.click();

	}

	

}
