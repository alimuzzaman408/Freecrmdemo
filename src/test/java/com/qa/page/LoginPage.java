package com.qa.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {	
	WebDriver driver;	
	public LoginPage(WebDriver ldriver) {	
		this.driver=ldriver;
		PageFactory.initElements(driver, this);			
	}


	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//input[@type='submit']")
	WebElement button;

	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;

	public void logout() {

		JavascriptExecutor js = (JavascriptExecutor)driver;
	 	js.executeScript("arguments[0].click();", logout) ; 

	}

	public void setusername(String uname) {
		username.clear();
		username.sendKeys(uname);

	}
	public void password(String pwd) {
		password.clear();
		password.sendKeys(pwd);

	}
	public void clickbtn() {
		button.click();

	}

	public void titletest() {

		System.out.println(driver.getTitle());






	}

}
