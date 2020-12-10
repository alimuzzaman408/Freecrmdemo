package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	public WebDriver ldriver;

	public WaitHelper(WebDriver sdriver) {

		ldriver=sdriver;
	}

	public void waitforelement(WebElement element,long timeoutinsecond) {

		WebDriverWait wait=new WebDriverWait(ldriver,timeoutinsecond);

		wait.until(ExpectedConditions.visibilityOf(element));



	}

}
