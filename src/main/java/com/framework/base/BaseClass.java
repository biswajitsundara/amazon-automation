package com.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver driver;
	public WebDriverWait wait;
	public ConfigReader configReader;
	Actions actions;

	public BaseClass(DriverFactory driverfactory) {
		this.driver = driverfactory.getWebDriver();
		this.wait = driverfactory.getWebDriverWait();
		this.actions = driverfactory.getActionDriver();
		this.configReader = ConfigReader.getInstance();

	}

	public void launchApplication() {
		String url = configReader.getProperty("appURL");
		driver.get(url);
	}

	public void clickElement(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}

	public void closeApplication() {
		driver.quit();
	}

	public void clickSubMenu(By menuItem, By subMenuItem) {
		wait.until(ExpectedConditions.elementToBeClickable(menuItem));
		WebElement mainMenu = driver.findElement(menuItem);
		actions.moveToElement(mainMenu).build().perform();

		wait.until(ExpectedConditions.elementToBeClickable(subMenuItem));
		WebElement subMenu = driver.findElement(subMenuItem);
		actions.moveToElement(subMenu);

		actions.click().build().perform();
	}

	public String getElementText(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getText();
	}
}
