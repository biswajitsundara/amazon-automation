package com.framework.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

	public WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;

	public WebDriver getWebDriver() {
		
		String browserWindow = ConfigReader.getInstance().getProperty("browserWindow");
		
		if (driver == null) {
			driver = new ChromeDriver();
		} 
		if(browserWindow.equals("Max")) {
			driver.manage().window().maximize();
		}
		
		return driver;
	}

	public WebDriverWait getWebDriverWait() {
		int waitTime = ConfigReader.getInstance().getintProperty("waitTime");
		
		if (wait == null) {
			return wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		} else
			return wait;
	}

	public Actions getActionDriver() {

		if (actions == null) {
			return actions = new Actions(driver);
		} else
			return actions;
	}
}
